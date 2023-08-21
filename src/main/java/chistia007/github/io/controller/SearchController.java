package chistia007.github.io.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @GetMapping("/search")
    @ResponseBody
    public List<Item> search(@RequestParam("query") String query) {
        List<Item> response = new ArrayList<>();

        try {
            // Connect to your MySQL database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryplus", "root", "root");

            // Construct and execute the SQL query
            String sql = "SELECT * FROM plot WHERE plot_id LIKE ? OR productName LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + query + "%");
            stmt.setString(2, "%" + query + "%");
            ResultSet resultSet = stmt.executeQuery();

            // Fetch search results
            while (resultSet.next()) {
                // Create a new Item object for each row
                Item item = new Item();
                item.setPlot_id(resultSet.getInt("plot_id"));
                item.setProductName(resultSet.getString("productName"));
                item.setLocation(resultSet.getString("location"));
                item.setImageUrl(resultSet.getString("imageUrl"));
                item.setTotalQuantity(resultSet.getInt("totalQuantity"));
                item.setQuantitySold(resultSet.getInt("quantitySold"));
                item.setQuantityLeft(resultSet.getInt("quantityLeft"));
                item.setMovedToWareHouse(resultSet.getString("movedToWarehouse"));
                item.setProductGrade(resultSet.getString("productGrade"));
                item.setPloughingTime(resultSet.getString("ploughingTime"));
                item.setReapingTime(resultSet.getString("reapingTime"));
                item.setWareHouseID(resultSet.getInt("wareHouseId"));

                // Add the Item object to the response list
                response.add(item);
            }

            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return response;
    }

}


