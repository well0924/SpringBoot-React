import axios from "axios";
import { useContext, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import {HttpHeadersContext} from "../../Context/HttpHeaderProvider";

function CommentWrite(props){
    const { headers, setHeaders } = useContext(HttpHeadersContext);
    const boardId = props.boardId;

    const id = localStorage.getItem("id");

    const [content, setContent] = useState("");
    const navigate = useNavigate();

    const chageContent = (event) => {
        setContent(event.target.value);
    }

    const createComment = async () =>{
        const req = {contents : content}

        await axios.post(`http://localhost:8082/api/comment/create/${boardId}`,req,{headers:headers})
            .then((resp)=>{
                console.log("[CommentWrite.js] createComment() success :D");
                console.log(resp);
                alert('댓글을 작성했습니다.');
                navigate(0);
            }).catch((error)=>{
                console.log("[CommentWrite.js] createComment() error :<");
                console.log(error);
            });
    }

    return(
        <>
            <div className="my-1 d-flex justify-content-center">
                <div className="col-7">
                    <span className="comment-id" >{id}</span>
                </div>
                <div className="col-2 my-1 d-flex justify-content-end">
                    <button className="btn btn-outline-secondary" onClick={createComment}><i className="fas fa-comment-dots"></i> 댓글 추가</button>
                </div>
            </div>
            {/* 하단 영역 (댓글 내용) */}
            <div className="my-3 d-flex justify-content-center">
                <textarea className="col-10" rows="1" value={content} onChange={chageContent}></textarea>
            </div><br/><br/>
        </>
    );
}

export default CommentWrite;