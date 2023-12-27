import axios from "axios";
import {useState, useContext} from "react";
import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../Context/AuthProvider";
import {HttpHeadersContext} from "../../Context/HttpHeaderProvider";
import Button from "react-bootstrap/Button";

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
        <div className="container">
            <div className="row justify-content-md-center">
                <div className="card">
                    <div className="card-header">Login</div>
                    <div className="card-body">
                        <form>
                            <div className="form-group">
                                <label htmlFor="exampleInputEmail1">Id</label>
                                <input type="input" className="form-control" aria-describedby="emailHelp"
                                       autoFocus
                                       value={id} onChange={changeId}/>
                            </div>
                            <div className="form-group">
                                <label htmlFor="exampleInputPassword1">Password</label>
                                <input type="password" className="form-control" value={pwd}
                                       onChange={changePwd}/>
                            </div>
                            <br/>
                            <Button onClick={login} type={"button"}>Login</Button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
};

export default Login;