import {AuthContext} from "../../Context/AuthProvider";
import {HttpHeadersContext} from "../../Context/HttpHeaderProvider";
import {useContext, useState} from "react";
import axios from "axios";
import {useParams} from "react-router-dom";

function Comment(props) {
    const {auth, setAuth} = useContext(AuthContext);
    const {headers, setHeaders} = useContext(HttpHeadersContext);

    const page = props.page;
    const comment = props.obj;
    const commentId = comment.id;
    const { boardId } = useParams(); // boardId, 파라미터 가져오기

    const [show, setShow] = useState(false);

    const [content, setContent] = useState(comment.contents);
    const changeContent = (event) => {
        setContent(event.target.value);
    };

    /* 댓글 삭제 */
    const deleteComment = async () => {
        await axios.delete(`http://localhost:8082/api/comment/delete/${commentId}`, {headers: headers})
            .then((resp) => {
                console.log("[BbsComment.js] deleteComment() success :D");
                console.log(resp.data);

                alert("답글을 성공적으로 삭제했습니다 :D");
                //삭제된 댓글 목록 다시 불러오기
                props.getCommentList(page);

            }).catch((err) => {
                console.log("[BbsComment.js] deleteComment() error :<");
                console.log(err);
            });
    }

    function updateToggle() {
        setShow(show => !show)
    }

    return (
        <>
            {/* 상단 영역 (댓글 작성자, 댓글 작성시간) */}
            <div className="my-1 d-flex justify-content-center">
                <div className="col-5">
                    <input type={"hidden"} value={comment.id}/>
                    <div className="row">
                        <span className="comment-id">{comment.createdBy}</span>
                    </div>
                    <div className="row">
                        <span>{comment.createdAt}</span>
                    </div>
                </div>

                <div className="col-4 d-flex justify-content-end">
                    {
                        /* 자신이 작성한 댓글인 경우에만 삭제 가능 */
                        (localStorage.getItem("id") == comment.createdBy) ?
                            <>
                                <button className="btn btn-outline-danger" onClick={deleteComment}><i className="fas fa-trash-alt"></i> 삭제</button>
                            </>
                            :
                            null
                    }
                </div>
            </div>

            {
                    <>
                        {/* 하단 영역 (댓글 내용) */}
                        <div className="my-3 d-flex justify-content-center">
                            <div className="col-10 comment">{content}</div>
                        </div>
                    </>
            }
        </>
    );

}

export default Comment;