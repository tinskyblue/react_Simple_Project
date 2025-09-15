import { useState } from "react";
import { loginUser } from "../api/api";
import { useNavigate } from "react-router-dom";

function Login() {
  const navigate = useNavigate();
  const [form, setForm] = useState({ username: "", password: "" });
  const [error, setError] = useState("");

  const handleChange = (e) => setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const result = await loginUser(form);
      if (result.success) {
        alert("로그인 성공!");
        navigate("/");  // 로그인 성공 시 Home으로 이동
      } else {
        setError(result.message || "로그인 실패");
      }
    } catch (err) {
      console.error(err);
      setError("로그인 중 오류 발생");
    }
  };

  return (
    <div className="max-w-md mx-auto p-6 bg-white shadow-md rounded-md">
      <h2 className="text-2xl font-bold mb-4">로그인</h2>
      <form onSubmit={handleSubmit} className="flex flex-col space-y-4">
        <div>
          <input
            name="username"
            placeholder="아이디"
            value={form.username}
            onChange={handleChange}
            className="border p-2 rounded w-full"
          />
        </div>
        <div>
          <input
            type="password"
            name="password"
            placeholder="비밀번호"
            value={form.password}
            onChange={handleChange}
            className="border p-2 rounded w-full"
          />
        </div>
        {error && <p className="text-red-500">{error}</p>}
        <button type="submit" className="bg-blue-500 text-white p-2 rounded">
          Sign in
        </button>
      </form>
    </div>
  );
}

export default Login;
