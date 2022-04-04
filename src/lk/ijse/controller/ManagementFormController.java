package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.view.tm.DOutputListTM;
import lk.ijse.view.tm.POutputListTM;

public class ManagementFormController {
    public static ObservableList<POutputListTM> pOutputListTM = FXCollections.observableArrayList();
    public static ObservableList<DOutputListTM> dOutputListTM = FXCollections.observableArrayList();
    public JFXComboBox cmbOption;
    public TableView tblVehicle;
    public TableColumn colVehicleNum;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;

    public void addVehicleOnAction(ActionEvent actionEvent) {
    }

    public void addDriverOnAction(ActionEvent actionEvent) {
    }

    public void logOutOnAction(ActionEvent actionEvent) {
    }
}
