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
    <%@include file="head.jsp"%>
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container mt-5">
    <%
        Books books=(Books) request.getAttribute("kniga");
    if(books!=null){

    %>
    <div class="row">
        <div class="col-6 mx-auto">
            <div class="row">
                <div class="col-12">
                    <label>NAME:</label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="text" class="form-control" readonly value="<%=books.getName()%>">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <label>Author</label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <input type="text" class="form-control" readonly value="<%=books.getAuthor()%>">
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <label>Price</label>
                </div>
            </div>

            <div class="row mt-2">
                <div class="col-12">
                    <input type="text" class="form-control" readonly value="<%=books.getPrice()%> KZT">

                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <label>Description</label>
                </div>
            </div>

            <div class="row mt-2">
                <div class="col-12">
<textarea class="form-control" readonly rows="10"><%=books.getDescription()%></textarea>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                    <label>GENRE:</label>
                </div>
            </div>
            <div class="row mt-2">
                <div class="col-12">
                  <input type="text" class="form-control" readonly value="<%=books.getGenre()%>">
                </div>
            </div>
        <div class="row mt-3">
            <div class="col-12">
                <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal" data-bs-target="#editBook">
                    Edit Book
                </button>
            </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="editBook" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="staticBackdropLabel">Modal title</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <form action="/save-book" method="POST">
                            <input type="hidden" name="book_id" value="<%=books.getId()%>">
                            <div class="row">
                                <div class="col-12">
                                    <label>NAME:</label>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-12">
                                    <input type="text" class="form-control" name="book_name" value="<%=books.getName()%>">
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-12">
                                    <label>Author</label>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-12">
                                    <input type="text" class="form-control" name="book_author" value="<%=books.getAuthor()%>">
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="col-12">
                                    <label>Description</label>
                                </div>
                            </div>

                            <div class="row mt-2">
                                <div class="col-12">
                                    <textarea name="book_description" class="form-control" rows="10"><%=books.getDescription()%></textarea>
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
                                    <option <%=(i==books.getPrice()?"selected":"")%>>
                                    <%=i%></option>
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
                                        <option <%=(books.getGenre().equals("Fantasy")?"selected":"")%>>Fantasy</option>
                                        <option <%=(books.getGenre().equals("Horror")?"selected":"")%>>Horror</option>
                                        <option <%=(books.getGenre().equals("Comics")?"selected":"")%>>Comics</option>
                                        <option <%=(books.getGenre().equals("Roman")?"selected":"")%>>Roman</option>
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
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                         </div>
                    </div>
            </div>
        </div>
        </div>
    <%
        }else{
    %>
    <h3 class="text-center">Book not found</h3>
    <%
        }
    %>
</div>
</body>
</html>
