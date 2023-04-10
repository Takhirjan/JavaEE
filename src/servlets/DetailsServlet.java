package servlets;

import DB.DBbooks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Books;

import java.io.IOException;
@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=-1;
    try {
       id = Integer.parseInt(req.getParameter("book_id"));

    }catch (Exception e){

    }
    Books book = DBbooks.getBook(id);
    req.setAttribute("kniga",book);
    req.getRequestDispatcher("details.jsp").forward(req,resp);
  }
}
