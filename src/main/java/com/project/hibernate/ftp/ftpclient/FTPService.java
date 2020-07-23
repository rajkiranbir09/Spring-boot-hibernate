package com.project.hibernate.ftp.ftpclient;




import com.project.hibernate.exception.FTPErrors;

import java.io.File;

public interface FTPService {
    // connect tp FTP
    void connectToFTP(String host, String user, String pass) throws FTPErrors;


    // upload file to FTP
    void uploadFileToFTP(File file, String ftpHostDir , String serverFilename) throws FTPErrors;

    // download file from FTP
    void downloadFileFromFTP(String ftpRelativePath, String copytoPath) throws FTPErrors;

    // disconnect FTP
    void disconnectFTP() throws FTPErrors;

}