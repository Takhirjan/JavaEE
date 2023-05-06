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
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <%
                String passwordEr=request.getParameter("error");
                if(passwordEr!=null){
            %>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong> Incorrect password</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
            <%
                }
            %>
            <form action="/login" method="post">
                <div class="row">
                    <div class="col-12">
                        <label>
                            Email:
                        </label>
                    </div>
                </div>
                <div class="row mt-2">
                        <div class="col-12">
                           <input type="email" class="form-control" name="email" required placeholder="Insert email">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <label>
                                Password:
                            </label>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-12">
                            <input type="password" class="form-control" name="password" required placeholder="Insert password">
                        </div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-12">
                            <button class="btn btn-success">Sign in</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</body>
</html>
