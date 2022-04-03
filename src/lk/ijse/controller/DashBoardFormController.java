package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class DashBoardFormController {
    public JFXComboBox cmbSelectVehicle;
    public JFXTextField txtVehicleType;
    public JFXComboBox cmbDrivers;
    public Label lblTime;
    public Label lblDate;

    public void initialize() {
        loadDateAndTime();
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
    }

    public void onDeliveryShiftOnAction(ActionEvent actionEvent) {
    }

    public void managementLogInOnAction(ActionEvent actionEvent) {
    }
}
