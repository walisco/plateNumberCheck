package com.adegboye.e2e.models;

public class FileDetails {

    private String fileName;
    private String fileMimeType;
    private long fileSize;
    private String fileExtension;

    public FileDetails() {

    }

    public FileDetails(String fileName, String fileMimeType, long fileSize, String fileExtension) {
        this.fileName = fileName;
        this.fileMimeType = fileMimeType;
        this.fileSize = fileSize;
        this.fileExtension = fileExtension;
    }

    public String getFileMimeType() {
        return fileMimeType;
    }

    public void setFileMimeType(String fileMimeType) {
        this.fileMimeType = fileMimeType;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "FileDetails {" +
                "name=" + fileName +
                ", mimeType=" + fileMimeType +
                ", size=" + fileSize +
                ", extension=" + fileExtension +"}";
    }
}
