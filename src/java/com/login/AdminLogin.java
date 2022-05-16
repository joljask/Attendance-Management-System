
package com.login;

import com.test.dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "AdminLogin", urlPatterns = {"/AdminLogin"})
public class AdminLogin extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        
        
        LoginDao dao = new LoginDao();
        
        
        System.out.println(email);
        System.out.println("email");
        
        try {
            if(dao.check(email, pass))
            {
                HttpSession session = request.getSession();
                session.setAttribute("emailID",email);
                response.sendRedirect("adminPage.jsp"); 
            }
            else
            {
                response.sendRedirect("admin.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    

}
