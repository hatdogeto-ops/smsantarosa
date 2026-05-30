module com.example.taskmate {
    requires javafx.controls;
    requires javafx.fxml;
    requires io.github.cdimascio.dotenv.java;
    requires java.sql;
    requires jbcrypt;


    opens com.example.taskmate to javafx.fxml;
    exports com.example.taskmate;
    exports com.example.taskmate.app;
    opens com.example.taskmate.app to javafx.fxml;
    exports com.example.taskmate.controller;
    opens com.example.taskmate.controller to javafx.fxml;
    opens com.example.taskmate.model to javafx.base;
}