package com.example.taskmate;

import com.example.taskmate.app.HelloApplication;
import com.example.taskmate.repository.TaskRepository;
import com.example.taskmate.model.Task;
import javafx.application.Application;

import java.sql.SQLException;
import java.util.List;

public class Launcher {
    public static void main(String[] args) throws SQLException {
        Application.launch(HelloApplication.class, args);
    }
}
