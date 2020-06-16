
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login Page</title>
  <style type="text/css">
    body{
margin-left: 42%;
    }
    .login {

      border-radius: 5px ;
      background: aqua;
      height:180px; width:240px;
      margin:0;
      padding:10px;
      border:1px #CCC solid;
    }
    .login input {
      padding:5px; margin:5px
    }
  </style>
</head>
<body>
<form method="post" action="/login">
  <div class="login">
    <h2>Login</h2>
    <input type="text" name="username" size="30"  placeholder="username" />
    <input type="password" name="password" size="30" placeholder="password" />
    <input type="submit" value="Sign in"/>
  </div>
</form>
</body>
</html>