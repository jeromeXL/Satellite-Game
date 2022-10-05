package unsw.blackout.Entity.Satellite;

import unsw.utils.Angle;

public class StandardSatellite extends Satellite {

    // Constructor
    public StandardSatellite(String satelliteId, String type, Angle position, double height) {
        super(satelliteId, type, position, height);

        this.setRange(150000);

        this.setSendSpeed(1);
        this.setReceiveSpeed(1);
        this.setLinearSpeed(2500);
        this.setFileLimit(3);
        this.setByteLimit(80);
    }

    // Movement 
    public void movement() {
        double angularVelocity = this.getAngularVelocity();
        Angle currentAngle = this.getPosition();
        this.setPosition(currentAngle.subtract(Angle.fromRadians(angularVelocity)));
    }
}
