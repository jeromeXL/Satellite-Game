package unsw.blackout.Entity.File;

/**
 * Represents file information
 * Consists of file attributes
 */

public class File {
    private String fileName;
    private String data;
    private int fileSize;
    private boolean hasTransferCompleted;
    
    public File(String fileName, String data) {
        this.fileName = fileName;
        this.data = data;
        this.fileSize = data.length();
    }

    // Getters
    public String getFileName() {
        return fileName;
    }
    public String getData() {
        return data;
    }
    public int getFileSize() {
        return fileSize;
    }
    public boolean getHasTransferCompleted() {
        return hasTransferCompleted;
    }
    // Setters
    public void setFileName(String newFileName) {
        this.fileName = newFileName;
    }
    public void setData(String newData) {
        this.data = newData;
    }
    public void setFileSize(int newFileSize) {
        this.fileSize = newFileSize;
    }
    public void setHasTransferCompleted(boolean newHasTransferCompleted) {
        this.hasTransferCompleted = newHasTransferCompleted;
    }

    @Override
    public String toString() {
        return "File [data=" + data + ", fileSize=" + fileSize + ", filename=" + fileName
                + ", hasTransferCompleted=" + hasTransferCompleted + "]";
    }

}