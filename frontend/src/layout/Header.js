import React from 'react';

const Header = () => {
    return (
        <header>
            <a href="/">홈</a>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="/board">게시판</a>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="/login">로그인</a>
            &nbsp;&nbsp;|&nbsp;&nbsp;
            <a href="/join">회원가입</a>
            <hr/>
        </header>
    );
};

export default Header;