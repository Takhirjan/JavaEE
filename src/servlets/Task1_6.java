package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/task1_6")
public class Task1_6 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out=resp.getWriter();
    out.print("<h1>TASK 1.6</h1>");
    out.print("<div>");
    out.print("<form action='/task1_6' method='post'>");
    out.print("<input type='text' name='full_name' placeholder='Insert full name...'>");
    out.print("<input type='number' name='e_points' placeholder='Insert exam points...'>");
    out.print("<button>SUBMIT EXAM</button>");
    out.print("</form>");
    out.print("</div>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out=resp.getWriter();
    String fullName = req.getParameter("full_name");
    int points = Integer.parseInt(req.getParameter("e_points"));
    String result = "F";
    if (points >= 90) {
      result = "A";
    } else if (points >= 75 && points < 90) {
      result = "B";
    } else if (points >= 60 && points < 75) {
      result = "C";
    } else if (points >= 50 && points < 60) {
      result = "D";
    }
    out.print("<h1>"+fullName + " got " + result + " for exam!" +"</h1>");
  }

  }

