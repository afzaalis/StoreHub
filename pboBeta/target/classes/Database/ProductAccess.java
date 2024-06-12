package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.Product;
import Model.Buku;
import Model.Elektronik;
import Model.Pakaian;

public class ProductAccess {
    private Connection connection;

    public ProductAccess(Connection connection) {
        this.connection = connection;
    }

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM tb_produk";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id_produk"); 
                String category = resultSet.getString("kategori"); 
                String name = resultSet.getString("nama"); 
                double price = resultSet.getDouble("harga"); 
                String description = resultSet.getString("deskripsi"); 

                Product product;
                switch (category) {
                    case "Buku":
                        product = new Buku(id,name, price, description);
                        break;
                    case "Pakaian":
                        product = new Pakaian(id,name, price, description);
                        break;
                    case "Elektronik":
                        product = new Elektronik(id,name, price, description);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown category: " + category);
                }
                products.add(product);
            }
        }
        return products;
    }

    public void addProduct(Product product) throws SQLException {
        String query = "INSERT INTO tb_produk (kategori, nama, harga, deskripsi) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getCategory());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getDescription());
            statement.executeUpdate();
        }
    }
}
