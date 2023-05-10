package servlets;

import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Comment;
import models.News;
import models.User;

import java.io.IOException;

@WebServlet(value="/add-comment")
public class ToAddCommentServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  User user= (User) req.getSession().getAttribute("currentUser");
  if(user!=null){

    String commentText=  req.getParameter("comment");
    Long newsId=Long.parseLong(req.getParameter("news_id"));

    News news=DBconnection.getNewsById(newsId);
    if(news!=null){
      Comment comment=new Comment();
      comment.setNews(news);
      comment.setUser(user);
      comment.setComment(commentText);


      DBconnection.addComment(comment);

      resp.sendRedirect("/news-details?id="+newsId);
    }else {
      resp.sendRedirect("/");
    }
}else{
  resp.sendRedirect("/login");
}

  }
}
