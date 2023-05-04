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
               ArrayList<News> news= (ArrayList<News>) request.getAttribute("news");
               if(news!=null){
                 for(News n: news){

           %>
            <div>
                <h3><%=n.getTitle()%></h3>
                <p><%=n.getContent()%></p>
                <p>Posted by<strong><%=n.getUser().getFullname()%></strong>
                    At<strong><%=n.getPostdate()%></strong>
                </p>

            </div>
            <%
                    }
                }

            %>
        </div>
    </div>
</div>
</body>
</html>