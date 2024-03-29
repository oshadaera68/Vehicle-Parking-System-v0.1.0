package lk.ijse.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LogInUiController {
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;
    public AnchorPane rootContext;

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = pwdPassword.getText();
        if (userName.equals("admin") && password.equals("1234")) {
            Parent load = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
            Stage window = (Stage) rootContext.getScene().getWindow();
            window.setTitle("Dashboard Form - VMS v0.1");
            window.setScene(new Scene(load));
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again").showAndWait();
        }
    }
}