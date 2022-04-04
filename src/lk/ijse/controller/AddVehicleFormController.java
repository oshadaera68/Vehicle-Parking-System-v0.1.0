package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.model.Bus;
import lk.ijse.model.Van;
import lk.ijse.model.Vehicle;
import lk.ijse.view.tm.VehicleTm;

import java.util.ArrayList;

public class AddVehicleFormController {
    public JFXTextField txtVehicleNum;
    public JFXTextField txtMaxWeight;
    public JFXTextField txtNoOfPassengers;
    public JFXComboBox cmbVehicleType;
    public TableView tblAddVehicle;
    public TableColumn colVehicleNum;
    public TableColumn colNoOfPassengers;
    public TableColumn colMaxWeight;
    public TableColumn colVehicleType;

    public static ObservableList<VehicleTm> vehicleTMS = FXCollections.observableArrayList();
    public static ArrayList<Vehicle> vehicleArrayList = new ArrayList();

    //Add vehicle details

    static {
        vehicleArrayList.add(new Bus("NA-3434", "Bus", 3500, 60));
        vehicleArrayList.add(new Van("KA-4563", "Van", 1000, 7));
        vehicleArrayList.add(new Van("58-3567", "Van", 1500, 4));
        vehicleArrayList.add(new Van("GF-4358", "Van", 800, 4));
        vehicleArrayList.add(new Van("CCB-3568", "Van", 1800, 8));
        vehicleArrayList.add(new Van("LM-6679", "Van", 1500, 4));
        vehicleArrayList.add(new Van("QA-3369", "Van", 1800, 6));
        vehicleArrayList.add(new CargoLorry("KB-3668", "Cargo Lorry", 2500, 2));
        vehicleArrayList.add(new CargoLorry("JJ-9878", "Cargo Lorry", 3000, 2));
        vehicleArrayList.add(new CargoLorry("GH-5772", "Cargo Lorry", 4000, 3));
        vehicleArrayList.add(new CargoLorry("XY-4456", "Cargo Lorry", 3500, 2));
        vehicleArrayList.add(new CargoLorry("YQ-3536", "Cargo Lorry", 2000, 2));
        vehicleArrayList.add(new CargoLorry("CBB-3566", "Cargo Lorry", 2500, 2));
        vehicleArrayList.add(new CargoLorry("QH-3444", "Cargo Lorry", 5000, 4));
    }


    public void addVehicleOnAction(ActionEvent actionEvent) {
    }

    public void cancelOnAction(ActionEvent actionEvent) {
    }
}
