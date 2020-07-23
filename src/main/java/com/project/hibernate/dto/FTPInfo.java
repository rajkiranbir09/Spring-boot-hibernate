package com.project.hibernate.dto;

import lombok.Data;

@Data
public class FTPInfo {
    private String host;
    private int port;
    private String homeDir;
    private int maxDownloadRate; // KB
    private int maxUploadRate; // KB
    private float usedSpace; // G
    private float totalSpace; // G

}
