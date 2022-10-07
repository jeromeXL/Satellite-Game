package unsw.blackout.Entity.Satellite;

import unsw.utils.Angle;

public class TeleportingSatellite extends Satellite {

    boolean positiveDirection = true;
    
    // Constructor
    public TeleportingSatellite(String satelliteId, String type, Angle position, double height) {
        super(satelliteId, type, position, height);

        this.setRange(200000);

        this.setSendSpeed(10);
        this.setReceiveSpeed(15);
        this.setLinearSpeed(1000);
        this.setFileLimit(Integer.MAX_VALUE);
        this.setByteLimit(200);
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
        
        if (this.getPositiveDirection() == true) {
            Angle nextAngle = currentAngle.add(Angle.fromRadians(angularVelocity));
            if (nextAngle.toDegrees() >= 180) {
                this.setPosition(Angle.fromRadians(0));
                this.setPositiveDirection(false);
            } else {
                this.setPosition(currentAngle.add(Angle.fromRadians(angularVelocity)));
            }
        } 
        
        else { 
            Angle nextAngle = currentAngle.subtract(Angle.fromRadians(angularVelocity));
            if (nextAngle.toDegrees() <= 180) {
                this.setPosition(Angle.fromRadians(0));
                this.setPositiveDirection(true);
            } else {
                this.setPosition(currentAngle.subtract(Angle.fromRadians(angularVelocity)));
            }
        }
        
    }
}
