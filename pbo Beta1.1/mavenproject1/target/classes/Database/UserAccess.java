package Database;

import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserAccess {
    private Connection connection;

    public UserAccess(Connection connection) {
        this.connection = connection;
    }

    public void registerUser(User user) throws SQLException {
        String query = "INSERT INTO user (user_id, Nama, Password, balance) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setDouble(4, user.getBalance());
            statement.executeUpdate();
        }
    }

    public boolean isUserIdExists(int id) throws SQLException {
        String query = "SELECT COUNT(*) FROM user WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public User loginUser(String username, String password) throws SQLException {
        String query = "SELECT * FROM user WHERE Nama = ? AND Password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    double balance = resultSet.getDouble("balance");
                    return new User(id, username, password, balance);
                } else {
                    return null;
                }
            }
        }
    }
    
    public User getUser(int user_id) throws SQLException {
        String query = "SELECT * FROM user WHERE user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, user_id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("user_id");
                    String username = resultSet.getString("Nama");
                    String password = resultSet.getString("Password");
                    double balance = resultSet.getDouble("balance");
                    return new User(id, username, password, balance);
                } else {
                    return null;
                }
            }
        }
    }
    

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                double balance = resultSet.getDouble("balance");
                users.add(new User(id, username, password, balance));
            }
        }
        return users;
    }
}
