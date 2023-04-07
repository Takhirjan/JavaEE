package servlets;

import DB.DBfootballers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Footballer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value="/task1_7")
public class Task1_7 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out= resp.getWriter();
    out.print("<div>");
    out.print("<form action='/task1_7' method='post'>");
    out.print("<input type='text' placeholder='Insert name' name='f_name'>");
    out.print("<input type='text' placeholder='Insert surname' name='f_surname'>");
    out.print("<select name='f_club'>");
    out.print("<option>Real Madrid</option>");
    out.print("<option>PSG</option>");
    out.print("</select>");
    out.print("<input type='number' placeholder='Insert salary' name='f_salary'>");
    out.print("<input type='number' placeholder='Insert transfer price' name='f_transfer_price'>");
    out.print("<button>ADD FOOTBALLER</button>");
    out.print("</form>");
    out.print("</div>");


    ArrayList<Footballer> footballers= DBfootballers.getFootballers();
    for(Footballer footballer: footballers){
      out.print("<h1>"+footballer.getName()+" "+footballer.getSurname()+"</h1>");
      out.print("<h2>"+footballer.getClub()+" "+footballer.getSalary()+"</h2>");
      out.print("<h3>"+footballer.getTransferPrice()+"</h3>");
      out.print("<hr>");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name=req.getParameter("f_name");
    String surname=req.getParameter("f_surname");
    String club=req.getParameter("f_club");
    String salary=req.getParameter("f_salary");
    String transferPrice=req.getParameter("f_transfer_price");

    Footballer footballer=new Footballer();
    footballer.setName(name);
    footballer.setSurname(surname);
    footballer.setClub(club);
    footballer.setSalary(Integer.parseInt(salary));
    footballer.setTransferPrice(Integer.parseInt(salary));
    DBfootballers.addFootballers(footballer);
    resp.sendRedirect("/task1_7");
  }
}
