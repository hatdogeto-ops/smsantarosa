package com.example.taskmate.controller;

import com.example.taskmate.util.Authentication;
import com.example.taskmate.util.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SignupController {

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Button signupBtn;

    private final Authentication authService = new Authentication();
    @FXML
    private void handleSignup() throws IOException {
        String username = usernameInput.getText();
        String password = passwordInput.getText();

        boolean success = authService.register(username, password);

        if(success){
            SceneManager.switchScene("login.fxml");
        } else {
            System.out.println("Signup failed");
        }
    }
}
