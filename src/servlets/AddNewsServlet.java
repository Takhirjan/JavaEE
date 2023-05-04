package servlets;

import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Author;
import models.Book;
import models.User;

import java.io.IOException;

@WebServlet(value="/add-news-page")
public class AddNewsServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user= (User) req.getSession().getAttribute("currentUser");
    if(user!=null){
     req.getRequestDispatcher("/addnews.jsp").forward(req,resp);
    }else{
      resp.sendRedirect("/login");
    }
  }
}
