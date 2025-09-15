import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { signupUser } from "../api/api";

function Signup() {
  const [form, setForm] = useState({
    username: "",
    password: "",
    confirmPassword: "",
    email: "",
  });
  const [errors, setErrors] = useState({});
  const navigate = useNavigate();

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // 유효성 검사 함수
  const validate = () => {
    const newErrors = {};

    // 아이디: 4~12자, 영문 최소 1자 포함, 숫자는 선택 가능
    const usernamePattern = /^(?=.*[A-Za-z])[A-Za-z0-9]{4,12}$/;
    if (!form.username || !usernamePattern.test(form.username)) {
      newErrors.username =
        "아이디는 4~12자, 최소 한 글자 이상의 영문 포함, 숫자는 선택 가능합니다.";
    }

    // 비밀번호: 8자 이상, 영문 최소 1자, 숫자, 특수문자 포함
    const passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&~]).{8,}$/;
    if (!form.password || !passwordPattern.test(form.password)) {
      newErrors.password =
    "비밀번호는 최소 8자 이상, 영문 1자 이상, 숫자와 특수문자를 포함해야 합니다.";
  }

    // 비밀번호 확인
    if (form.password !== form.confirmPassword) {
      newErrors.confirmPassword = "비밀번호가 일치하지 않습니다.";
    }

    // 이메일 형식
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!form.email || !emailPattern.test(form.email)) {
      newErrors.email = "유효한 이메일을 입력해주세요.";
    }

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (!validate()) return; // 유효성 검사 실패 시 API 호출 막음

    try {
      await signupUser(form);
      alert("회원가입 성공");
      navigate("/");
    } catch (err) {
      console.error(err);
      alert("회원가입 실패");
    }
  };

  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-50">
      <div className="w-full max-w-md bg-white p-8 rounded-xl shadow-md">
        <h2 className="text-2xl font-bold mb-6 text-center text-gray-700">
          회원가입
        </h2>
        <form onSubmit={handleSubmit} className="space-y-4">
          {/* 아이디 */}
          <div>
            <input
              name="username"
              placeholder="아이디"
              value={form.username}
              onChange={handleChange}
              className="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-400"
            />
            {errors.username && (
              <p className="text-red-500 text-sm mt-1">{errors.username}</p>
            )}
          </div>

          {/* 비밀번호 */}
          <div>
            <input
              type="password"
              name="password"
              placeholder="비밀번호"
              value={form.password}
              onChange={handleChange}
              className="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-400"
            />
            {errors.password && (
              <p className="text-red-500 text-sm mt-1">{errors.password}</p>
            )}
          </div>

          {/* 비밀번호 확인 */}
          <div>
            <input
              type="password"
              name="confirmPassword"
              placeholder="비밀번호 확인"
              value={form.confirmPassword}
              onChange={handleChange}
              className="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-400"
            />
            {errors.confirmPassword && (
              <p className="text-red-500 text-sm mt-1">
                {errors.confirmPassword}
              </p>
            )}
          </div>

          {/* 이메일 */}
          <div>
            <input
              type="email"
              name="email"
              placeholder="이메일"
              value={form.email}
              onChange={handleChange}
              className="w-full px-3 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-indigo-400"
            />
            {errors.email && (
              <p className="text-red-500 text-sm mt-1">{errors.email}</p>
            )}
          </div>

          {/* 회원가입 버튼 */}
          <button
            type="submit"
            className="w-full bg-indigo-500 text-white py-2 rounded-lg hover:bg-indigo-600 transition"
          >
            회원가입
          </button>
        </form>
      </div>
    </div>
  );
}

export default Signup;
