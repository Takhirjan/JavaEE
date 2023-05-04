package servlets;

import DB.DBbooks;
import DB.DBconnection;
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
    int id=-1;  //для 404 ошибки Если какая ошика выйдет в try то ничего не произойдет и ID Останается -1
    //Дльаше он булет искать ее в 26 строке а ее нету там и он булет говорить 404
    try {
       id = Integer.parseInt(req.getParameter("book_id")); ///Обработал с базы ID

    }catch (Exception e){

    }
    Book book = DBconnection.getBook(id); //нашел с базы ID
    req.setAttribute("kniga",book);//пихнул под ключом kniga для details.jsp
    req.getRequestDispatcher("/details.jsp").forward(req,resp);
  }
}
