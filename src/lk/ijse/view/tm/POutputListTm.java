package lk.ijse.view.tm;

public class POutputListTm {
    private String VehicleNumber;
    private String VehicleType;
    private int ParkingSlot;
    private String ParkedTime;

    public POutputListTm() {
    }

    public POutputListTm(String vehicleNumber, String vehicleType, int parkingSlot, String parkedTime) {
        VehicleNumber = vehicleNumber;
        VehicleType = vehicleType;
        ParkingSlot = parkingSlot;
        ParkedTime = parkedTime;
    }

    public String getVehicleNumber() {
        return VehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        VehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String vehicleType) {
        VehicleType = vehicleType;
    }

    public Integer getParkingSlot() {
        return ParkingSlot;
    }

    public void setParkingSlot(Integer parkingSlot) {
        ParkingSlot = parkingSlot;
    }

    public String getParkedTime() {
        return ParkedTime;
    }

    public void setParkedTime(String parkedTime) {
        ParkedTime = parkedTime;
    }
}
