package unsw.blackout.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import unsw.blackout.Entity.File.File;
import unsw.utils.Angle;

import unsw.response.models.EntityInfoResponse;
import unsw.response.models.FileInfoResponse;

/**
 * Represents entity information.
 * Consists of entity attributes
 * Contains hashmap of files with file name as key
 */

public class Entity {
    // Attributes
    private String id;
    private Angle position; //positionRadians
    private double height;
    private String type;
    private HashMap<String, File> files = new HashMap<>();
    private int range;

    // Constructors
    public Entity(String id, Angle position, String type){
        this.id = id;
        this.position = position;
        this.type = type;
    }

    // Getters
    public String getEntityId() {
        return id;
    }
    public Angle getPosition() {
        return position;
    }
    public double getHeight(){
        return height;
    }
    public String getType() {
        return type;
    }
    public HashMap<String, File> getFiles() {
        return files;
    }
    public int getRange() {
        return range;
    }

    // Setters
    public void setEntityID(String id) {
        this.id = id;
    }
    public void setPosition(Angle position) {
        this.position = position;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void addFile(File file) {
        this.files.put(file.getFileName(), file);
    }
    public void setRange(int range) {
        this.range = range;
    }



}
