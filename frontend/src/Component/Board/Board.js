import React, {useContext, useEffect} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import { AuthContext } from "../../Context/AuthProvider";
import {HttpHeadersContext} from "../../Context/HttpHeaderProvider";
import FileDisplay from "../File/FileList";

const Board = ({ idx, title, contents, createdBy,files,comment}) => {

    const navigate = useNavigate();

    const { auth, setAuth } = useContext(AuthContext);
    const { headers, setHeaders } = useContext(HttpHeadersContext);

    //게시글 목록 이동
    const moveToBoardList = () =>{
        navigate('/board');
    }
    //게시글 수정 화면 이동
    const moveToBoardUpdate = () =>{
        navigate('/update');
    }
    //게시글 삭제
    const deleteBoard = async()=>{
        if(window.confirm("게시글을 삭제하겠습니까??")){
            await axios.delete(`http://localhost:8082/api/board/`+idx,{headers : headers})
                .then((resp)=>{
                    console.log(resp);
                    alert('삭제되었습니다.');
                    console.log("[Board.js] deleteBoard() success :D");
                    navigate('/board');
                })
                .catch((err)=>{
                    console.log(err);

                    const resp = err.response;
                    if (resp.status === 400) {
                        alert(resp.data);
                    }
                });
        }
    }
    //게시글 수정

    useEffect(() => {
        // 컴포넌트가 렌더링될 때마다 localStorage의 토큰 값으로 headers를 업데이트
        setHeaders({
            Authorization: `Bearer ${localStorage.getItem("accessToken")}`,
        });
        console.log(localStorage.getItem("accessToken"));
        console.log(headers);
        // 로그인한 사용자인지 체크
        if (!auth) {
            alert("로그인 한 사용자만 사용할수 있습니다!");
            navigate(-1);
        }
    }, []);

    return (
        <div>
            <table className="table">
                <tbody>
                <tr>
                    <th className="table-primary">작성자</th>
                    <td>
                        <p className={"form-control"}>{createdBy}</p>
                    </td>
                </tr>
                <tr>
                    <th className="table-primary">제목</th>
                    <td>
                        <p className="form-control" size={"50px"}>{title}</p>
                    </td>
                </tr>

                <tr>
                    <th className="table-primary">내용</th>
                    <td>
                        <textarea className="form-control" rows="10" defaultValue={contents} readOnly></textarea>
                    </td>
                </tr>

                <tr>
                    <th className="table-primary">파일</th>
                    <td>
                        {/*파일 목록 보여주는 곳*/}
                    </td>
                </tr>
                </tbody>
            </table>

            <div className="my-5 d-flex justify-content-center">
                <button className="btn btn-outline-secondary" onClick={moveToBoardList}>
                    <i className="fas fa-pen"></i> 게시글 목록
                </button>
                {/*회원의 아이디가 일치하면 수정과 삭제를 할 수 있음.*/}
                {(auth === createdBy)?
                    <>
                        <button className="btn btn-outline-secondary" onClick={moveToBoardList}>
                            <i className="fas fa-pen"></i> 게시글 수정
                        </button>
                        <button className="btn btn-outline-secondary" onClick={deleteBoard}>
                            <i className="fas fa-pen"></i> 게시글 삭제
                        </button>
                    </>
                    :
                    null}
            </div>
        </div>
    );
};

export default Board;