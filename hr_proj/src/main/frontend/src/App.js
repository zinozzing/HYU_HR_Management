import logo from "./logo.svg";
import hy_logo from "./hy_logo.png";
import "./App.css";
import React, { useState, useEffect } from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Login from "./pages/Login";
import axios from "axios";

function App() {
  // eslint-disable-next-line
  const [testStr, setTestStr] = useState("");

  function callback(str) {
    setTestStr(str);
  }

  useEffect(() => {
    axios({
      url: "/",
      method: "GET",
    }).then(res => {
      callback(res.data);
    });
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        한양대학교 동아리 관리 홈페이지
      </header>
      <nav>
        <ul>
          <li>
            <a href="/">Home</a>
          </li>
          <Link to="/login">Login</Link>
          <li>
            <a href="https://www.hanyang.ac.kr/">한양대학교 홈</a>
          </li>
        </ul>
      </nav>
      <section className="sec1">{/* <h1>한양대학교</h1> */}</section>
      <section className="sec2">
        <h1>운영진이신가요?</h1>
        <span className="mainpage-line-first"></span>
        <h3>어쩌고저쩌고</h3>
        <a href="#" className="btn blue">
          Click ME!
        </a>
      </section>
      <section className="sec3">
        <h1>회원이신가요?</h1>
        <span className="mainpage-line-second"></span>
        <h3>어쩌고저쩌고</h3>
        <a href="#" className="btn blue black-font">
          Click ME!
        </a>
      </section>
      <footer>
        <div className="logo">
          <img src={hy_logo} className="logo" alt="logo" />
        </div>
        <div className="footer-box">
          <div className="copyright">
            <p className="addr">
              서울특별시 성동구 왕십리로 222 경제금융관 506호
            </p>
            <p className="tel">02.2220.1807</p>
            <p className="copy">
              COPYRIGHT ⓒ 2022 HANYANG UNIVERSITY. ALL RIGHTS RESERVED.
            </p>
          </div>
        </div>
        <div className="site"></div>
      </footer>
    </div>
  );
}

export default App;
