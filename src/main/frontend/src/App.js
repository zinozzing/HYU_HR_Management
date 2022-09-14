import logo from "./logo.svg";
import hy_logo from "./hy_logo.png";
import "./App.css";

function App() {
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
          <li>
            <a href="/">로그인</a>
          </li>
          <li>
            <a href="/">한양대학교 홈</a>
          </li>
        </ul>
      </nav>
      <section className="sec1">
        <h1>한양대학교</h1>
      </section>
      <section className="sec2">
        <h1>한양대학교</h1>
      </section>
      <section className="sec3">
        <h1>한양대학교</h1>
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
              COPYRIGHT ⓒ 2019 HANYANG UNIVERSITY. ALL RIGHTS RESERVED.
            </p>
          </div>
        </div>
        <div className="site"></div>
      </footer>
    </div>
  );
}

export default App;
