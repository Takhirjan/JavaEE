<%--
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
                <li class="nav-item">
                    <a class="nav-link" href="/add-book-page">Add Book</a>
                </li>
            </ul>

        </div>
    </div>
</nav>
</body>
</html>
