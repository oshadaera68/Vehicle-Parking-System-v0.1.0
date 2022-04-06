/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.model.Driver;
import lk.ijse.view.tm.DriverTm;

import java.util.ArrayList;

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
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void cancelOnAction(ActionEvent actionEvent) {
    }
}
