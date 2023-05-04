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


@WebServlet(value = "/news")
public class NewsServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ArrayList<News> news= DBconnection.getNews();
    req.setAttribute("news",news);
    req.getRequestDispatcher("/news.jsp").forward(req,resp);
  }
}
