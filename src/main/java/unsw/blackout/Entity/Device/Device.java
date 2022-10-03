package unsw.blackout.Entity.Device;

import unsw.blackout.Entity.Entity;
import unsw.utils.Angle;
import unsw.utils.MathsHelper;

public class Device extends Entity {

    // Constructor
    public Device(String deviceId, String type, Angle position){
        super(deviceId, position, type);
        this.setHeight(MathsHelper.RADIUS_OF_JUPITER);
    }

}
