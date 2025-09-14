import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from "./pages/Home";
import Signup from "./pages/Signup";
import './App.css'

function App() {
  return (
    <BrowserRouter>
      <nav>
        <Link to="/">홈</Link> | <Link to="/signup">회원가입</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signup" element={<Signup />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App
