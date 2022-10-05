package unsw.blackout.Entity.Satellite;

import unsw.utils.Angle;

public class RelaySatellite extends Satellite {

    boolean positiveDirection = false;

    // Constructor
    public RelaySatellite(String satelliteId, String type, Angle position, double height) {
        super(satelliteId, type, position, height);

        this.setRange(300000);

        this.setLinearSpeed(1500);
        this.setFileLimit(Integer.MAX_VALUE);
        this.setByteLimit(Integer.MAX_VALUE);
    }

    // Getter 
    public boolean getPositiveDirection() {
        return positiveDirection;
    }

    // Setter
    public void setPositiveDirection(boolean positiveDirection) {
        this.positiveDirection = positiveDirection;
    }

    // Movement
    public void movement() {

        double angularVelocity = this.getAngularVelocity();
        Angle currentAngle = this.getPosition();

        // Outside of Region
        if (currentAngle.toDegrees() < 140 || currentAngle.toDegrees() > 190) {
            // Threshold 345 - Take positive direction
            if ((currentAngle.toDegrees() >= 0 && currentAngle.toDegrees() < 140) || (currentAngle.toDegrees() >= 345 && currentAngle.toDegrees() < 360)) {
                this.setPosition(currentAngle.add(Angle.fromRadians(angularVelocity)));
                positiveDirection = true;
            } 
            else  { // Take negative direction
                this.setPosition(currentAngle.subtract(Angle.fromRadians(angularVelocity)));
                positiveDirection = false;
            }
        } 
        // Inside Region - Continue going in same direction
        else {
            if (positiveDirection) {
                this.setPosition(currentAngle.add(Angle.fromRadians(angularVelocity)));
            } else {
                this.setPosition(currentAngle.subtract(Angle.fromRadians(angularVelocity)));
            }
        }

    }

}
