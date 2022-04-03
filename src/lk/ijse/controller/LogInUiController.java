package lk.ijse.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

public class LogInUiController {
    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;

    public void logInOnAction(ActionEvent actionEvent) {
        String userName = txtUserName.getText();
        String password = pwdPassword.getText();
        if (userName.equals("admin") && password.equals("1234")) {

        }
    }
}