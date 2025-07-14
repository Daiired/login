package com.myconstruction.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.*;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/myconstruction", "root", "devilmaycry.3");

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user);
            stmt.setString(2, pass);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                req.getSession().setAttribute("user", user);
                resp.sendRedirect("bienvenido.jsp");
            } else {
                req.setAttribute("error", "Credenciales inválidas");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error interno en el servidor.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}