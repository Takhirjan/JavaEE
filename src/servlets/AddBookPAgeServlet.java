package servlets;

import models.Author;
import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/add-book-page")
public class AddBookPAgeServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user= (User) req.getSession().getAttribute("currentUser");
    if(user!=null) {
      if(user.getRole()==1) {
        ArrayList<Author> authors = DBconnection.getAuthors();
        req.setAttribute("avtory", authors);
        req.getRequestDispatcher("/addbook.jsp").forward(req, resp);
      }else{
        req.getRequestDispatcher("/403.jsp").forward(req,resp);
      }
      }else {
      resp.sendRedirect("/login");
    }
  }
}
