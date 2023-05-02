package servlets;

import models.Author;
import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-author")
public class AddAuthorServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("first_name");
    String surname = req.getParameter("last_name");
    String instagram = req.getParameter("instagram");

    Author author=new Author();
    author.setFirstname(name);
    author.setLastname(surname);
    author.setInstagram(instagram);

    DBconnection.addAuthor(author);
    resp.sendRedirect("/authors");
  }
}
