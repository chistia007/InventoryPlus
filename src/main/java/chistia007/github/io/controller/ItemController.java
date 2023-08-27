package chistia007.github.io.controller;


import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {
    private List<Item> items = new ArrayList<>();

    @PostMapping("/items/update")
    public int updatePlot(@RequestBody Item item) {
        System.out.println(item.getTotalQuantity() +"0000" +item.getPlot_id());
        items.add(item);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryplus", "root", "root");
            String updateQuery = "UPDATE plot SET productName=?, pricePerKg=?, location=?, imageUrl=?, totalQuantity=?, quantitySold=?, quantityLeft=?, movedToWareHouse=?, productGrade=?, ploughingTime=?, reapingTime=?, wareHouseID=? WHERE plot_id=?";

            // Create a PreparedStatement
            PreparedStatement preparedStatement = con.prepareStatement(updateQuery);

            // Set the updated values
            preparedStatement.setString(1, item.getProductName());
            preparedStatement.setInt(2, item.getPricePerKg());
            preparedStatement.setString(3, item.getLocation());
            preparedStatement.setString(4, item.getImageUrl());
            preparedStatement.setInt(5, item.getTotalQuantity());
            preparedStatement.setInt(6, item.getQuantitySold());
            preparedStatement.setInt(7, item.getQuantityLeft());
            preparedStatement.setString(8, item.getMovedToWareHouse());
            preparedStatement.setString(9, item.getProductGrade());
            preparedStatement.setString(10, item.getPloughingTime());
            preparedStatement.setString(11, item.getReapingTime());
            preparedStatement.setInt(12, item.getWareHouseID());
            preparedStatement.setInt(13, item.getPlot_id());

            // Execute the update
            preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return 1;
    }
}


