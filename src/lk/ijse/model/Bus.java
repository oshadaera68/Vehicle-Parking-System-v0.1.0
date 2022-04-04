package lk.ijse.model;

import java.io.IOException;

import static lk.ijse.controller.ManagementFormController.pOutputListTM;

public class Bus extends Vehicle {
    final int[] busSlot = new int[]{14};

    public Bus() {
        super();
    }

    public Bus(String vehicleNumber, String vehicleType, double maxWeight, int noPassengers) {
        super(vehicleNumber, vehicleType, maxWeight, noPassengers);
    }

    @Override
    public int park(String vehicleNumber, String vehicleType) throws IOException {
        B1:
        for (int i : busSlot) {
            if (pOutputListTM.size() == 0) {
                return i;
            } else {
                B2:
                for (int j = 0; j < pOutputListTM.size(); j++) {
                    if (pOutputListTM.get(j).getParkingSlot() == i) {
                        continue B1;
                    } else {
                        if (j != pOutputListTM.size() - 1) {
                            continue B2;
                        } else {
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
