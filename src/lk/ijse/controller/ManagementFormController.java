package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.view.tm.DOutputListTm;
import lk.ijse.view.tm.POutputListTm;

import java.io.IOException;

public class ManagementFormController {
    public static ObservableList<POutputListTm> pOutputListTM = FXCollections.observableArrayList();
    public static ObservableList<DOutputListTm> dOutputListTM = FXCollections.observableArrayList();
    public JFXComboBox cmbOption;
    public TableView tblVehicle;
    public TableColumn colVehicleNum;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public AnchorPane rootContext;

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/AddVehicleForm.fxml"));
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Add Vehicle - VMS v0.1");
        window.setScene(new Scene(load));
    }

    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/AddDriverForm.fxml"));
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Add Driver - VMS v0.1");
        window.setScene(new Scene(load));
    }

    public void logOutOnAction(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(getClass().getResource("../view/DashBoardForm.fxml"));
        Stage window = (Stage) rootContext.getScene().getWindow();
        window.setTitle("Dashboard Form - VMS v0.1");
        window.setScene(new Scene(load));
    }
}
