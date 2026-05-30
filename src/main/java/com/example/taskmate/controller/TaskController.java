package com.example.taskmate.controller;

import com.example.taskmate.model.Task;
import com.example.taskmate.repository.TaskRepository;

import com.example.taskmate.util.SceneManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;


import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class TaskController {

//  INPUTS
    @FXML
    private TextField taskInput;
    @FXML
    private DatePicker deadlineInput;
    @FXML
    private Button addTaskBtn;

//    DATA
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, Integer> idColumn;
    @FXML
    private TableColumn<Task, String> taskColumn;
    @FXML TableColumn<Task, Date> deadlineColumn;
    @FXML
    private Button refreshButton;

    private final TaskRepository repository = new TaskRepository();

    @FXML
    private void handleRefresh() {
        System.out.println("Refresh clicked");
    }

    @FXML
    private void initialize(){
        System.out.println(taskTable);
        System.out.println(idColumn);
        System.out.println(taskColumn);

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        taskColumn.setCellValueFactory(new PropertyValueFactory<>("text"));
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));

        loadTasks();
    }

    private void loadTasks(){
        try{
            List<Task> tasks = repository.findAll();

            ObservableList<Task> data = FXCollections.observableArrayList(tasks);

            taskTable.setItems(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void addTask(){
        String text = taskInput.getText();
        Date deadline = Date.valueOf(deadlineInput.getValue());

        Task task = new Task(text, deadline);

        try{
            repository.addTask(task);

            loadTasks();

            taskInput.clear();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void logout() throws IOException {
        SceneManager sceneManager = new SceneManager();

        SceneManager.switchScene("login.fxml");
    }
}
