package servlets;

import DB.DBbooks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Book;

import java.io.IOException;

@WebServlet(value = "/save-book")
public class SaveBookServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    int id = Integer.parseInt(request.getParameter("book_id"));
    String name = request.getParameter("book_name");
    String author = request.getParameter("book_author");
    double price = Double.parseDouble(request.getParameter("book_price"));
    String genre = request.getParameter("book_genre");
    String description = request.getParameter("book_description");

    Book book = DBbooks.getBook(id);
    if (book != null) {
      book.setName(name);
      book.setAuthor(author);
      book.setPrice(price);
      book.setGenre(genre);
      book.setDescription(description);
      DBbooks.updateBook(book);
      response.sendRedirect("/details?book_id=" + id);
    } else {
      response.sendRedirect("/bookServlet");
    }
  }
}