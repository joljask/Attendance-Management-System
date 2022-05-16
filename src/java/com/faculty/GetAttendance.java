package com.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetAttendance {

    public int[] fetchAttendance(String faculty_id, String rollno) throws SQLException 
    {
        String url = "jdbc:mysql://localhost:3306/attendance";
        String username = "root";
        String password = "admin@1234";

        int total_classes = 0;
        int total_present = 0;
        int total_absent = 0;
        int[] all_total;

        try 
        {
            
            System.out.println("ga " + faculty_id + rollno + " GetAttendance.java");

            String sql_total_classes = "select count(*) as added from attendance where facultyid = ? and roll = ?";
            String sql_total_absent = "select count(*) as added from attendance where facultyid = ? and roll = ? and attendance =  0";
            String sql_total_present = "select count(*) as added from attendance where facultyid = ? and roll = ? and attendance = 1";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            {
                PreparedStatement st = con.prepareStatement(sql_total_classes);

                st.setString(1, faculty_id);
                st.setString(2, rollno);
                ResultSet rs = st.executeQuery();
                while(rs.next())
                {
                    
                    //System.out.println("rs.next() is true--- ");
                    total_classes= rs.getInt("added");
                }
                //System.out.println(total_classes + " total classes");
                
            }
          {
                PreparedStatement a = con.prepareStatement(sql_total_absent);

                a.setString(1, faculty_id);
                a.setString(2, rollno);
                ResultSet rsa = a.executeQuery();
                
                while(rsa.next())
                {
                    
                    //System.out.println("rs.next() is true--- ");
                    total_absent = rsa.getInt("added");
                }
            }
            
            {
                PreparedStatement p = con.prepareStatement(sql_total_present);

                p.setString(1, faculty_id);
                p.setString(2, rollno);
                ResultSet rsp = p.executeQuery();
                while(rsp.next())
                {
                    
                   // System.out.println("rs.next() is true--- ");
                    total_present = rsp.getInt("added");
                }
            }


            
            
        } catch (Exception ex) {
            Logger.getLogger(GetAttendance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all_total = new int[]{total_classes,total_present,total_absent};
        }

        
    }

        

