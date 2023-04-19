package servlets;

import DB.Author;
import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value="/authors")
public class AuthorsServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ArrayList<Author> authors= DBconnection.getAuthors();
    req.setAttribute("avtory",authors);
    req.getRequestDispatcher("authors.jsp").forward(req,resp);
  }
}
