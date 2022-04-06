/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.view.tm;

import javafx.scene.control.Button;

public class DriverTm {
    private String name;
    private String nic;
    private String dLno;
    private String address;
    private String contact;
    private Button btn;

    public DriverTm() {
    }

    public DriverTm(String name, String nic, String dLno, String address, String contact, Button btn) {
        this.name = name;
        this.nic = nic;
        this.dLno = dLno;
        this.address = address;
        this.contact = contact;
        this.btn = btn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getdLno() {
        return dLno;
    }

    public void setdLno(String dLno) {
        this.dLno = dLno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "DriverTm{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", dLno='" + dLno + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", btn=" + btn +
                '}';
    }
}
