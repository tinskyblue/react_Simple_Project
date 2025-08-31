# React + TypeScript + Vite

## 개요
React + Vite + Typescript 구성

## 라이브러리 설치
```
create vite@latest doit_list
cd doit_list
npm install
```
* 프레임워크 선택: React
* 언어 선택 TypeScript

```
npm install react-router-dom
npm install axios
```
React Router(페이지 이동 구현)와 Axios(Spring 백엔드 API와 연결) 설치

## 동작 스크립트
```
npm run dev
```

## 주요 폴더 및 리소스 구조 설명
```
src
todo_list/
│
├─ node_modules/             # 설치된 패키지들
│
├─ public/                   # 정적 파일 (favicon, index.html 등)
│   └─ index.html
│
├─ src/                      # 실제 소스 코드
│   ├─ assets/               # 이미지, 아이콘 등 정적 리소스
│   ├─ components/           # 재사용 가능한 React 컴포넌트
│   │   ├─ TodoList.tsx
│   │   └─ TodoItem.tsx
│   ├─ types.ts             # Todo 타입 정의
│   ├─ App.tsx               # 최상위 컴포넌트
│   ├─ main.tsx              # ReactDOM 렌더링 진입점
│   └─ index.css             # 전역 스타일
│
├─ package.json              # 프로젝트 정보 & 의존성
├─ tsconfig.json             # TypeScript 설정
├─ vite.config.ts            # Vite 설정
└─ yarn.lock / package-lock.json  # 패키지 잠금 파일
```
