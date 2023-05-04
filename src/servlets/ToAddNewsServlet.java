package servlets;

import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.News;
import models.User;

import java.io.IOException;

@WebServlet(value="/addnews")
public class ToAddNewsServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  User user= (User) req.getSession().getAttribute("currentUser");
  if(user!=null){
  String title=req.getParameter("title");
  String content=req.getParameter("content");
    News news=new News();
    news.setTitle(title);
    news.setContent(content);
    news.setUser(user);

  DBconnection.addNews(news);
  resp.sendRedirect("/add-news-page");

}else{
  resp.sendRedirect("/login");
}

  }
}
