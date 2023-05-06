package servlets;

import DB.DBbooks;
import DB.DBconnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;

@WebServlet(value = "/delete-book")
public class DeleteBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user= (User) request.getSession().getAttribute("currentUser");
        if(user!=null && user.getRole()==1) {
            int id = Integer.parseInt(request.getParameter("id"));
            DBconnection.deleteBook(id);

            response.sendRedirect("/bookServlet");
        }else{
            response.sendRedirect("/login");
        }
    }
}
