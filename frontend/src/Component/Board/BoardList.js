import React, {useEffect, useState} from 'react';
import { Link, useNavigate } from "react-router-dom";
import Pagination from "react-js-pagination";
import Button from 'react-bootstrap/Button';
import axios from "axios";
import Table from 'react-bootstrap/Table';
import "../../Css/Page.css";

const BoardList = () => {
    const navigate = useNavigate();
    //게시글 목록
    const [boardList, setBoardList] = useState([]);

    //검색
    const [searchType,setSearchType ]= useState("");
    const [searchValue,setSearchVal ]= useState("");

    //페이징
    const [page, setPage] = useState(1);
    const [pageSize, setPageSize] = useState(10);
    const [totalPages, setTotalPages] = useState(0);
    const [totalCnt, setTotalCnt] = useState(0);

    //게시글 목록
    const getBoardList = async (page) => {
        try {
            const response = await axios.get("http://localhost:8082/api/board/list", {
                params: {"page": page - 1},
            });
            console.log(response.data.content);
            console.log("[BoardList.js] useEffect() success :D");
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
    const search = async (page)=>{
        try{
            const response = await axios
                .get("http://localhost:8082/api/board/search",{
                    params:{
                        "page" : page-1,
                        "searchType" : searchType,
                        "searchVal" : searchValue
                    }
                });
                    console.log(response.data);
                    console.log("[BoardList.js] search success :D");
                    setBoardList(response.data.content);
                    setPageSize(response.data.pageSize);
                    setTotalPages(response.data.totalPages);
                    setTotalCnt(response.data.totalElements);

        }catch (err){
            console.log("[BoardList.js] search error :<");
            console.log(err);
        }
    };

    const changeSearchType = (event) =>{
        setSearchType(event.target.value);
    }
    const changeSearchValue = (event) =>{
        setSearchVal(event.target.value);
    }

    //페이징 보여주기
    const changePage = (page) => {
        setPage(page);
        getBoardList(page).then(r => console.log("list"));
        search(page).then(s=>console.log("searchList"));
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
            <h2 className="text-center">Boards List</h2>
            {/*게시글 검색*/}
            <br />
            <div className={"d-grid gap-2 d-md-flex justify-content-md-end"}>
                <select name="searchType" onChange={changeSearchType}>
                    <option value="">-선택-</option>
                    <option value="TITLE">제목</option>
                    <option value="CONTENTS">내용</option>
                    <option value="AUTHOR">작성자</option>
                </select>
                <input type="text" name="searchVal" value={searchValue} onChange={changeSearchValue} />
                <Button variant="primary" onClick={search}>검색</Button>
            </div>
            {/*게시글 목록*/}
            {boardList.length === 0 ? (
                <Table>
                    <tbody>
                        <tr>
                            <td colSpan="4" className="text-center">게시글이 없습니다.</td>
                        </tr>
                    </tbody>
                </Table>
            ) : (
                <Table className={"responsive"}>
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">제목</th>
                            <th scope="col">작성자</th>
                            <th scope="col">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                        {boardList.map((board) => (
                        // 4) map 함수로 데이터 출력
                        <tr key={board.idx}>
                            <td>{board.idx}</td>
                            <td>
                                <Link to={`/board/${board.idx}`} key={board.idx}>
                                {board.title}
                                </Link>
                            </td>
                            <td>{board.createdBy}</td>
                            <td>{board.createdAt}</td>
                        </tr>
                ))}
                    </tbody>
                </Table>
                )}
            {/* 글 작성 */}
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