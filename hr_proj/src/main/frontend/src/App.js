import React, { useState, useEffect } from "react";
// eslint-disable-next-line
import logo from "./logo.svg";
import "./App.css";
import axios from "axios";

function App() {
  // 요청받은 정보를 담아줄 변수 선언
  // eslint-disable-next-line
  const [testStr, setTestStr] = useState("");

  // 변수 초기화
  function callback(str) {
    setTestStr(str);
  }

  // 첫 번째 렌더링을 마친 후 실행
  useEffect(() => {
    axios({
      url: "/api/hello",
      method: "GET",
    }).then(res => {
      callback(res.data);
    });
  }, []);

  return (
    <div className="App">
      <header className="App-header">{testStr}</header>
    </div>
  );
}

export default App;
