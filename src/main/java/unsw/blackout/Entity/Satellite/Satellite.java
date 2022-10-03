package unsw.blackout.Entity.Satellite;

import unsw.blackout.Entity.Entity;
import unsw.utils.Angle;

public class Satellite extends Entity {
    // Attributes
    private int sendSpeed;// Sending and receiving speed in bytes per minute
    private int receiveSpeed;
    private int linearSpeed;
    private int fileLimit;
    private int byteLimit;

    // Constructor
    public Satellite(String deviceId, String type, Angle position, double height){
        super(deviceId, position, type);
        this.setHeight(height);
    }

    // Getters 
    public int getSendSpeed() {
        return sendSpeed;
    }
    public int getReceiveSpeed() {
        return receiveSpeed;
    }
    public int getLinearSpeed() {
        return linearSpeed;
    }
    public int getFileLimit() {
        return fileLimit;
    }
    public int getByteLimit() {
        return byteLimit;
    }

    // Setters
    public void setSendSpeed(int newSendSpeed) {
        this.sendSpeed = newSendSpeed;
    }
    public void setReceiveSpeed(int newReceiveSpeed) {
        this.receiveSpeed = newReceiveSpeed;
    }
    public void setLinearSpeed(int newLinearSpeed) {
        this.linearSpeed = newLinearSpeed;
    }
    public void setFileLimit(int newFileLimit) {
        this.fileLimit = newFileLimit;
    }
    public void setByteLimit(int newByteLimit) {
        this.byteLimit = newByteLimit;
    }

}
