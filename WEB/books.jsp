<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Books" %><%--
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
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/add-book" method="POST">
                <div class="row">
                    <div class="col-12">
                        <label>NAME:</label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" name="book_name">
                    </div>
                </div>
                <div class="row mt-2">
                <div class="col-12">
                    <label>Author</label>
                </div>
                </div>
        <div class="row mt-2">
            <div class="col-12">
                <input type="text" class="form-control" name="book_author">
            </div>
        </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <label>Price</label>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col-12">
<select class="form-select" name="book_price"
<%
    for(int i=0;i<10000;i+=1000){
%>
                        <option><%=i%></option>
<%
    }
%>

></select>
                    </div>
                </div>
                <div class="row mt-2">
        <div class="col-12">
            <label>GENRE:</label>
        </div>
    </div>
    <div class="row mt-2">
        <div class="col-12">
            <select class="form-select" name="book_genre">
                <option>Fantasy</option>
                <option>Horror</option>
                <option>Comics</option>
                <option>Roman</option>
            </select>
        </div>
    </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">ADD BOOK</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<div class="row">
    <div class="col-12">
        <table class="table table-striped table-hover">
            <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>AUTHOR</th>
                <th>GENRE</th>
                <th>PRICE</th>
            </tr>
            </thead>
            <tbody>
            <%
                ArrayList<Books> kitaptar=(ArrayList<Books>) request.getAttribute("knigi");
            if(kitaptar!=null){
              for(Books books:kitaptar){
                %>
            <tr>
                <td><%=books.getId()%></td>
                <td><%=books.getName()%></td>
                <td><%=books.getAuthor()%></td>
                <td> <%=books.getGenre()%></td>
                   <td> <%=books.getPrice() %>KZT</td>
            </tr>
            <%
              }
            }
            %>
        </tbody>
        </table>
    </div>
</div>
</div>
</body>
</html>
