package com.example.shoppingcart.servlet;

import com.example.shoppingcart.connection.DbCon;
import com.example.shoppingcart.dao.UserDao;
import com.example.shoppingcart.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String email = request.getParameter("Login-email");
        String password = request.getParameter("Login-password");
        UserDao uDao = new UserDao(DbCon.getConnection());
        User user = uDao.userLogin(email,password);
        if(user != null){
            request.getSession().setAttribute("auth",user);
            response.sendRedirect("index.jsp");

        }else{
            out.println("user login failed");
        }
    }

}
