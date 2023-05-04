package servlets;

import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

import java.io.IOException;


@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet  {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/login.jsp").forward(req,resp);

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email=req.getParameter("email");
    String password=req.getParameter("password");


    User user= DBconnection.getUser(email);

    if(user!=null && user.getPassword().equals(password)){
      HttpSession session= req.getSession();
      session.setAttribute("currentUser",user);
      resp.sendRedirect("/profile");
    }else{
      resp.sendRedirect("/login?error");
    }
  }
}
