package unsw.blackout.Entity.Satellite;

import unsw.utils.Angle;

public class TeleportingSatellite extends Satellite {
    
    // Constructor
    public TeleportingSatellite(String satelliteId, String type, Angle position, double height) {
        super(satelliteId, type, position, height);

        this.setRange(200000);

        this.setSendSpeed(10);
        this.setReceiveSpeed(15);
        this.setLinearSpeed(1000);
        this.setFileLimit(200); // file cannot be 0 bytes, thus max no of files must be equal to byte limit
        this.setByteLimit(200);
    }

}
