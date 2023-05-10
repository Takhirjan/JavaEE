<%@ page import="java.util.ArrayList" %>
<%@ page import="models.*" %><%--
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
                        <%
                            if(currentUser!=null && currentUser.getId()==news.getUser().getId()){
                        %>

                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary btn-sm" data-bs-toggle="modal"
                                data-bs-target="#editNews">
                            EDIT
                        </button>
                        <div class="modal fade" id="editNews" data-bs-backdrop="static" data-bs-keyboard="false"
                             tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <form action="/save-news" method="post">
                                        <input type="hidden" name="id" value="<%=news.getId()%>">
                                        <div class="modal-header">
                                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Edit News</h1>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                    aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="row">
                                                <div class="col-12">
                                                    <label>
                                                        TITLE :
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                    <input type="text" class="form-control" name="title" required
                                                           placeholder="Insert title:" value="<%=news.getTitle()%>">
                                                </div>
                                            </div>
                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <label>
                                                        CONTENT :
                                                    </label>
                                                </div>
                                            </div>
                                            <div class="row mt-2">
                                                <div class="col-12">
                                                <textarea class="form-control" name="content"
                                                          placeholder="Insert content:" required
                                                          rows="10"><%=news.getContent()%></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                                            </button>
                                            <button class="btn btn-success">Update</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
                    <%
                        if(currentUser!=null){
                    %>
                    <form action="/add-comment" method="post">
                        <input type="hidden" name="news_id" value="<%=news.getId()%>">
                        <div class="row mt-3">
                            <div class="col-12">
                                <textarea class="form-control" name="comment"></textarea>
                            </div>
                        </div>
                        <div class="row mt-2">
                            <div class="col-12">
                                <button class="btn btn-success btn sm">ADD COMMENT</button>
                            </div>
                        </div>
                    </form>
            </div>
                <%
                    }
                %>
<div class="row">
    <div class="col-12">
        <%
            ArrayList<Comment> comments= (ArrayList<Comment>) request.getAttribute("comments");
            if(comments!=null){
              for(Comment comment: comments){

        %>
        <div class="list-group">
            <a href="JavaScript:void(0)" class="list-group-item list-group-item-action">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1"><%=comment.getUser().getFullname()%></h5>
                    <small class="text-body-secondary"><%=comment.getPostdate()%></small>
                </div>
                <p class="mb-1"><%=comment.getComment()%></p>
            </a>
        </div>
        <%
                }
            }
        %>
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