import React from "react";

function Login({ match, location }) {
  const params = match.params.id ? match.params.id : "익명";
  console.log("match", match);
  console.log("location", location);
  return (
    <>
      <div>{params} login page</div>
    </>
  );
}

export default Login;
