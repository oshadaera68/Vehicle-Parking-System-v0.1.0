package lk.ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.model.Bus;
import lk.ijse.model.CargoLorry;
import lk.ijse.model.Van;
import lk.ijse.model.Vehicle;
import lk.ijse.view.tm.VehicleTm;

import java.io.IOException;
import java.util.ArrayList;

public class AddVehicleFormController {
    public static ObservableList<VehicleTm> vehicleTMS = FXCollections.observableArrayList();
    public static ArrayList<Vehicle> vehicleArrayList = new ArrayList();

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

    public JFXTextField txtVehicleNum;
    public JFXTextField txtMaxWeight;
    public JFXTextField txtNoOfPassengers;
    public JFXComboBox cmbVehicleType;
    public TableView tblAddVehicle;
    public TableColumn colVehicleNum;
    public TableColumn colNoOfPassengers;
    public TableColumn colMaxWeight;
    public TableColumn colVehicleType;
    public AnchorPane context;

    public void initialize() {
        /*Table setup*/
        cmbVehicleType.getItems().addAll("Van", "Bus", "CargoLorry");
        colVehicleNum.setCellValueFactory(new PropertyValueFactory<>("vehicleNumber"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleType"));
        colMaxWeight.setCellValueFactory(new PropertyValueFactory<>("maxWeight"));
        colNoOfPassengers.setCellValueFactory(new PropertyValueFactory<>("noPassengers"));
        loadAllVehicle();
    }

    private void loadAllVehicle() {
        for (Vehicle v1 : vehicleArrayList) {
            vehicleTMS.add(new VehicleTm(v1.getVehicleNumber(), v1.getVehicleType(), v1.getMaxWeight(), v1.getNoPassengers()));
        }
        tblAddVehicle.setItems(vehicleTMS);
    }


    public void addVehicleOnAction(ActionEvent actionEvent) {
        if (vehicleArrayList.size() == 14) {
            new Alert(Alert.AlertType.WARNING, "vehicles are full...", ButtonType.CLOSE).show();
        } else {
            if (vehicleArrayList.size() == 5) {
                new Alert(Alert.AlertType.WARNING, "vehicles are full...", ButtonType.CLOSE).show();
            } else {
                //save van
                if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Van")) {
                    Van van = new Van(txtVehicleNum.getText(), cmbVehicleType.getValue().toString(), Double.parseDouble(txtMaxWeight.getText()), Integer.parseInt(txtNoOfPassengers.getText()));
                    txtVehicleNum.clear();
                    txtMaxWeight.clear();
                    txtNoOfPassengers.clear();

                    if (vehicleArrayList.add(van)) {
                        loadAllVehicleDetails();
                        new Alert(Alert.AlertType.CONFIRMATION, cmbVehicleType.getValue() + "is saved", ButtonType.OK);
                    } else {
                        new Alert(Alert.AlertType.WARNING, cmbVehicleType.getValue() + "is try again", ButtonType.OK);
                    }
                }

                //save bus
                if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Bus")) {
                    Bus bus = new Bus(txtVehicleNum.getText(), cmbVehicleType.getValue().toString(), Double.parseDouble(txtMaxWeight.getText()), Integer.parseInt(txtNoOfPassengers.getText()));
                    txtVehicleNum.clear();
                    txtMaxWeight.clear();
                    txtNoOfPassengers.clear();

                    if (vehicleArrayList.add(bus)) {
                        loadAllVehicleDetails();
                        new Alert(Alert.AlertType.CONFIRMATION, cmbVehicleType.getValue() + "is saved", ButtonType.OK);
                    } else {
                        new Alert(Alert.AlertType.WARNING, cmbVehicleType.getValue() + "is try again", ButtonType.OK);
                    }
                }

                //save cargo lorry
                if (cmbVehicleType.getSelectionModel().getSelectedItem().toString().equals("Bus")) {
                    CargoLorry cargoLorry = new CargoLorry(txtVehicleNum.getText(), cmbVehicleType.getValue().toString(), Double.parseDouble(txtMaxWeight.getText()), Integer.parseInt(txtNoOfPassengers.getText()));
                    txtVehicleNum.clear();
                    txtMaxWeight.clear();
                    txtNoOfPassengers.clear();

                    if (vehicleArrayList.add(cargoLorry)) {
                        loadAllVehicleDetails();
                        new Alert(Alert.AlertType.CONFIRMATION, cmbVehicleType.getValue() + "is saved", ButtonType.OK);
                    } else {
                        new Alert(Alert.AlertType.WARNING, cmbVehicleType.getValue() + "is try again", ButtonType.OK);
                    }
                }
            }
        }
    }

    private void loadAllVehicleDetails() {
        ObservableList<Vehicle> vehicles = FXCollections.observableArrayList();
        if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("CargoLorry")) {
            for (Vehicle vCargoLorry : vehicleArrayList) {
                vehicles.add(new CargoLorry(vCargoLorry.getVehicleNumber(), vCargoLorry.getVehicleType(), vCargoLorry.getMaxWeight(), vCargoLorry.getNoPassengers()));
            }
            tblAddVehicle.setItems(vehicles);
        }

        if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Bus")) {
            for (Vehicle vBus : vehicleArrayList) {
                vehicles.add(new CargoLorry(vBus.getVehicleNumber(), vBus.getVehicleType(), vBus.getMaxWeight(), vBus.getNoPassengers()));
            }
            tblAddVehicle.setItems(vehicles);
        }

        if (cmbVehicleType.getSelectionModel().getSelectedItem().equals("Van")) {
            for (Vehicle vVan : vehicleArrayList) {
                vehicles.add(new CargoLorry(vVan.getVehicleNumber(), vVan.getVehicleType(), vVan.getMaxWeight(), vVan.getNoPassengers()));
            }
            tblAddVehicle.setItems(vehicles);
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagementForm.fxml"))));
        stage.show();
    }
}
