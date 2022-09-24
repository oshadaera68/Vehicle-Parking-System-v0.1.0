package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.view.tm.DOutputListTm;
import lk.ijse.view.tm.POutputListTm;

import java.io.IOException;

public class ManagementFormController {
    public static ObservableList<POutputListTm> pOutputListTM = FXCollections.observableArrayList();
    public static ObservableList<DOutputListTm> dOutputListTM = FXCollections.observableArrayList();
    public JFXComboBox cmbOption;
    public TableView<POutputListTm> tblVehicle;
    public TableColumn colVehicleNum;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public AnchorPane rootContext;
    public TableView<DOutputListTm> tblDeliver;
    public TableColumn colDVehicleNum;
    public TableColumn colDName;
    public TableColumn colVehicleType1;
    public TableColumn colLeaveTime;
    public JFXButton btnAdd;
    public JFXButton btnLogOut;

    public void initialize() {
        cmbOption.getItems().addAll("In Parking", "On Deliver");
        cmbOption.setValue("In Parking");
        colVehicleNum.setCellValueFactory(new PropertyValueFactory<>("VehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("VehicleType"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("ParkingSlot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("ParkedTime"));

        colVehicleNum.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType1.setCellValueFactory(new PropertyValueFactory<>("VehicleType"));
        colDName.setCellValueFactory(new PropertyValueFactory<>("DriverName"));
        colLeaveTime.setCellValueFactory(new PropertyValueFactory<>("LeftTime"));
        tblVehicle.setItems(pOutputListTM);
        tblDeliver.setItems(dOutputListTM);
    }

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

    public void selectiveCmbOnAction(ActionEvent actionEvent) {
        if (cmbOption.getValue().equals("On Deliver")) {
            btnLogOut.setVisible(false);
            tblVehicle.setVisible(false);
            tblDeliver.setVisible(true);
        } else {
            btnLogOut.setVisible(true);
            tblDeliver.setVisible(false);
            tblVehicle.setVisible(true);
        }
    }
}