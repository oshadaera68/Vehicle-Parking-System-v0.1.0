package lk.ijse.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInUiController {
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = pwdPassword.getText();
        if (userName.equals("admin") && password.equals("1234")) {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagementForm.fxml"))));
            stage.setTitle("Management Form | Vehicle Parking System");
            stage.show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Try Again").showAndWait();
        }
    }
}