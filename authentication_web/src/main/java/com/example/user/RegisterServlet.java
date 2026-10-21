package com.example.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final int MIN_PASSWORD_LENGTH = 6;

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirm = req.getParameter("confirmPassword");

        String error = null;
        if (name == null || email == null || password == null || password == null) {
            error = "All fields are required";
        } else if (password.length() < MIN_PASSWORD_LENGTH) {
            error = "Password must be at least " + MIN_PASSWORD_LENGTH + " characters";
        } else if (!password.equals(confirm)) {
            error = "Passwords do not match";
        } else {
            try {
                if (!userService.register(name, email, password)) {
                    error = "Email is already registered";
                }
            } catch (SQLException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server Error !!! " + e.getMessage());
                return;
            }
        }

        if (error != null) {
            req.setAttribute("error", error);
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }

        resp.sendRedirect(req.getContextPath() + "/login?registered=1");
    }
}
