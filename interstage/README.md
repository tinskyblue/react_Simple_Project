# react_Simple_Project
리액트 간단한 프로젝트

## React + vite + spring boot 로그인/회원가입 프로젝트

### 사용 기술
프론트엔드: React.js + Vite<br>
백엔드: Spring Boot 3.5.5, Mybatis<br>
DB: PostgreSQL<br>
IDE: Spring Tool Suite 4, VScode<br>

## 메인 페이지
<img width="344" height="293" alt="화면 캡처 2025-09-16 021943" src="https://github.com/user-attachments/assets/405d97c1-6326-41e7-a8fd-1a674e8404ce" />

## 회원가입 테스트
<img width="249" height="288" alt="화면 캡처 2025-09-16 021852" src="https://github.com/user-attachments/assets/c9e88f0d-51b2-454a-b64d-d6d4621a56af" />
<img width="457" height="152" alt="화면 캡처 2025-09-16 021823" src="https://github.com/user-attachments/assets/269b30a3-24a6-4ac0-aecd-fd60831072a3" />
<img width="614" height="472" alt="화면 캡처 2025-09-16 021930" src="https://github.com/user-attachments/assets/18096544-3bbc-43da-8ea3-7e4e724b5324" />

## 로그인 테스트
<img width="284" height="289" alt="화면 캡처 2025-09-16 022035" src="https://github.com/user-attachments/assets/f9cc60aa-5db4-47d8-bcab-f958973393ff" />
<img width="262" height="289" alt="화면 캡처 2025-09-16 022019" src="https://github.com/user-attachments/assets/04a10245-4b44-4419-a1a5-25e7c3711190" />

제대로 된 아이디 비밀번호 입력 시<br>
<img width="452" height="151" alt="화면 캡처 2025-09-16 022100" src="https://github.com/user-attachments/assets/084fe6a9-6615-45ae-afca-1c01c9a2fd4d" />

## 트러블슈팅
회원가입을 위한 CRUD를 만들고 
react(프론트엔드)와 spring boot(백엔드)간의 통신 테스트를 시도
통신 방식은 HTTP 요청/응답으로 
React에서는 axios를 사용해서 HTTP 요청을 보냄
Spring Boot Controller에서 요청을 받아서 Mybatis로 DB에 데이터를 조회
조회된 JAVA 객체를 HTTP Response로 반환
+ @RestControoler 어노테이션을 사용하면 Spring Boot가 내부적으로 Java객체를 JSON으로 변환해서 반환 (Json 직렬화)
+ 이 과정에서 Jackson 라이브러리가 기본 내장되어있기 때문에 별도로 import하지는 않음

### 에러 메시지
Access to fetch at 'http://localhost:8080/api/signup' from origin 'http://localhost:5173' has been blocked by CORS policy: 
No 'Access-Control-Allow-Origin' header is present on the requested resource.

서버 응답에 Access-Control-Allow-Origin 헤더가 없어서 브라우저가 요청을 차단함

웹 브라우저는 보안 때문에 다른 도메인 간 요청(Cross-Origin Request) 을 제한함

예: React 앱(http://localhost:5173)에서 Spring Boot 서버(http://localhost:8080)로 AJAX 요청을 하면 브라우저가 보안상 차단 이때 발생하는 오류가 대표적인 CORS 오류

즉, 프론트와 백엔드가 서로 다른 포트/도메인에서 동작할 때 브라우저가 막는 것

해결을 위해서는 브라우저가 막는 “다른 포트/도메인 요청”을 안전하게 허용하도록 서버에서 명시해 주는 것

해결을 위한 CORS(Cross-Origin Resource Sharing) 설정을 위한 WebMvcConfigurer 구현
