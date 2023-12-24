import {Route, Routes} from "react-router-dom";
import BoardList from "./routers/BoardList";
import BoardDetail from "./routers/BoardDetail";
import BoardWrite from "./routers/BoardWrite";
import Main from "./layout/Main";
import React from "react";

function App() {
  return (
      <Routes>
          <Route path="/" element={<Main />} />
          <Route path="/board" element={<BoardList/>}/>
          <Route path="/board/:idx" element={<BoardDetail/>}/>
          <Route path="/write" element={<BoardWrite />} />
      </Routes>
  );
}

export default App;
