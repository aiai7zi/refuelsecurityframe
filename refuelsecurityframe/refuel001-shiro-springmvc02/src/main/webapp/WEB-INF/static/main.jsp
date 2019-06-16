<%--
  Created by IntelliJ IDEA.
  User: tanji
  Date: 2019/6/15
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>main</title>
</head>
<body>
 <h3>欢迎：<shiro:principal property="username"></shiro:principal></h3><a href="/logout">退出</a><a href="/reload">重新加载权限</a><br>
 <shiro:hasPermission name="emp:det"></shiro:hasPermission>
 <shiro:hasRole name="emp">
 <a href="/emp">员工列表</a><br>
 </shiro:hasRole>
 <shiro:hasRole name="dep">
<a href="/dep">部门列表</a><br>
 </shiro:hasRole>
</body>
</html>
