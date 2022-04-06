/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AddDriverFormController {
    public JFXTextField txtDriverName;
    public JFXTextField txtNIC;
    public JFXTextField txtContactNo;
    public JFXTextField txtAddress;
    public JFXTextField txtDLNo;
    public TableView tblDrivers;
    public TableColumn colDriverName;
    public TableColumn colNIC;
    public TableColumn colDLNo;
    public TableColumn colAddress;
    public TableColumn colContactNo;

    public void newDriverOnAction(ActionEvent actionEvent) {
    }

    public void saveOnAction(ActionEvent actionEvent) {
    }

    public void cancelOnAction(ActionEvent actionEvent) {
    }
}
