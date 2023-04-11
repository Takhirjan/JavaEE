package servlets;

import DB.DBbooks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Book;

import java.io.IOException;
@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=-1;
    try {
       id = Integer.parseInt(req.getParameter("book_id")); ///Обработал с базы ID

    }catch (Exception e){

    }
    Book book = DBbooks.getBook(id); //нашел с базы ID
    req.setAttribute("kniga",book);//пихнул под ключом kniga для details.jsp
    req.getRequestDispatcher("/details.jsp").forward(req,resp);
  }
}
