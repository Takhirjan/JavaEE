<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 01.05.2023
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%--<%    User currentUser= (User) session.getAttribute("currentUser");--%>
<%--%>--%>
<%@include file="navbar.jsp"%>
<div class="row">
    <div class="col-12 mx-auto">
        <h1 class="text-center">Hello <%=currentUser.getFullname()%></h1>
    </div>
</div>

</body>
</html>
