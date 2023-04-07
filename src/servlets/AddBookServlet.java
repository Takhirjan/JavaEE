package servlets;

import DB.DBbooks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Books;

import java.io.IOException;

@WebServlet(value="/add-book")
public class AddBookServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name=req.getParameter("book_name");//вытащи мне параметр book_name из BookServlet
    String author=req.getParameter("book_author"); //getParametr возвращает только String
    String price=req.getParameter("book_price");
    String genre=req.getParameter("book_genre");

    double bookPrice=Double.parseDouble(price);

    Books books=new Books();
    books.setName(name);
    books.setPrice(bookPrice);
    books.setAuthor(author);
    books.setGenre(genre);

    DBbooks.addBook(books);
    resp.sendRedirect("/bookServlet");
  }
}
