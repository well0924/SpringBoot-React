package com.example.springboot_react_example.service;

import com.example.springboot_react_example.domain.Const.UserRole;
import com.example.springboot_react_example.domain.Member;
import com.example.springboot_react_example.domain.dto.UserRequest;
import com.example.springboot_react_example.domain.dto.UserResponse;
import com.example.springboot_react_example.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserResponse> userList(Pageable pageable){
        return userRepository.userList(pageable);
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(Long userIdx){
        Member member = userRepository.findById(userIdx).get();
        return UserResponse.builder()
                .id(member.getId())
                .userId(member.getUserId())
                .useremail(member.getUseremail())
                .username(member.getUsername())
                .userRole(member.getUserRole())
                .createdTime(member.getCreatedTime())
                .build();
    }

    @Transactional
    public Long userCreate(UserRequest request){
        //이메일 중복
        duplicatedUserEmail(request.getUseremail());

        Member member = Member
                .builder()
                .userId(request.getUserId())
                .username(request.getUsername())
                .useremail(request.getUseremail())
                .userRole(UserRole.ROLE_USER)
                .createdTime(LocalDateTime.now())
                .build();
        userRepository.save(member);
        return member.getId();
    }

    @Transactional
    public Long userUpdate(Long id,UserRequest request){
        Optional<Member>detail = userRepository.findById(id);
        detail.ifPresent(u->{
            if(request.getUserId()!=null){
                u.setUserId(request.getUserId());
            }
            if(request.getUsername()!=null){
                u.setUsername(request.getUsername());
            }
            if(request.getUseremail()!=null){
                u.setUseremail(request.getUseremail());
            }
            this.userRepository.save(u);
        });
        return detail.get().getId();
    }

    public void userDelete(Long id){
        Optional<Member>detail = userRepository.findById(id);
        userRepository.deleteById(detail.get().getId());
    }

    public void duplicatedUserEmail(String userEmail){
        userRepository.existsByUseremail(userEmail);
    }
}
