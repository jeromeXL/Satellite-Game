package unsw.blackout.Entity.Device;

import unsw.utils.Angle;

public class DesktopDevice extends Device {
    
    // Constructor 
    public DesktopDevice(String deviceId, String type, Angle position) {
        super(deviceId, type, position);
        this.setRange(200000);
    }
}
