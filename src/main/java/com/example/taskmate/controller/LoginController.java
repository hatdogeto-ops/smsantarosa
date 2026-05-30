package com.example.taskmate.controller;

import com.example.taskmate.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import com.example.taskmate.util.Authentication;

import java.io.IOException;
import java.sql.SQLException;

public class LoginController {


    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Button loginBtn;

    private final Authentication authentication =  new Authentication();
    @FXML
    private void handleLogin() throws SQLException, IOException {

        String username = usernameInput.getText();
        String password = passwordInput.getText();

        boolean success = authentication.login(username, password);

        if(success){
            SceneManager.switchScene("tasks.fxml");
        } else {
            System.out.println("Invalid credentials");
        }
    }

    @FXML
    private void createAccount() throws IOException {
        SceneManager sceneManager = new SceneManager();

        SceneManager.switchScene("signup.fxml");
    }




}
