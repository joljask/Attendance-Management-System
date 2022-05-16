
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "FacultyToChangePass", urlPatterns = {"/FacultyToChangePass"})
public class FacultyToChangePass extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String var1email = (String)request.getAttribute("sendEmail");
        System.out.println(var1email + "from faculty login.. current servlet FTC");
        response.sendRedirect("changePasswordFaculty.jsp");
    }

    

}
