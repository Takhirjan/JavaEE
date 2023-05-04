package servlets;

import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.News;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/news-details")
public class NewsDetailsServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Long id= Long.parseLong(req.getParameter("id"));
    News news=DBconnection.getNewsById(id);
    req.setAttribute("news",news);
    req.getRequestDispatcher("/newsdetails.jsp").forward(req,resp);
  }
}
