import React from "react";
import {useNavigate} from "react-router";
import axios from "axios";


const Board = ({ idx, title, contents, createdBy }) => {
    const navigate = useNavigate();

    //게시글 목록
    const moveToBoardList = () =>{
        navigate('/board');
    }
    //게시글 삭제
    const deleteBoard = async()=>{
        if(window.confirm("게시글을 삭제하겠습니까??")){
            await axios.delete(`http://localhost:8082/api/board/`+idx)
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
    return (
        <div>
            <input type={"hidden"} value={idx}/>
            <h2>제목:{title}</h2>
            <h5>작성자:{createdBy}</h5>
            <hr/>
            <p>{contents}</p>
            <button className="btn btn-outline-secondary" onClick={deleteBoard}>게시글 삭제</button>

            <button className="btn btn-outline-secondary" onClick={moveToBoardList}>게시글 목록</button>
        </div>
    );
};

export default Board;