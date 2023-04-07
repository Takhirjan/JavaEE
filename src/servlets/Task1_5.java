package servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/task1_5")
public class Task1_5 extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out=resp.getWriter();
    out.print("<h1>TASK 1.5</h1>");
    out.print("<div>");
    out.print("<form action='/task1_5' method='post'>");
    out.print("<input type='text' name='full_name' placeholder='Insert full name...'>");
    out.print("<input type='number' name='age' placeholder='Insert age...'>");
    out.print("<input type='radio' value='MALE' name='gender'>MALE");
    out.print("<input type='radio' value='FEMALE' name='gender'>FEMALE");
    out.print("<button>SEND</button>");
    out.print("</form>");
    out.print("</div>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out=resp.getWriter();
    String fullName = req.getParameter("full_name");
    int age = Integer.parseInt(req.getParameter("age"));
    String gender = req.getParameter("gender");

    String call = "DUDE";
    String genderCall = "MISTER";

    if(age>=18){
      call="DEAR";
    }
    if(gender.equals("FEMALE")){
      genderCall = "MISS";
    }
    out.print("<h1>Hello "+call + " "+genderCall +" "+fullName+"</h1>");
  }
}
