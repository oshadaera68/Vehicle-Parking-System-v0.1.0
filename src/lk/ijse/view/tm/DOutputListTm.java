package lk.ijse.view.tm;

public class DOutputListTm {
    private String VehicleNumber;
    private String VehicleType;
    private String DriverName;
    private  String  LeftTime;

    public DOutputListTm() {
    }

    public DOutputListTm(String vehicleNumber, String vehicleType, String driverName, String leftTime) {
        VehicleNumber = vehicleNumber;
        VehicleType = vehicleType;
        DriverName = driverName;
        LeftTime = leftTime;
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

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getLeftTime() {
        return LeftTime;
    }

    public void setLeftTime(String leftTime) {
        LeftTime = leftTime;
    }
}
