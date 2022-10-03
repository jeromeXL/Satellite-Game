package unsw.blackout.Entity.Satellite;

import unsw.utils.Angle;

public class RelaySatellite extends Satellite {

    // Constructor
    public RelaySatellite(String satelliteId, String type, Angle position, double height) {
        super(satelliteId, type, position, height);

        this.setRange(300000);

        this.setLinearSpeed(1500);
        this.setFileLimit(Integer.MAX_VALUE);
        this.setByteLimit(Integer.MAX_VALUE);
    }

}
