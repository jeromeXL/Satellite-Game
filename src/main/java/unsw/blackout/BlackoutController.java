package unsw.blackout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import unsw.response.models.EntityInfoResponse;
import unsw.response.models.FileInfoResponse;
import unsw.utils.Angle;
import unsw.utils.MathsHelper;

import unsw.blackout.Entity.Entity;
import unsw.blackout.Entity.Device.*;
import unsw.blackout.Entity.Satellite.*;
import unsw.blackout.Entity.File.*;


public class BlackoutController {
    // Hashmap of Devices & Satellites with ID as key
    private HashMap<String, Device> Devices = new HashMap<String, Device>();
    private HashMap<String, Satellite> Satellites = new HashMap<String, Satellite>();


    public void createDevice(String deviceId, String type, Angle position) {
        // TODO: Task 1a)
        Device device = null;
        if (type.equals("HandheldDevice")) {
            device = new HandheldDevice(deviceId, type, position);
        } 
        else if (type.equals("LaptopDevice")) {
            device = new LaptopDevice(deviceId, type, position);
        } 
        else if (type.equals("DesktopDevice")) {
            device = new DesktopDevice(deviceId, type, position);
        }
        Devices.put(deviceId, device);
    }

    public void removeDevice(String deviceId) {
        // TODO: Task 1b)
        Devices.remove(deviceId);
    }

    public void createSatellite(String satelliteId, String type, double height, Angle position) {
        // TODO: Task 1c)
        Satellite satellite = null;
        if (type.equals("StandardSatellite")) {
            satellite = new StandardSatellite(satelliteId, type, position, height);
        } else if (type.equals("TeleportingSatellite")) {
            satellite = new TeleportingSatellite(satelliteId, type, position, height);
        } else if (type.equals("RelaySatellite")) {
            satellite = new RelaySatellite(satelliteId, type, position, height);
        }
        Satellites.put(satelliteId, satellite);
    }

    public void removeSatellite(String satelliteId) {
        // TODO: Task 1d)
        Satellites.remove(satelliteId);
    }

    public List<String> listDeviceIds() {
        // TODO: Task 1e)
        ArrayList<String> deviceIds = new ArrayList<String>();

        for (String deviceId : Devices.keySet()) {
            deviceIds.add(deviceId);
        }

        return deviceIds;
    }

    public List<String> listSatelliteIds() {
        // TODO: Task 1f)
        ArrayList<String> satelliteIds = new ArrayList<String>();

        for (String satelliteId : Satellites.keySet()) {
            satelliteIds.add(satelliteId);
        }

        return satelliteIds;
    }

    public void addFileToDevice(String deviceId, String filename, String content) {
        // TODO: Task 1g)
        Device targetDevice = Devices.get(deviceId);
        File incomingFile = new File(filename, content);
        targetDevice.addFile(incomingFile);
    }

    public EntityInfoResponse getInfo(String id) {
        // TODO: Task 1h)

        Entity infoEntity = null;
        Device infoDevice = Devices.get(id);
        Satellite infoSatellite = Satellites.get(id);

        Map<String, FileInfoResponse> insertFiles = new HashMap<>();

        if (infoDevice == null) {
            infoEntity = infoSatellite;
        } else if (infoSatellite == null) {
            infoEntity = infoDevice;
        } else { // Invalid id
            return null;
        }

        HashMap<String, File> extractFiles = infoEntity.getFiles();

        for (File file: extractFiles.values()) {
            FileInfoResponse fileInfo = new FileInfoResponse(file.getFileName(), file.getData(), file.getFileSize(), true);
            insertFiles.put(file.getFileName(), fileInfo);
        }

        EntityInfoResponse info = new EntityInfoResponse(id, infoEntity.getPosition(), infoEntity.getHeight(), infoEntity.getType(), insertFiles);
        
        return info;
    }

    public void simulate() {
        // TODO: Task 2a)
    }

    /**
     * Simulate for the specified number of minutes.
     * You shouldn't need to modify this function.
     */
    public void simulate(int numberOfMinutes) {
        for (int i = 0; i < numberOfMinutes; i++) {
            simulate();
        }
    }

    public List<String> communicableEntitiesInRange(String id) {
        // TODO: Task 2 b)
        return new ArrayList<>();
    }

    public void sendFile(String fileName, String fromId, String toId) throws FileTransferException {
        // TODO: Task 2 c)
    }

    public void createDevice(String deviceId, String type, Angle position, boolean isMoving) {
        createDevice(deviceId, type, position);
        // TODO: Task 3
    }

    public void createSlope(int startAngle, int endAngle, int gradient) {
        // TODO: Task 3
        // If you are not completing Task 3 you can leave this method blank :)
    }

}
