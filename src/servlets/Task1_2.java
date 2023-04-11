package servlets;

import DB.DBmanager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/task1_2")
public class Task1_2 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    out.print("<html");
    out.print("<head>");
    out.print("<title>Task2</title>");
    out.print("</head>");
    out.print("<body>");
    out.print("<table cellpadding='15'>");
    out.print("<tr>");
    out.print("<th>NAME</th>");
    out.print("<th>SURNAME</th>");
    out.print("<th>DEPARTMENT</th>");
    out.print(" <th>SALARY</th>");
    out.print("</tr>");


    ArrayList<users> usersArrayList= DBmanager.getAllUsers();
    for (users user : usersArrayList) {
    out.print("<tr>");
    out.print("<td>");
    out.print(user.getName());
    out.print("</td>");
    out.print("<td>");
    out.print(user.getSurname());
    out.print("</td>");
    out.print("<td>");
    out.print(user.getDepartment());
    out.print("</td>");
    out.print("<td>");
    out.print(user.getSalary());
    out.print("</td>");
    out.print("</tr>");
  }
        out.print("</table>");
        out.print("</body>");
        out.print("</html>");

  }
}
