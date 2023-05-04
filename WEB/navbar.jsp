<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10.04.2023
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navbar</title>
</head>
<body>
<%
    User currentUser= (User) session.getAttribute("currentUser");

%>
<%@include file="user.jsp"%>
<nav class="navbar navbar-expand-lg bg-success navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/"><%=siteName%></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/bookServlet">Home</a>
                </li>
                <%
                    if(currentUser!=null){
                %>

                <li class="nav-item">
                    <a class="nav-link" href="/add-book-page">Add Book</a>
                </li>
                <%
                    }
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/authors">Authors</a>
                </li>
                <%
                    if(currentUser!=null){
                %>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                       <%=currentUser.getFullname()%>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/profile">Profile</a></li>
                        <li><a class="dropdown-item" href="/settings"> Settigs</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="/logout"> Logout</a></li>
                    </ul>
                </li>
                <%
                    }else{
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>
                <%
                    }
                %>
            </ul>

        </div>
    </div>
</nav>
</body>
</html>
