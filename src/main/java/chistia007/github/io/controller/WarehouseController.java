package chistia007.github.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WarehouseController {

    @GetMapping("/warehouse-items")
    public List<Item> getWarehouseItems() throws SQLException {
        List<Item> response = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoryplus", "root", "root");
        // SQL query to join the 'plot' and 'warehouse' tables and filter by 'movedToWareHouse'
        String sqlQuery = "SELECT\n" +
                "        p.plot_id,\n" +
                "        p.productName,\n" +
                "        p.pricePerKg,\n" +
                "        p.location,\n" +
                "        p.imageUrl,\n" +
                "        p.totalQuantity,\n" +
                "        p.quantitySold,\n" +
                "        p.quantityLeft,\n" +
                "        p.movedToWareHouse,\n" +
                "        p.productGrade,\n" +
                "        p.ploughingTime,\n" +
                "        p.reapingTime,\n" +
                "        p.wareHouseID,\n" +
                "        w.warehouseId,\n" +
                "        w.warehouseName\n" +
                "        FROM\n" +
                "        plot p\n" +
                "        JOIN\n" +
                "        warehouse w ON p.WareHouseId = w.warehouseId\n" +
                "        WHERE\n" +
                "        p.movedToWarehouse = 'yes';";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            // Create a new Item object for each row
            Item item = new Item();
            item.setPlot_id(resultSet.getInt("plot_id"));
            System.out.println(resultSet.getString("wareHouseName"));
            item.setProductName(resultSet.getString("productName"));
            item.setLocation(resultSet.getString("location"));
            item.setQuantitySold(resultSet.getInt("quantitySold"));
            item.setProductGrade(resultSet.getString("productGrade"));
            item.setReapingTime(resultSet.getString("reapingTime"));
            item.setWareHouseID(resultSet.getInt("wareHouseId"));
            item.setWareHouseName(resultSet.getString("wareHouseName"));


            // Add the Item object to the response list
            response.add(item);
        }

        System.out.println(response + "=====================================");

        return response;
    }
}







