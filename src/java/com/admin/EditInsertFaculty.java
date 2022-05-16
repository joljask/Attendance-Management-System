package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditInsertFaculty", urlPatterns = {"/EditInsertFaculty"})
public class EditInsertFaculty extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("f_email");
        String first_name = request.getParameter("f_first_name");
        String last_name = request.getParameter("f_last_name");
        String faculty_id = request.getParameter("f_id");
        String faculty_course = request.getParameter("f_course");
        String faculty_mobile_no = request.getParameter("f_mobile");

        System.out.println("Fetched Data are");
        System.out.println(email + first_name + last_name + faculty_id + faculty_course + faculty_mobile_no);

        try {
            String sql_query = "UPDATE faculty SET firstname = ?, lastname = ?,email = ?, course = ?, mobileno = ?  WHERE facultyid = ?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");

            PreparedStatement stmt = con.prepareStatement(sql_query);

            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, email);
            stmt.setString(4, faculty_course);
            stmt.setString(5, faculty_mobile_no);
            stmt.setString(6, faculty_id);

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");
            
            //response.sendRedirect(request.getContextPath() + "/welcome.jsp")
            
            response.sendRedirect("editFacultySuccess.jsp");
            

        } catch (Exception ex) {
            Logger.getLogger(EditInsertFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
