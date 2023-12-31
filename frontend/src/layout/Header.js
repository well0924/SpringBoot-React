import React, {useContext} from 'react';
import {AuthContext} from "../Context/AuthProvider";

const Header = () => {
    const { auth, setAuth } = useContext(AuthContext);
    console.log(auth);
    return (
        <header>
            <a href="/">홈</a>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            {auth?(<>
                <a href="/board">게시판</a>
                &nbsp;&nbsp;|&nbsp;&nbsp;
                <a href="/logout">로그아웃</a>
                &nbsp;&nbsp;|&nbsp;&nbsp;
                </>
                ):(
                <>
                <a href="/join">회원가입</a>
                &nbsp;&nbsp;|&nbsp;&nbsp;
                <a href="/login">로그인</a>
                </>
            )}
            <hr/>
        </header>
    );
};

export default Header;