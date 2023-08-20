package chistia007.github.io;

import chistia007.github.io.controller.Item;
import com.google.gson.Gson;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/bending/search")
public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Get the search query from the client-side
        String query = request.getParameter("query");

        // Initialize a list to store search results
        List<Item> searchResults = new ArrayList<>();

        try {
            // Connect to your MySQL database
            Connection conn = DriverManager.getConnection("jdbc:mysql://your_db_server/your_db_name", "root", "root");

            // Construct and execute the SQL query
            String sql = "SELECT * FROM your_table_name WHERE name LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + query + "%");
            ResultSet resultSet = stmt.executeQuery();

            // Fetch search results
            while (resultSet.next()) {
                Item item = new Item();
                item.setId(resultSet.getInt("id"));
                item.setName(resultSet.getString("name"));
                item.setDescription(resultSet.getString("description"));
                searchResults.add(item);
            }

            // Close the database connection
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        // Convert search results to JSON and send it to the client
        Gson gson = new Gson();
        String jsonResults = gson.toJson(searchResults);
        out.print(jsonResults);
        out.flush();
    }
}
