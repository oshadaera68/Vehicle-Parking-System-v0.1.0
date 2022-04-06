/**
 * @Owner - Oshada Eranga
 * @Version - v0.1.0
 **/

package lk.ijse.model;

public class Driver {
    private String name;
    private String nic;
    private String dLNo;
    private String address;
    private String cNo;

    public Driver() {
    }

    public Driver(String name, String nic, String dLNo, String address, String cNo) {
        this.name = name;
        this.nic = nic;
        this.dLNo = dLNo;
        this.address = address;
        this.cNo = cNo;
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

    public String getdLNo() {
        return dLNo;
    }

    public void setdLNo(String dLNo) {
        this.dLNo = dLNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", dLNo='" + dLNo + '\'' +
                ", address='" + address + '\'' +
                ", cNo='" + cNo + '\'' +
                '}';
    }
}
