package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Database.ProductAccess;

public class test {
    public static void main(String[] args) {
        // Establish a database connection
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/storehub", "root", "");
            
            // Create an instance of ProductAccess
            ProductAccess productAccess = new ProductAccess(connection);
            
            // Create a new product and add it to the database
            Product product = new Buku(0,"Sample Buku", 19.99, "Sample Description");
            productAccess.addProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
