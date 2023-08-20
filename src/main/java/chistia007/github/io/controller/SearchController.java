package chistia007.github.io.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @GetMapping("/search")
    @ResponseBody
    public List<Item> search(@RequestParam("query") String query) {
        System.out.println("=============================aaaaaaaaaaaaaa====================="+ query);
        List<Item> response = new ArrayList<>();
        // Handle the search logic and populate the response list
        Item item = new Item();
        item.setName("Your Item Name1"); // Set the name based on your search logic
        item.setId(1); // Set the name based on your search logic
        response.add(item);
        item.setName("Your Item Name2"); // Set the name based on your search logic
        item.setId(2); // Set the name based on your search logic
        response.add(item);
        // Add more items as needed
        return response;
    }
}


