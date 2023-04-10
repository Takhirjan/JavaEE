package servlets;

import DB.DBbooks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Books;

import java.io.IOException;

@WebServlet(value = "/save-book")
public class SaveBookServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=Integer.parseInt(req.getParameter("book_id"));
    String name=req.getParameter("book_name");//вытащи мне параметр book_name из BookServlet
    String author=req.getParameter("book_author"); //getParametr возвращает только String
    double price=Double.parseDouble(req.getParameter("book_price"));
    String genre=req.getParameter("book_genre");
    String description=req.getParameter("book_description");

    Books books= DBbooks.getBook(id);
    if(books!=null){
      books.setName(name);
      books.setAuthor(author);
      books.setGenre(genre);
      books.setPrice(price);
      books.setDescription(description);

      DB.DBbooks.updateBook(books);
      resp.sendRedirect("/details?book_id="+id);
    }else{
      resp.sendRedirect("/bookServlet");
    }


  }
}
