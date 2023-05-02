package servlets;

import models.Author;
import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Book;
import models.User;

import java.io.IOException;

@WebServlet(value = "/save-book")
public class SaveBookServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    User user= (User) request.getSession().getAttribute("currentUser");
    if(user!=null) {
    int id = Integer.parseInt(request.getParameter("book_id"));
    String name = request.getParameter("book_name");
    int authorID = Integer.parseInt(request.getParameter("book_author"));
    double price = Double.parseDouble(request.getParameter("book_price"));
    String genre = request.getParameter("book_genre");
    String description = request.getParameter("book_description");

    Book book = DBconnection.getBook(id);
    Author author=DBconnection.getAuthor(authorID);
    if (book != null && author!=null) {
      book.setName(name);
      book.setAuthor(author);
      book.setPrice(price);
      book.setGenre(genre);
      book.setDescription(description);
      DBconnection.updateBook(book);
//      response.sendRedirect("/details?book_id=" + id);
      response.sendRedirect("/bookServlet");

    }
    }else{
      response.sendRedirect("/login");
    }
  }
}