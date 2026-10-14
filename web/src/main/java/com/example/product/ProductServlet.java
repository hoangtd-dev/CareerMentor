package com.example.product;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.DBConnectionManager;
import com.example.Utils;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();

        List<Product> products = new ArrayList<>();
        String sql = "SELECT id, name, price FROM products";

        try (Connection conn = DBConnectionManager.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }

        } catch (SQLException e) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("Server Error !!!" + e.getMessage());
            return;
        }

        StringBuilder sb = new StringBuilder("""
                    <table>
                        <tr>
                          <th>Id</th>
                          <th>Name</th>
                          <th>Price</th>
                        </tr>
                """);
        products.forEach((Product product) -> {
            sb.append("<tr>");
            sb.append("<td>" + product.getId() + "</td>");
            sb.append("<td>" + product.getName() + "</td>");
            sb.append("<td>" + product.getPrice() + "</td>");
            sb.append("</tr>");
        });
        sb.append("</table>");

        String result = Utils.getHtmlTemplate(sb.toString(), Optional.of("""
                    <style>
                    .root {
                        width: 100%;
                        height: 100vh;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                    }
                    table {
                        font-family: arial, sans-serif;
                        border-collapse: collapse;
                        width: 400px;
                    }

                    td, th {
                        border: 1px solid #dddddd;
                        text-align: left;
                        padding: 8px;
                    }

                    tr:nth-child(even) {
                        background-color: #dddddd;
                    }
                    </style>
                """));
        out.print(result);
    }
}
