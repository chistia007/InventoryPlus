package chistia007.github.io.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;


@RestController
public class AddUserController {
    PreparedStatement preparedStatement;
    private List<User> users = new ArrayList<>(); // Assuming you have a list of users

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
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
    }
}
