import React, { useState ,useContext, useEffect} from 'react';
import { useNavigate } from 'react-router-dom';
import { AuthContext } from "../../Context/AuthProvider";
import { HttpHeadersContext } from "../../Context/HttpHeaderProvider";
import Form from 'react-bootstrap/Form';
import axios from 'axios';

const BoardWrite = () => {
    const { auth, setAuth } = useContext(AuthContext);
    const { headers, setHeaders } = useContext(HttpHeadersContext);
    const [files, setFiles] = useState([]); // 추가: 파일 목록 상태 추가

    const navigate = useNavigate();
    //게시글
    const [board, setBoard] = useState({
        title: '',
        contents: '',
    });

    const handleChangeFile = (event) => {
        // 총 5개까지만 허용
        const selectedFiles = Array.from(event.target.files).slice(0, 5);
        setFiles((prevFiles) => [...prevFiles, ...selectedFiles]);
    };

    const handleRemoveFile = (index) => {
        setFiles((prevFiles) => prevFiles.filter((_, i) => i !== index));
    };

    const { title, contents } = board; //비구조화 할당

    const onChange = (event) => {
        const { value, name } = event.target; //event.target에서 name과 value만 가져오기
        setBoard({
            ...board,
            [name]: value,
        });
    };

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

    //파일 업로드
    const fileUpload = async (boardId) => {
        console.log("업로드할 파일 목록:", files);
        // 파일 데이터 저장
        const fd = new FormData();
        files.forEach((file) => fd.append("file", file));

        await axios
            .post(`http://localhost:8082/api/file/upload/${boardId}`, fd, { headers: headers })
            .then((resp) => {
                console.log("[file.js] fileUpload() success :D");
                console.log(resp.data);

                alert("파일 업로드 성공 :D");
            })
            .catch((err) => {
                console.log("[FileData.js] fileUpload() error :<");
                console.log(err);
            });
    };

    //게시글 저장
    const saveBoard = async () => {
        await axios.post(`//localhost:8082/api/board/create`, board,{headers : headers})
            .then((res) => {
            console.log("[BoardWrite.js] createBbs() success :D");
            console.log(res.data);
            const boardId = res.data;
            console.log("boardId:", boardId);
            //파일 업로드
            if(files.length>0){
                fileUpload(boardId);
            }
            alert('게시글이 등록되었습니다.');
            navigate(-1);
        });
    };

    const backToList = () => {
        navigate('/board');
    };

    return (
        <Form>
            <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                <Form.Label>제목</Form.Label>
                <Form.Control type="input" name="title" value={title} onChange={onChange} />
            </Form.Group>
            <Form.Group className="mb-3" controlId="exampleForm.ControlTextarea1">
                <Form.Label>글 내용</Form.Label>
                <Form.Control as="textarea" name="contents" value={contents} onChange={onChange} rows={3} />
            </Form.Group>
            <Form.Group className="mb-3">
                <Form.Label>파일</Form.Label>
                {files.map((file, index) => (
                    <div key={index} style={{ display: "flex", alignItems: "center" }}>
                        <p>
                            <strong>FileName:</strong> {file.name}
                        </p>
                        <button className="delete-button" type="button" onClick={() => handleRemoveFile(index)}>
                            x
                        </button>
                    </div>
                ))}
                {files.length < 5 && (
                    <div>
                        <input type="file" name="file" onChange={handleChangeFile} multiple="multiple" />
                    </div>
                )}
            </Form.Group>
            <button className="btn btn-outline-secondary" onClick={saveBoard}>저장</button>
            <button className="btn btn-outline-secondary" onClick={backToList}>취소</button>
        </Form>
    );
};

export default BoardWrite;