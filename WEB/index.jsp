<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 07.04.2023
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
<body>
<%
    boolean online=true;
    if(online){
%>
        <div class="container">
            <div class="row">
    <div class="col-3 mx-auto">
      <%
          for(int i=0;i<10;i++){
      %>
        <div class="card" style="width: 18rem;">
            <img src="https://fastly.picsum.photos/id/11/2500/1667.jpg?hmac=xxjFJtAPgshYkysU_aqx2sZir-kIOjNR9vx0te7GycQ" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Mountains</h5>
                <a href="#" class="btn btn-primary">Text messages</a>
            </div>
        </div>
<%
    }
%>

                </div>
            </div>
        </div>
<%
    }else{
%>
<div class="text-center">
    <h1>Site is offline</h1>
</div>
<%
    }
%>
</body>
</html>
