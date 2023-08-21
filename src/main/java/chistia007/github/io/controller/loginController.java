package chistia007.github.io.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

@Controller
public class loginController {

    @GetMapping("/login")
    @ResponseBody
    public int login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;

        try {
            // Establish a database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryplus", "root", "root");

            // Use a prepared statement to avoid SQL injection
            String sql = "SELECT userName, password FROM user WHERE userName=? AND password=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                // Authentication successful, a matching user was found in the database
                return 1;
            } else {
                // Authentication failed, no matching user found
                return 0;
            }
        } catch (SQLException e) {
            // Handle any database errors here
            e.printStackTrace();
            return -1; // Return an error code
        }
    }
}
