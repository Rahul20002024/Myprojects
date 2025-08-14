package com.festival;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        try {
            String name = req.getParameter("name");
            String institute = req.getParameter("institute");
            int age = Integer.parseInt(req.getParameter("age"));
            String qualification = req.getParameter("qualification");
            String category = req.getParameter("category");
            String gender = req.getParameter("gender");
            String[] eventsArr = req.getParameterValues("events");
            String events = (eventsArr != null) ? String.join(",", eventsArr) : "";
            String remarks = req.getParameter("remarks");

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO event_registration (name, institute, age, qualification, category, gender, events, remarks) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
            );
            ps.setString(1, name);
            ps.setString(2, institute);
            ps.setInt(3, age);
            ps.setString(4, qualification);
            ps.setString(5, category);
            ps.setString(6, gender);
            ps.setString(7, events);
            ps.setString(8, remarks);

            int i = ps.executeUpdate();
            if (i > 0)
                out.println("<h3>Registration Successful!</h3><a href='view'>View All</a>");
            else
                out.println("Failed to register.");

        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}