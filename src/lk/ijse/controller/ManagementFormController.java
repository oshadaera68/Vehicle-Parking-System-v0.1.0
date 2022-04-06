package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public void addVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddVehicleForm.fxml"))));
        stage.show();
    }

    public void addDriverOnAction(ActionEvent actionEvent) {
    }

    public void logOutOnAction(ActionEvent actionEvent) {
    }
}
