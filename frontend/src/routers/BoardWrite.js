import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const BoardWrite = () => {
    const navigate = useNavigate();

    const [board, setBoard] = useState({
        title: '',
        contents: '',
    });

    const { title, contents } = board; //비구조화 할당

    const onChange = (event) => {
        const { value, name } = event.target; //event.target에서 name과 value만 가져오기
        setBoard({
            ...board,
            [name]: value,
        });
    };

    const saveBoard = async () => {
        await axios.post(`//localhost:8082/api/board/create`, board).then((res) => {
            alert('등록되었습니다.');
            navigate('/board');
        });
    };

    const backToList = () => {
        navigate('/board');
    };

    return (
        <div>
            <div>
                <span>제목</span>
                <input type="text" name="title" value={title} onChange={onChange} />
            </div>
            <br />
            <div>
                <span>내용</span>
                <textarea
                    name="contents"
                    cols="30"
                    rows="10"
                    value={contents}
                    onChange={onChange}
                ></textarea>
            </div>
            <br />
            <div>
                <button className="btn btn-outline-secondary" onClick={saveBoard}>저장</button>
                <button className="btn btn-outline-secondary" onClick={backToList}>취소</button>
            </div>
        </div>
    );
};
export default BoardWrite;