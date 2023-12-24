import React, {useEffect, useState} from 'react';
import { Link, useNavigate } from "react-router-dom";
import Pagination from "react-js-pagination";

import axios from "axios";

const BoardList = () => {
    const navigate = useNavigate();
    const [boardList, setBoardList] = useState([]);
    const [page, setPage] = useState(1);
    const [pageSize, setPageSize] = useState(10);
    const [totalPages, setTotalPages] = useState(0);
    const [totalCnt, setTotalCnt] = useState(0);

    const getBoardList = async (page) => {
        try {
            const response = await axios.get("http://localhost:8082/api/board/list", {
                params: {"page": page - 1},
            });

            console.log("[BbsList.js] useEffect() success :D");
            console.log(response.data);
            console.log(response.data.content);
            console.log(response.data.totalPages);
            console.log(response.data.pageable.pageSize);

            setBoardList(response.data.content);
            setPageSize(response.data.pageSize);
            setTotalPages(response.data.totalPages);
            setTotalCnt(response.data.totalElements);
        } catch (error) {
            console.log("[BbsList.js] useEffect() error :<");
            console.log(error);
        }
    };

    //첫 로딩 시, 한 페이지만 가져옴
    useEffect(() => {
        getBoardList(1);
    }, []);

    //페이징 보여주기
    const changePage = (page) => {
        setPage(page);
        getBoardList(page);
    };

    const moveToWrite = () => {
        navigate('/write');
    };

    return (
        <div>
            <ul>
                {boardList.map((board) => (
                    // 4) map 함수로 데이터 출력
                    <Link to={`/board/${board.idx}`}>
                        {board.title}
                        <br/>
                    </Link>
                ))}
            </ul>
            <div className="App">
                <button className="btn btn-outline-secondary" onClick={moveToWrite}>글쓰기</button>
            </div>

            <Pagination
                className="pagination"
                activePage={page}
                itemsCountPerPage={pageSize}
                totalItemsCount={totalCnt}
                pageRangeDisplayed={totalPages}
                prevPageText={"‹"}
                nextPageText={"›"}
                onChange={changePage}
            />
        </div>
    );
};

export default BoardList;