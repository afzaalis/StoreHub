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
import javax.swing.JOptionPane;

public class CheckoutAccess {
    private Connection connection;

    public CheckoutAccess(Connection connection) {
        this.connection = connection;
    }
    
    public List<Product> getCheckoutItems(int userId) throws SQLException {
        List<Product> items = new ArrayList<>();
        String query = "SELECT * FROM checkout WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_produk");
                    String category = resultSet.getString("kategori");
                    String name = resultSet.getString("nama");
                    double price = resultSet.getDouble("harga");
                    String description = resultSet.getString("deskripsi");

                    // Create an instance of the appropriate subclass based on the category
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

    public void performCheckout(User user, double totalPrice) throws SQLException {
        double remainingBalance = user.getBalance() - totalPrice;
        
        
        if (remainingBalance >= 0) {
            updateUserBalance(user.getId(), remainingBalance);
        } else {
            throw new IllegalArgumentException("Insufficient balance!");
        }
    }

    public void updateUserBalance(int userId, double balance) throws SQLException {
        String query = "UPDATE user SET balance = ? WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, balance);
            statement.setInt(2, userId);
            statement.executeUpdate();
        }
    }
    
    public void removeItem(int userId, int productId) throws SQLException {
        String query = "DELETE FROM checkout WHERE user_id = ? AND id_produk = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.executeUpdate();
        }
    }
    
    public int getItemId(int userId, String category, String name, String description, double price) throws SQLException {
        int itemId = -1;

        String query = "SELECT id_produk FROM checkout WHERE user_id = ? AND kategori = ? AND nama = ? AND deskripsi = ? AND harga = ?";
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

    public void addCheckout(int user_id, List<Product> cartItems) throws SQLException {
        String insertQuery = "INSERT INTO checkout (user_id, id_produk, kategori, nama, harga, deskripsi) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            for (Product item : cartItems) {
                statement.setInt(1, user_id);
                statement.setInt(2, item.getId());
                statement.setString(3, item.getCategory());
                statement.setString(4, item.getName());
                statement.setDouble(5, item.getPrice());
                statement.setString(6, item.getDescription());
                statement.addBatch();
            }
            statement.executeBatch();
        }
    }
}
