import axios from "axios";
import {useState, useContext} from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../Context/AuthProvider";
import {HttpHeadersContext} from "../../Context/HttpHeaderProvider";

function Login(){

    const { auth, setAuth } = useContext(AuthContext);
    const { headers, setHeaders } = useContext(HttpHeadersContext);

    const navigate = useNavigate();

    const [id, setId] = useState("");
    const [pwd, setPwd] = useState("");

    const changeId = (event) => {
        setId(event.target.value);
    }

    const changePwd = (event) => {
        setPwd(event.target.value);
    }

    const login = async () =>{
        const req = {
            userId : id,
            password : pwd
        }

        try {
            await axios.post("http://localhost:8082/api/auth/login",req)
                .then((resp)=>{
                    console.log("[Login.js] login() success :D");
                    console.log(resp.data);

                    let accessToken = resp.data.accessToken;
                    let userId = resp.data.userId;
                    alert("로그인을 했습니다.");
                    //사용자 인증 정보 저장하기.
                    setAuth(userId);
                    setHeaders({"Authorization":`Bearer ${accessToken}`});
                    //로그인 성공후 메인페이지로 이동하기.
                    navigate("/");
                    localStorage.setItem("accessToken", accessToken);
                    localStorage.setItem("id",userId);
                });
        }catch (err){
            console.log("[Login.js] login() error :<");
            console.log(err);
        }
    }

    return(
        <div>
            <table className="table">
                <tbody>
                <tr>
                    <th className="col-3">아이디</th>
                    <td>
                        <input type="text" value={id} onChange={changeId} size="50px" />
                    </td>
                </tr>

                <tr>
                    <th>비밀번호</th>
                    <td>
                        <input type="password" value={pwd} onChange={changePwd} size="50px" />
                    </td>
                </tr>
                </tbody>
            </table>
            <br/>

            <div className="my-1 d-flex justify-content-center">
                <button className="btn btn-outline-secondary" onClick={login}><i className="fas fa-sign-in-alt"></i> 로그인</button>
            </div>
        </div>
    )
};

export default Login;