package chistia007.github.io.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PledgeController {
    @GetMapping("/user")
    public String  getHelloMessage(){
        return  "Hello there, i am chisthia khan";
    }

}
