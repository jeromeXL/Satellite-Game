package unsw.blackout;

import unsw.blackout.Entity.*;
import unsw.blackout.Entity.Device.*;
import unsw.blackout.Entity.Satellite.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import unsw.utils.Angle;
import unsw.utils.MathsHelper;

public class Communication {

    // Attributes
    private String id;
    private List<Device> devices;
    private List<Satellite> satellites;
    private List<String> communicableEntities = new ArrayList<>();

    // Constructor
    public Communication(String id, HashMap<String, Device> devices, HashMap<String, Satellite> satellites) {
        this.id = id;
        for (Device device: devices.values()){
            this.devices.add(device);
        }
        for (Satellite satellite: satellites.values()){
            this.satellites.add(satellite);
        }
    }

    // Getter
    public List<String> getCommunicableEntities() {
        return communicableEntities;
    }
    
    // Visibility Checks
    public boolean visibilityDtoS(Device device, Satellite satellite) {
        return MathsHelper.isVisible(satellite.getHeight(), satellite.getPosition(), device.getPosition());
    }
    public boolean visibilityStoS(Satellite satelliteA, Satellite satelliteB) {
        return MathsHelper.isVisible(satelliteA.getHeight(), satelliteA.getPosition(), satelliteB.getHeight(), satelliteB.getPosition());
    }
    // Distance Checks
    public double distanceDtoS(Device device, Satellite satellite) {
        return MathsHelper.getDistance(satellite.getHeight(), satellite.getPosition(), device.getPosition());   
    }
    public double distanceStoS(Satellite satelliteA, Satellite satelliteB) {
        return MathsHelper.getDistance(satelliteA.getHeight(), satelliteA.getPosition(), satelliteB.getHeight(), satelliteB.getPosition());
    }

    // Compatibility Check
    public boolean compatibilityCheck(Entity entityA, Entity entityB) {
        if (entityA instanceof Device && entityB instanceof Device) {
            return false;
        } else if ((entityA instanceof StandardSatellite && entityB instanceof DesktopDevice) || (entityB instanceof StandardSatellite && entityA instanceof DesktopDevice)) {
            return false;
        } else if ((entityA instanceof ElephantSatellite && entityB instanceof HandheldDevice) || (entityB instanceof ElephantSatellite && entityA instanceof HandheldDevice)) {
            return false;
        } else if ((entityA instanceof ElephantSatellite && entityB instanceof TeleportingSatellite) || (entityB instanceof ElephantSatellite && entityA instanceof TeleportingSatellite)) {
            return false;
        } else {
            return true;
        }
    }


}
