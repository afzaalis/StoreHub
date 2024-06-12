/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import Model.Buku;
import Model.Elektronik;
import Model.Pakaian;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import Model.Product;
import Model.User;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author afzaalisnaufal
 */
public class WishListAccess {
    
    private Connection connection;
    
    public WishListAccess(Connection connection) {
        this.connection = connection;
    }
    
    public List<Product> getAllItems(int userId) throws SQLException {
        List<Product> items = new ArrayList<>();
        String query = "SELECT * FROM wishlist WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    
                    int id = resultSet.getInt("id_produk");
                    String category = resultSet.getString("kategori");
                    String name = resultSet.getString("nama");
                    double price = resultSet.getDouble("harga");
                    String description = resultSet.getString("deskripsi");

                    Product product;
                    switch (category) {
                        case "Buku":
                            product = new Buku(id, name, price, description);
                            break;
                        case "Pakaian":
                            product = new Pakaian(id, name, price, description);
                            break;
                        case "Elektronik":
                            product = new Elektronik(id, name, price, description);
                            break;
                        default:
                            throw new IllegalArgumentException("Unknown category: " + category);
                    }
                    items.add(product);
                }
            }
        }
        return items;
    }
    
     public int getItemId(int userId, String category, String name, String description, double price) throws SQLException {
        int itemId = -1;

        String query = "SELECT id_produk FROM wishlist WHERE user_id = ? AND kategori = ? AND nama = ? AND deskripsi = ? AND harga = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setString(2, category);
            statement.setString(3, name);
            statement.setString(4, description);
            statement.setDouble(5, price);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    itemId = resultSet.getInt("id_produk");
                }
            }
        }

        return itemId;
    }

    public void addItem(int userId, Product product) throws SQLException {
        String query = "INSERT INTO wishlist (user_id, kategori, nama, harga, deskripsi) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setString(2, product.getCategory());
            statement.setString(3, product.getName());
            statement.setDouble(4, product.getPrice());
            statement.setString(5, product.getDescription());
            statement.executeUpdate();
        }
    }

    public void removeItem(int userId, int productId) throws SQLException {
        String query = "DELETE FROM wishlist WHERE user_id = ? AND id_produk = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.executeUpdate();
        }
    }
}
