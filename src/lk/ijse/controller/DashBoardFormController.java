package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.model.Driver;
import lk.ijse.model.Vehicle;
import lk.ijse.view.tm.DOutputListTm;
import lk.ijse.view.tm.POutputListTm;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import static lk.ijse.controller.ManagementFormController.dOutputListTM;
import static lk.ijse.controller.ManagementFormController.pOutputListTM;

public class DashBoardFormController {
    public static ArrayList<Vehicle> tmpVehicleArrayList = AddVehicleFormController.vehicleArrayList;
    public static ArrayList<Driver> tmpDriverArrayList = AddDriverFormController.driverArrayList;
    public JFXComboBox<String> cmbSelectVehicle;
    public JFXComboBox<String> cmbDrivers;
    public Label lblTime;
    public Label lblDate;
    public JFXButton btnPark;
    public JFXButton btnOnDeliveryShift;
    public JFXTextField txtSlotNo;
    public Label lblVehicleType;
    String time;

    public void initialize() {
        loadDateAndTime();
        dataLoader();
    }

    private void dataLoader() {
        ObservableList<String> vehicleList = FXCollections.observableArrayList();
        for (Vehicle temp : tmpVehicleArrayList) {
            vehicleList.add(temp.getVehicleNumber());
        }
        cmbSelectVehicle.setItems(vehicleList);

        ObservableList<String> driverList = FXCollections.observableArrayList();
        for (Driver temp : tmpDriverArrayList) {
            driverList.add(temp.getName());
        }
        cmbDrivers.setItems(driverList);

        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtSlotNo.clear();
            cmbSelectVehicle.setAccessibleText(newValue);
            for (Vehicle temp : tmpVehicleArrayList) {
                if (newValue.equals(temp.getVehicleNumber())) {
                    lblVehicleType.setText(temp.getVehicleType());
                    disableAndEnableButtonOption(cmbSelectVehicle.getValue());
                    if (!btnPark.isDisable()) {
                        try {
                            txtSlotNo.setText(temp.park(temp.getVehicleNumber(), temp.getVehicleType()) + "");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }

    public void disableAndEnableButtonOption(String value) {
        btnPark.setDisable(false);
        btnOnDeliveryShift.setDisable(false);
        for (POutputListTm temp : pOutputListTM){
            if (temp.getVehicleNumber().equals(value)) {
                btnPark.setDisable(true);
            }
        }
        if (!btnPark.isDisable()){
            btnOnDeliveryShift.setDisable(true);
        }
    }

    private void loadDateAndTime() {
        lblDate.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date())); //set date
        Timeline t1 = new Timeline(
                new KeyFrame(Duration.ZERO, e -> {
                    LocalTime cTime = LocalTime.now();
                    lblTime.setText(cTime.getHour() + " : " + cTime.getMinute() + " : " + cTime.getSecond());
                }),
                new KeyFrame(Duration.seconds(1))
        );
        t1.setCycleCount(Animation.INDEFINITE);
        t1.play();
    }

    public void parkVehicleOnAction(ActionEvent actionEvent) {
        time = lblTime.getText();
        if (cmbSelectVehicle.getValue() != null) {
            POutputListTm tm = new POutputListTm(cmbSelectVehicle.getValue(), lblVehicleType.getText(), Integer.parseInt(txtSlotNo.getText()), time);
            pOutputListTM.add(tm);
            new Alert(Alert.AlertType.CONFIRMATION, "is delivered..!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Select Vehicle to parking.").show();
        }
    }

    public void onDeliveryShiftOnAction(ActionEvent actionEvent) {
        time = lblTime.getText();
        if (cmbDrivers.getValue() != null) {
            pOutputListTM.removeIf(temp -> temp.getVehicleNumber().equals(cmbSelectVehicle.getValue()));
            DOutputListTm onDelivers = new DOutputListTm(cmbSelectVehicle.getValue(), lblVehicleType.getText(), cmbDrivers.getValue(), time);
            dOutputListTM.add(onDelivers);
            new Alert(Alert.AlertType.CONFIRMATION, "is delivered..!").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Select Vehicle to parking.").show();
        }
    }

    public void managementLogInOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LogInUi.fxml"))));
        stage.setTitle("Log in");
        stage.show();
    }
}