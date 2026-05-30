package com.example.taskmate.repository;

import com.example.taskmate.model.Task;
import com.example.taskmate.util.Database;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class TaskRepository {


    public List<Task> findAll() throws SQLException {
        String sql = "SELECT * FROM tasks";

        List<Task> tasks = new ArrayList<>();

        try(
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery()
            ){

             while (rs.next()) {
                tasks.add(new Task(rs.getString("text"), rs.getDate("deadline")));
            }
        }

        return tasks;
    }

    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO tasks(text, deadline) VALUES(?, ?)";

        try(
                Connection connection = Database.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
                ){
            statement.setString(1, task.getText());
            statement.setDate(2, task.getDeadline());

            statement.executeUpdate();
        }
    }
}
