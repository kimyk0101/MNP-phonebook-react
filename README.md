# MNP-Phonebook 프로젝트

> React + Spring Boot 기반으로 구현한 전화번호부 관리 미니 프로젝트입니다.  
> 프론트엔드와 백엔드 간의 연동 경험을 중점적으로 연습했으며,  
> 기본적인 CRUD 기능 구현과 RESTful 통신의 흐름을 학습하는 데에 목적이 있었습니다.

---

## 개발 기간
- 2025.01.27 (1일)

---

## 사용 기술

- Frontend: React.js (Vite, JSX)
- Backend: Spring Boot, Java, MyBatis
- DB: MySQL (또는 H2 등 설정에 따라 변경)
- 통신: REST API (Axios)

---

## 주요 폴더 구조

```text
backend (Spring Boot)
┣ controller
┣ service
┣ mappers (MyBatis)
┣ repository/vo
┗ application.properties

frontend (React)
┣ components
┃ ┣ PhonebookInput.jsx
┃ ┗ PhonebookList.jsx
┣ assets/css
┃ ┗ phonebook.css
┣ App.jsx
┗ main.jsx
```

---

## 구현 기능

- 전화번호 등록
- 전화번호 전체 조회
- 전화번호 수정
- 전화번호 삭제

---

## 실행 방법

1. 백엔드(Spring Boot)
   - `PhonebookApplication.java` 실행
   - DB 설정은 `application.properties` 참고

2. 프론트엔드(React)
   - `npm install`
   - `npm run dev`

> 프론트에서 작성한 전화번호 등록/삭제/수정 요청은 백엔드 API를 통해 DB와 연결됩니다.

---

## 느낀 점

> 이 프로젝트는 짧은 시간 안에 프론트엔드와 백엔드가 실제로 어떻게 연결되는지 감을 잡는 데 큰 도움이 되었습니다.  
> 특히 Axios를 통한 요청 흐름과 백엔드에서의 컨트롤러-서비스-DAO 구조를 체험해볼 수 있었던 실습이었습니다.
