<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Book" %>
<%@ page import="models.News" %><%--
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

    <div class="row mt-3">
        <div class="col-12">
           <%
            News news= (News) request.getAttribute("news");
            if(news!=null){
           %>
            <div>
                <div class="container my-5">
                    <div class="position-relative p-5 text-center  bg-secondary border border-dashed rounded-5">
                        <button type="button" class="position-absolute top-0 end-0 p-3 m-3 btn-close bg-secondary bg-opacity-10 rounded-pill" aria-label="Close"></button>
                        <svg class="bi mt-5 mb-3" width="48" height="48"><use xlink:href="#check2-circle"/></svg>
                            <h1 class="text-black"><%=news.getTitle()%></h1>
                        </a>
                        <p class="col-lg-6 mx-auto mb-4">
                        <p class="text-white"><%=news.getContent()%></p>
                        <p class="text-white">Posted by <strong class="text-black"><%=news.getUser().getFullname()%></strong>
                            At <strong  class="text-black"  ><%=news.getPostdate()%></strong>
                        </p>
                        </p>

                    </div>
                </div>

            </div>
            <%

                }

            %>
        </div>
    </div>
</div>
</body>
</html>