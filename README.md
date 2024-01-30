# Spring-boot & React 게시판

#### Spring-boot와 React를 활용한 SPA게시판 입니다. 

#### 목차

- 소개와 기능
  - 소개
  - 기능
- 프로젝트 구조 및 설계
  - DB 설계
  - API 설계
- 기술 스택
  - Back-End
  - Front-End
- 실행 화면
- 회고

<h2>1. 소개와 기능</h2>

----  

### 💬소개

지금까지 배운 것을 기반으로 SPA 방식의 프로젝트를 처음으로 구현해보았습니다.
웹 프로그래밍의 기본 소양으로 여겨지는 게시판을 직접 만들어 보면서 리액트에 적응을
하고 백엔드와 프론트엔드를 연동하는것을 목표로 했습니다.

- 참여인원: 1인
- RestApi + SPA(React)

### 🛠️구현기능

- 게시판
  - [x] 게시글 목록
  - [x] 게시글 페이징 + 검색
  - [x] 게시글 단일 조회
  - [x] 게시글 작성
  - [x] 게시글 수정
  - [x] 게시글 삭제
  - [x] 파일 업로드/다운로드

- 댓글
  - [x] 댓글 작성
  - [x] 댓글 수정
  - [x] 댓글 삭제

- 회원
  - [x] 회원 가입
  - [x] 로그인 / 로그아웃

<h2>2.프로젝트 구조 및 설계</h2>

-----

### 아키텍쳐



### DB

![tb_board](https://github.com/well0924/SpringBoot-React/assets/89343159/d31df023-9d97-4356-a44c-ec1eddb70ac2)

### 📌Backend

  - Java 17
  - Spring boot 2.6.3
  - Spring Security 3.0.4
  - Spring Data Jpa 3.0.4
  - Spring validation 3.0.4
  - Query Dsl 5.0.0
  - jwt 2.12.4
  - MariaDB 3.0.5

### 🎨Frontend

  - React 18.2
  - axious 1.6.2
  - http-proxy-middleware 2.0,6
  - react-router-dom 6.21.1
  - react-js-pagination 3.0.3

### Deploy


<h2>3.구현 화면</h2>

-----

### 메인페이지

![메인페이지](https://github.com/well0924/SpringBoot-React/assets/89343159/24400396-e33b-4bb2-a2fc-ae0992dc661d)

### 로그인

![ezgif com-video-to-gif-converter](https://github.com/well0924/SpringBoot-React/assets/89343159/ab51fabe-b5f6-4da9-91e7-76717e448b88)

### 로그아웃

![로그아웃](https://github.com/well0924/SpringBoot-React/assets/89343159/eec79b45-c31a-44d5-ac34-a0dc04464d8c)

### 회원 가입

![회원가입](https://github.com/well0924/SpringBoot-React/assets/89343159/c32cdc57-fa9d-47a5-b80e-888e15e6c996)

### 게시글 목록 & 검색 

![게시글 목록   검색](https://github.com/well0924/SpringBoot-React/assets/89343159/f4abd6fc-8a46-495b-ba20-5e1e314ded86)

### 게시글 조회 & 다운로드

![게시글 조회   다운로드](https://github.com/well0924/SpringBoot-React/assets/89343159/85e027ce-59ea-4e99-b7f4-da69c0537b95)

### 게시글 작성 & 파일 첨부

![게시글 작성   파일 첨부](https://github.com/well0924/SpringBoot-React/assets/89343159/2c4f685f-00d6-41bf-9558-c3bee5980363)

### 게시글 수정 & 삭제

![게시글 삭제](https://github.com/well0924/SpringBoot-React/assets/89343159/424cbb67-36d5-4bb2-8ff9-56ada18bab57)

![ReactApp-Chrome2024-01-3023-49-59-ezgif com-video-to-gif-converter](https://github.com/well0924/jpapractice/assets/89343159/2aae6583-79c4-4e46-90a5-970d432e2c23)

### 댓글 작성 & 삭제

![댓글 작성 삭제](https://github.com/well0924/SpringBoot-React/assets/89343159/d5e664ff-0321-4437-86ea-dca37390aa01)

<h2>4.소감</h2>

-----

### 회고

- 처음으로 리액트를 배우고자 스프링부트와 연동을 해서 간단한 게시판을 만들어 봤는데 처음으로 리액트를 다루는라 생각보다 시간이 많이 걸렸다는 점이 아쉬웠다.


- 짧은 기간동안 간단한 게시판을 만들다 보니 백엔드 부분에서 jwt로그인에서 refreshToken을 작성하지 않았고 재발급을 하지 않은 기능을 만들지 못한점이 아쉬웠다.

- 리액트에 대한 기본적인 기능을 구현할 수 있는 기회였고 좀더 공부를 해서 Redux나 ReactQuery에 대해서도 공부를 해야겠다.
