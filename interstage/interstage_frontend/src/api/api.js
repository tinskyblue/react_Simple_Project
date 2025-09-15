// 백 엔드 API 호출을 모듈화
// URL 변경 시 여기만 수정하면 됨 

import axios from 'axios';

const API = axios.create({
  baseURL: 'http://localhost:8080/api', // 백엔드 주소
});

// 유저 관련 API
export const getUsers = () => API.get('/users');
export const signupUser = (user) => API.post('/users/signup', user);
export const loginUser = async (data) => {
  const response = await axios.post("http://localhost:8080/api/users/login", data);
  return response.data;
};

export default API;