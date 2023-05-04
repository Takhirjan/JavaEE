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
        <form action="/addnews" method="post">
            <div class="row">
                <div class="col-12">
                    <label>
                        TITLE:
                    </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" name="title" required placeholder="Input title">
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <label>
                        CONTENT:
                    </label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                <textarea class="form-control" name="content" placeholder="Insert content"></textarea>
                 </div>
            </div>
            <div class="row mt-3">
                <div class="col-12">
                   <button class="btn btn-success">ADD POST</button>
                </div>
            </div>
        </form>
        </div>
    </div>
</div>
</body>
</html>