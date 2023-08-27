package chistia007.github.io.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    PreparedStatement preparedStatement;
    private List<User> users = new ArrayList<>(); // Assuming you have a list of users

    @PostMapping("/addUser")
    public int  addUser(@RequestBody User user) {
        users.add(user);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryplus", "root", "root");
            String query = "Insert into user (userName, password,userType, salary) values(?, ?,?,?)";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setLong(2, user.getPassword());
            preparedStatement.setString(3, user.getUserType());
            preparedStatement.setLong(4, user.getSalary());
            preparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return 1;
    }



    @GetMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();

        try {
            // Establish a database connection (Ensure your MySQL server is running)
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryplus", "root", "root");

            // Use a prepared statement to execute your SQL query
            String sql = "SELECT userName, userType, salary,password FROM user"; // Adjust your SQL query as needed
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setUserName(resultSet.getString("userName"));
                user.setPassword(resultSet.getInt("password"));
                user.setUserType(resultSet.getString("userType"));
                user.setSalary(resultSet.getInt("salary"));
                users.add(user);
            }

            // Close database resources
            resultSet.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }



    @GetMapping("/deleteUser")
    @ResponseBody
    public int login(@RequestParam("username") String username ){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryplus", "root", "root");
            String query = "DELETE FROM user WHERE userName = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return  1;
    }





}
