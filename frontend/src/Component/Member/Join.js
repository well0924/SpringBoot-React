import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router";

function Join(){

    const [userId,setUserId] = useState("");
    const [email, setEmail] = useState("");
    const [name, setName] = useState("");
    const [pwd, setPwd] = useState("");
    const [checkPwd, setCheckPwd] = useState("");

    const navigate = useNavigate();

    const changeUserId = (event) =>{
        setUserId(event.target.value);
    }
    const changeEmail = (event) => {
        setEmail(event.target.value);
    }

    const changeName = (event) => {
        setName(event.target.value);
    }

    const changePwd = (event) => {
        setPwd(event.target.value);
    }

    const changeCheckPwd = (event) => {
        setCheckPwd(event.target.value);
    }

    //회원 아이디 중복
    const duplicatedUserId = async () =>{
        await axios.get(`http://localhost:8082/api/user/id-check/${userId}`)
            .then((resp) => {
                console.log("[Join.js] duplicatedUserId() success :D");
                console.log(resp.data);

            if (resp.data===false) {
                alert("사용 가능한 아이디입니다.");
            }else {
                alert("아이디 중복!!");
            }
        }).catch((err) => {
                console.log("[Join.js] duplicatedUserId() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status === 400) {
                    alert(resp.data);
                }
            });
    };

    //회원 이메일 중복처리.
    const duplicatedUserEmail = async () =>{
        await axios.get(`http://localhost:8082/api/user/email-check/${email}`)
            .then((resp) =>{
                console.log("[Join.js] duplicatedUserEmail() success :D");
                console.log(resp.data);

                if (resp.data === false) {
                    alert("사용 가능한 이메일입니다.");
                }else{
                    alert("이메일 중복!");
                }
            })
            .catch((err) => {
                console.log("[Join.js] duplicatedUserEmail() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status === 400) {
                    alert(resp.data);
                }
            });
    };

    //회원 가입
    const memberJoin = async () =>{
        const req = {
            userId : userId,
            password : pwd,
            username : name,
            useremail : email
        }
        await axios.post(`http://localhost:8082/api/user/create`,req)
            .then((resp) => {
                console.log("[Join.js] join() success :D");
                console.log(resp.data);
                //회원가입이 되면 메인 페이지로 이동
                navigate("/");
            }).catch((err) => {
                console.log("[Join.js] join() error :<");
                console.log(err);

                const resp = err.response;
                if (resp.status === 400) {
                    alert(resp.data);
                }
            });
    };

    const backToLogin = () =>{
        navigate("/login");
    };

    return (
        <div>
            <table className="table">
                <tbody>
                <tr>
                    <th className="col-2">아이디</th>
                    <td>
                        <input type="text" value={userId} onChange={changeUserId} size="50px" /> &nbsp; &nbsp;
                        <button className="btn btn-outline-danger" onClick={duplicatedUserId}>
                            <i className="fas fa-check"></i> 아이디 중복 확인</button>
                    </td>
                </tr>

                <tr>
                    <th className="col-2">이메일</th>
                    <td>
                        <input type="text" value={email} onChange={changeEmail} size="50px" /> &nbsp; &nbsp;
                        <button className="btn btn-outline-danger" onClick={duplicatedUserEmail}>
                            <i className="fas fa-check"></i> 이메일 중복 확인</button>
                    </td>
                </tr>

                <tr>
                    <th>이름</th>
                    <td>
                        <input type="text" value={name} onChange={changeName} size="50px" />
                    </td>
                </tr>

                <tr>
                    <th>비밀번호</th>
                    <td>
                        <input type="password" value={pwd} onChange={changePwd} size="50px" />
                    </td>
                </tr>

                <tr>
                    <th>비밀번호 확인</th>
                    <td>
                        <input type="password" value={checkPwd} onChange={changeCheckPwd} size="50px" />
                    </td>
                </tr>
                </tbody>
            </table><br />

            <div className="my-3 d-flex justify-content-center">
                <button className="btn btn-outline-secondary" onClick={memberJoin}><i className="fas fa-user-plus"></i> 회원가입</button>
                <button className="btn btn-outline-secondary" onClick={backToLogin}><i className="fas fa-user-plus"></i>취소</button>
            </div>
        </div>
    );

}

export default Join;