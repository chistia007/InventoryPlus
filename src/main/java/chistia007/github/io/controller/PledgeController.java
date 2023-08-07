package chistia007.github.io.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PledgeController {
    @GetMapping("/user")
    public String  getHelloMessage(){
        return  "Hello there, i am chisthia khan";
    }


        private List<User> users = new ArrayList<>(); // Assuming you have a list of users

        @PostMapping("/addUser")
        public void addUser(@RequestBody User user) {
            // Perform any backend operations like saving the user to the database
            //users.add(user);
            System.out.println("-----------------===================-======------------------------------"+user.getName());
        }


}
