package unsw.blackout.Entity.Device;

import unsw.utils.Angle;

public class LaptopDevice extends Device {

    // Constructor
    public LaptopDevice(String deviceId, String type, Angle position) {
        super(deviceId, type, position);
        this.setRange(100000);
    }
}
