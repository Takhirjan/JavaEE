package servlets;

import DB.DBbooks;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Books;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



@WebServlet(value="/bookServlet")
public class BookServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out=resp.getWriter();
      out.print("<html");
      out.print("<head>");
    out.print("</title>Books</title>");
      out.print("</head>");
    out.print("<body>");

    out.print("<form action='/add-book' method='POST'>");
    out.print("<input type='text' name='book_name'>Name <br><br>");
    out.print("<input type='text'  name='book-author'>Author <br><br>");
    out.print("<select name='book_genre'>");
    out.print("<option> Fantasy</option>");
    out.print("<option> Horror</option>");
    out.print("<option> Comics</option>");
    out.print("</select>");
    out.print("Genre <br><br>");
    out.print("<input type='number' name='book_price'>Price <br><br>");
    out.print("<button>ADD BOOK</button>");
    out.print("</form>");
    out.print("<br>");

    out.print("<table cellpadding='20'>");
    out.print("<thead>");
    out.print("<tr>");
    out.print("<th>ID</th>");
    out.print("<th>NAME</th>");
    out.print("<th>AUTHOR</th>");
    out.print("<th>GENRE</th>");
    out.print("<th>PRICE</th>");
    out.print("</tr>");
    out.print("</thead");
    out.print("<tbody");

    ArrayList<Books> bookServlets= DBbooks.getBooks();//Вытаскиваю список книг
    if(bookServlets!=null){
      for(Books b:bookServlets){
        out.print("<tr>");
        out.print("<td>"+b.getId()+"</td>");
        out.print("<td>"+b.getName()+"</td>");
        out.print("<td>"+b.getAuthor()+"</td>");
        out.print("<td>"+b.getGenre()+"</td>");
        out.print("<td>"+b.getPrice()+"</td>");
        out.print("</tr >");
      }
    }
    out.print("</tbody");

    out.print("</table");

    out.print("</body>");
    out.print("</html>");
  }
}
