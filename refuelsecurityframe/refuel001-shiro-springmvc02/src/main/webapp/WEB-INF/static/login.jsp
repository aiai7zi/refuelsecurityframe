<%--
  Created by IntelliJ IDEA.
  User: tanji
  Date: 2019/6/15
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<span style="background: blue">${errorMsg}</span>
<form action="/login" method="post">
    <input type="text" name="username"/><br>
    <input type="text" name="password"/><br>
    <input type="submit" value="提交">

</form>
</body>
</html>
