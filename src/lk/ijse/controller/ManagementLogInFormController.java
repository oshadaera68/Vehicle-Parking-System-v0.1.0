/**
 * @Owner - Oshada Eranga
 * @version - v0.1
 */

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

public class ManagementLogInFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    public AnchorPane rootContext;

    public void logInOnAction(ActionEvent actionEvent) throws IOException {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();
        if (userName.equals("manage") && password.equals("1234")) {
            Parent load = FXMLLoader.load(getClass().getResource("../view/ManagementForm.fxml"));
            Stage window = (Stage) rootContext.getScene().getWindow();
            window.setTitle("Management Form - VMS v0.1");
            window.setScene(new Scene(load));
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again..").showAndWait();
        }
    }
}