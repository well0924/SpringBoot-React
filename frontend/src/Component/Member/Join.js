import axios from "axios";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Join(){
    const [userId,setUserId] = useState("");
    const [email, setEmail] = useState("");
    const [name, setName] = useState("");
    const [pwd, setPwd] = useState("");
    const [checkPwd, setCheckPwd] = useState("");
    const [passwordMatch, setPasswordMatch] = useState(true); // 비밀번호 일치 여부 추가

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
        setPasswordMatch(pwd === event.target.value);
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
    const duplicatedUserEmail = async (event) =>{
        await axios.get(`http://localhost:8082/api/user/email-check/${email}`)
            .then((resp) =>{
                console.log("[Join.js] duplicatedUserEmail() success :D");
                console.log(resp.data);

                if (resp.data === false) {
                    alert("사용 가능한 이메일입니다.");
                    setEmail(email);
                }else{
                    alert("이메일 중복!");
                    setEmail(email);
                }
                event.preventDefault();
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
    const memberJoin = async (event) =>{
        event.preventDefault();

        if (!passwordMatch) {
            alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
            return;
        }

        const req = {
            userId : userId,
            password : pwd,
            username : name,
            useremail : email
        };

        await axios.post(`http://localhost:8082/api/user/create`,req)
            .then((resp) => {
                console.log("[Join.js] join() success :D");
                console.log(resp.data);
                //회원가입이 되면 메인 페이지로 이동
                alert("회원가입이 되었습니다.");
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

    //로그인 페이지 이동
    const backToLogin = () =>{
        navigate("/login");
    };

    return (
        <div>
            <div className="container">
                <div className="row justify-content-md-center">
                    <div className="card">
                        <div className="card-header">회원가입</div>
                        <div className="card-body">
                                <label>Id</label>
                                <div className="input-group mb-3">
                                    <input type="text" className="form-control" value={userId} onChange={changeUserId}/>
                                    <button className="btn btn-outline-danger" onClick={duplicatedUserId}>
                                        <i className="fas fa-check"></i> 아이디 중복 확인
                                    </button>
                                </div>
                                <label>이메일</label>
                                <div className="input-group mb-3">
                                    <input type="text" className="form-control" value={email} onChange={changeEmail}/>
                                    <button className="btn btn-outline-danger" onClick={duplicatedUserEmail}>
                                        <i className="fas fa-check"></i> 이메일 중복 확인</button>
                                </div>
                                <div className="form-group">
                                    <label>이름</label>
                                    <input type="text" className="form-control" value={name} onChange={changeName}/>
                                </div>
                                <div className="form-group">
                                    <label>비밀번호</label>
                                    <input type="new-password" className="form-control" value={pwd}
                                           onChange={changePwd}/>
                                </div>
                                <div className="form-group">
                                    <label>비밀번호 확인</label>
                                    <input type="new-password" value={checkPwd}
                                           className={`form-control ${passwordMatch ? "" : "is-invalid"}`}
                                           onChange={changeCheckPwd}/>
                                    {!passwordMatch && (
                                        <div className="invalid-feedback">비밀번호와 비밀번호 확인이 일치하지 않습니다.</div>
                                    )}
                                </div>
                                <br/>
                                <div className="my-3 d-flex justify-content-center">
                                    <button onClick={memberJoin} type={"button"} className="btn btn-outline-secondary">회원가입</button>

                                    <button onClick={backToLogin} type={"button"} className="btn btn-outline-secondary">취소</button>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );

}

export default Join;