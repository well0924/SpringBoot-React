import React, {useEffect, useState} from 'react';
import { Link, useNavigate } from "react-router-dom";
import Pagination from "react-js-pagination";
import axios from "axios";
import "../../Css/Page.css";

const BoardList = () => {
    const navigate = useNavigate();
    //게시글 목록
    const [boardList, setBoardList] = useState([]);

    //검색
    const [searchType,setSearchType ]= useState("");
    const [searchVal,setSearchVal ]= useState("");

    const changeSearchType = (event) =>{
        setSearchType(event.target.value);
    }
    const changeSearchValue = (event) =>{
        setSearchVal(event.target.value);
    }

    //페이징
    const [page, setPage] = useState(1);
    const [pageSize, setPageSize] = useState(10);
    const [totalPages, setTotalPages] = useState(0);
    const [totalCnt, setTotalCnt] = useState(0);

    //페이징 보여주기
    const changePage = (page,pageSize,totalPages,totalCnt) => {
        setPage(page);
        setPageSize(pageSize);
        setTotalPages(totalPages);
        setTotalCnt(totalCnt);
        getBoardList(page);
    };

    //게시글 목록
    const getBoardList = async (page) => {
        try {
            const response = await axios.get("http://localhost:8082/api/board/list", {
                params: {"page": page - 1},
            });

            console.log("[BoardList.js] useEffect() success :D");
            console.log(response.data);
            console.log(response.data.content);
            console.log(response.data.totalPages);
            console.log(response.data.pageable.pageSize);

            setBoardList(response.data.content);
            setPageSize(response.data.pageSize);
            setTotalPages(response.data.totalPages);
            setTotalCnt(response.data.totalElements);
        } catch (error) {
            console.log("[BoarList.js] useEffect() error :<");
            console.log(error);
        }
    };

    //게시글 검색
    const search = async ()=>{
        try{
            const response = await axios
                .get("http://localhost:8082/api/board/search",{
                    params:{
                        page : page-1,
                        searchType : searchType,
                        searchVal : searchVal
                    }
                }).then((resp)=>{
                    console.log(resp.data);
                    console.log("[BoardList.js] search success :D");
                    setBoardList(resp.data.content);
                    setPageSize(response.data.pageSize);
                    setTotalCnt(response.data.totalElements);
                });
        }catch (err){
            console.log("[BoardList.js] search error :<");
            console.log(err);
        }
    };

    //첫 로딩 시, 한 페이지만 가져옴
    useEffect(() => {
        getBoardList(1);
    }, []);
    
    //게시글 작성 페이지로 이동
    const moveToWrite = () => {
        navigate('/write');
    };

    return (
        <div>
            {/*게시글 검색*/}
            <br />
            <div>
                <select name="searchType" onChange={changeSearchType}>
                    <option value="">-선택-</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                    <option value="created_by">작성자</option>
                </select>
                <input type="text" name="searchVal" value={searchVal} onChange={changeSearchValue} />
                <button onClick={search}>검색</button>
            </div>
            {/*게시글 목록*/}
            <ul>
                {boardList.map((board) => (
                    // 4) map 함수로 데이터 출력
                    <Link to={`/board/${board.idx}`} key={board.idx}>
                        {board.title}
                        <br/>
                    </Link>
                ))}
            </ul>
            <div>
                <button className="btn btn-outline-secondary" onClick={moveToWrite}>글쓰기</button>
            </div>
            {/* 페이징 */}
            <div>
                <Pagination
                    activePage={page}
                    itemsCountPerPage={pageSize}
                    totalItemsCount={totalCnt}
                    pageRangeDisplayed={totalPages}
                    prevPageText={"‹"}
                    nextPageText={"›"}
                    onChange={changePage}>
                </Pagination>
            </div>
        </div>
    );
};

export default BoardList;