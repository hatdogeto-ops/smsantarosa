package com.example.taskmate.repository;

import com.example.taskmate.model.User;
import com.example.taskmate.util.Database;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public User findUser(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE name = ?";

        try(Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                return new User(
                  rs.getInt("id"),
                  rs.getString("name"),
                  rs.getString("password")
                );
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    public boolean createUser(String username, String passwordHash) {

        String sql = "INSERT INTO users(name, password) VALUES(?, ?)";

        try (
                Connection connection = Database.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)
        ) {

            stmt.setString(1, username);
            stmt.setString(2, passwordHash);

            int rows = stmt.executeUpdate();

            System.out.println("Rows inserted: " + rows);

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
