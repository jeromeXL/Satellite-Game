package unsw.blackout.Entity.Device;

import unsw.utils.Angle;

public class HandheldDevice extends Device {

    // Constructor
    public HandheldDevice(String deviceId, String type, Angle position) {
        super(deviceId, type, position);
        this.setRange(50000);
    }
}