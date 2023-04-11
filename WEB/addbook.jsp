<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Book" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 07.04.2023
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-5">
    <div class="row">
        <div class="col-6 mx-auto">
            <%@include file="addform.jsp"%>
        </div>
    </div>
</div>
</body>
</html>