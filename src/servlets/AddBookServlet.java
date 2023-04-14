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

@WebServlet(value="/add-book")
public class AddBookServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("book_name");  //вытащи мне параметр book_name из BookServlet
    String author = req.getParameter("book_author");//getParametr возвращает только String
    String price = req.getParameter("book_price");
    String genre = req.getParameter("book_genre");
    String description = req.getParameter("book_description");

    double bookPrice = Double.parseDouble(price);

    Book book = new Book();
    book.setName(name);
    book.setPrice(bookPrice);
    book.setAuthor(author);
    book.setGenre(genre);
    book.setDescription(description);

    DBconnection.addBook(book);

    resp.sendRedirect("/bookServlet");

  }
}
