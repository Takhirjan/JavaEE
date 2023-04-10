<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 10.04.2023
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
            <label>Description</label>
        </div>
    </div>

    <div class="row mt-2">
        <div class="col-12">
           <textarea name="book_description" class="form-control" rows="5"></textarea>
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
</body>
</html>
