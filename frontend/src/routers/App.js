import {Route, Routes} from "react-router-dom";
import BoardList from "../Component/Board/BoardList";
import BoardDetail from "../Component/Board/BoardDetail";
import BoardWrite from "../Component/Board/BoardWrite";
import Join from "../Component/Member/Join"
import Main from "../layout/Main";
import React from "react";
import Login from "../Component/Member/Login";
import Logout from "../Component/Member/Logout";

function App() {
  return (
      <Routes>
          {/*게시글 관련*/}
          <Route path="/" element={<Main />} />
          <Route path="/board" element={<BoardList/>}/>
          <Route path="/board/:idx" element={<BoardDetail/>}/>
          <Route path="/write" element={<BoardWrite />}/>
          {/*회원 관련*/}
          <Route path="/join" element={<Join/>}></Route>
          <Route path="/login" element={<Login/>}></Route>
          <Route path="/logout" element={<Logout/>}></Route>
      </Routes>
  );
}

export default App;
