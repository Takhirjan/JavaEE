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

@WebServlet(value="/add-book")
public class AddBookServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user= (User) req.getSession().getAttribute("currentUser");
    if(user!=null && user.getRole()==1) {

      String name = req.getParameter("book_name");  //вытащи мне параметр book_name из BookServlet
      int author_id = Integer.parseInt(req.getParameter("book_author"));//getParametr возвращает только String
      String price = req.getParameter("book_price");
      String genre = req.getParameter("book_genre");
      String description = req.getParameter("book_description");

      double bookPrice = Double.parseDouble(price);

      Author author = DBconnection.getAuthor(author_id);
      if (author != null) {
        Book book = new Book();
        book.setName(name);
        book.setPrice(bookPrice);
        book.setGenre(genre);
        book.setDescription(description);
        book.setAuthor(author);
        DBconnection.addBook(book);
      }


      resp.sendRedirect("/bookServlet");
    }else{
      resp.sendRedirect("/login");
    }
  }

}
