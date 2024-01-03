import React , { useRef } from "react";
import axios from "axios";
import { useState, useEffect } from "react";
import Comment from "./Comment.js"

function CommentList(props){
    const boardId = props.boardId;

    //댓글 목록
    const [commentList, setCommentList] = useState([]);

    // comment에서 참조
    const getCommentListRef  = useRef(null);

    const getCommentList = async () =>{
        await axios.get(`http://localhost:8082/api/comment/list/${boardId}`)
            .then((resp)=>{
                console.log(resp.data);
                setCommentList(resp.data);
            })
            .catch((error)=>{
                console.log(error);
            });
    }

    useEffect(() => {
        getCommentListRef.current = getCommentList;
        getCommentList();
    }, [boardId]);

    return(
        <>
            <div className="my-1 d-flex justify-content-center">
            </div>

            {
                commentList.map(function (comment, id) {
                    return (
                        <div className="my-5" key={id}>
                            <Comment obj={comment} key={id} getCommentList={getCommentListRef.current}/>
                        </div>
                    );
                })
            }
        </>
    );
}

export default CommentList;