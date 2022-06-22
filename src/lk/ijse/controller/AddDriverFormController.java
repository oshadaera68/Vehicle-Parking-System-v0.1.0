/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.model.Driver;
import lk.ijse.view.tm.DriverTm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class AddDriverFormController {
    public static ArrayList<Driver> driverArrayList = new ArrayList<>();

    static {
        driverArrayList.add(new Driver("Sumith Kumara", "7835348345V", "B6474845", "Panadura", "0725637456"));
        driverArrayList.add(new Driver("Amila Pathirana", "8826253734V", "B3354674", "Galle", "0717573583"));
        driverArrayList.add(new Driver("Jithmal Perera", "9283289272V", "B3674589", "Horana", "0772452457"));
        driverArrayList.add(new Driver("Sumith Dissanayaka", "9425245373V", "B8366399", "Kaluthara", "0782686390"));
        driverArrayList.add(new Driver("Sumanasiri Herath ", "8976544373V", "B3537538", "Beruwala", "0772534436"));
        driverArrayList.add(new Driver("Awantha Fernando", "9173537839V", "B3554789", "Colombo 5", "0714534356"));
        driverArrayList.add(new Driver("Charith Sudara", "9573536833V", "B6835836", "Baththaramulla", "0771536662"));
        driverArrayList.add(new Driver("Prashan Dineth", "9362426738V", "B2683536", "Wadduwa", "0715353434"));
        driverArrayList.add(new Driver("Chethiya Dilan", "9162353436V", "B6836836", "Panadura", "0772436737"));
        driverArrayList.add(new Driver("Dushantha Perera", "9255556343V", "B3334435", "Matara", "0777245343"));
        driverArrayList.add(new Driver("Sumith Udayanga", "8735354355V", "B3573783", "Galle", "0703635442"));
        driverArrayList.add(new Driver("Dinesh Udara", " 9026344373V", " B5343783", "Hettimulla", " 0713456878"));
        driverArrayList.add(new Driver("Udana Chathuranga", "9692653338V", "B7888632", "Kottawa", " 0772442444"));
        driverArrayList.add(new Driver("Mohommad Riaz", "9124537733V", "B3638537", "Kaluthara", "0777544222"));
        driverArrayList.add(new Driver("Sandun Kumara", "9563524267V", "B2263333", "Panadura", "0772325544"));
        driverArrayList.add(new Driver("Priyanga Perera", "9135343537V", "B3853753", "Matara", "0723344562"));
    }

    public JFXTextField txtDriverName;
    public JFXTextField txtNIC;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    public JFXTextField txtDLNo;
    public TableView<DriverTm> tblDrivers;
    public TableColumn<Object, Object> colDriverName;
    public TableColumn<Object, Object> colNIC;
    public TableColumn<Object, Object> colDLNo;
    public TableColumn<Object, Object> colAddress;
    public TableColumn<Object, Object> colContactNo;
    public TableColumn<Object, Object> colOption;
    public JFXButton btnSave;
    public AnchorPane context;

    public void initialize() {
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDLNo.setCellValueFactory(new PropertyValueFactory<>("dLno"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colOption.setCellValueFactory(new PropertyValueFactory<>("btn"));

        tblDrivers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(DriverTm tm) {
        btnSave.setText("Update");
        txtDriverName.setText(tm.getName());
        txtNIC.setText(tm.getNic());
        txtDLNo.setText(tm.getdLno());
        txtAddress.setText(tm.getAddress());
        txtContactNo.setText(tm.getContact());
    }

    public void newDriverOnAction(ActionEvent actionEvent) {
        btnSave.setText("Save");
    }

    private void loadAllDriverDetails() {
        ObservableList<DriverTm> driverTms = FXCollections.observableArrayList();
        for (Driver d1 : driverArrayList) {
            Button button = new Button("Remove driver");
            driverTms.add(new DriverTm(d1.getName(), d1.getNic(), d1.getdLNo(), d1.getAddress(), d1.getcNo(), button));
            button.setOnAction(e -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, txtNIC.getText() + " is " + txtDriverName.getText() + ". Are you delete surely?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if (buttonType.get().equals(ButtonType.YES)) {
                    driverArrayList.remove(d1);
                    loadAllDriverDetails();
                    new Alert(Alert.AlertType.CONFIRMATION, txtDriverName.getText() + "is deleted...!", ButtonType.OK).show();
                }
            });
        }
        tblDrivers.setItems(driverTms);
    }

    public void saveOnAction(ActionEvent actionEvent) {
        if (driverArrayList.size() == 16) {
            new Alert(Alert.AlertType.WARNING, "company drivers are full...", ButtonType.OK).show();
        } else {
            if (btnSave.getText().equals("Save")) {
                Driver driver = new Driver(
                        txtDriverName.getText(),
                        txtNIC.getText(),
                        txtDLNo.getText(),
                        txtAddress.getText(),
                        txtContactNo.getText()
                );
                new Alert(Alert.AlertType.CONFIRMATION, txtDriverName.getText() + "is added", ButtonType.OK).show();
                driverArrayList.add(driver);
                loadAllDriverDetails();
            } else {
                for (Driver temp : driverArrayList) {
                    if (temp.getNic().equals(txtNIC.getText())) {
                        temp.setName(txtDriverName.getText());
                        temp.setdLNo(txtDLNo.getText());
                        temp.setAddress(txtAddress.getText());
                        temp.setcNo(txtContactNo.getText());
                        new Alert(Alert.AlertType.CONFIRMATION, "Updated...", ButtonType.OK).show();
                        loadAllDriverDetails();
                        return;
                    }
                }
            }
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) context.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ManagementForm.fxml"))));
        stage.show();
    }
}
