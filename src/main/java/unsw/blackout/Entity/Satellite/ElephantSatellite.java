package unsw.blackout.Entity.Satellite;

import unsw.utils.Angle;

public class ElephantSatellite extends Satellite{

    // Constructor
    public ElephantSatellite(String satelliteId, String type, Angle position, double height) {
        super(satelliteId, type, position, height);

        this.setRange(400000);

        this.setSendSpeed(20);
        this.setReceiveSpeed(20);
        this.setLinearSpeed(2500);
        this.setFileLimit(Integer.MAX_VALUE);
        this.setByteLimit(90);
    }

}
