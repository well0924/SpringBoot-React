package com.example.springboot_react_example.controller;

import com.example.springboot_react_example.domain.dto.UserRequest;
import com.example.springboot_react_example.domain.dto.UserResponse;
import com.example.springboot_react_example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/list")
    public ResponseEntity<?> userList(@PageableDefault Pageable pageable){
        Page<UserResponse> list = userService.userList(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getMember(@PathVariable("id")Long id){
        UserResponse response = userService.getUser(id);
        //조회할 회원이 없는 경우
        if(response==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/create")
    public ResponseEntity<?>createUser(@RequestBody UserRequest request){
        Long result = userService.userCreate(request);
        if(result >0){
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        else{
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateUser(@PathVariable("id")Long id,@RequestBody UserRequest request){
        Long result = userService.userUpdate(id,request);
        if(result >0){
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteUser(@PathVariable("id")Long id){
        userService.userDelete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/id-check/{userId}")
    public ResponseEntity<?>duplicatedUserId(@PathVariable("userId") String userId){
        boolean result = userService.duplicatedUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/email-check/{email}")
    public ResponseEntity<?>duplicatedUserEmail(@PathVariable("email") String userEmail){
        boolean result = userService.duplicatedUserEmail(userEmail);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
