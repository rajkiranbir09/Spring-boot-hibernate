package com.project.hibernate.controller;


import com.project.hibernate.exception.FTPErrors;
import com.project.hibernate.ftp.ftpclient.FTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;

@CrossOrigin
@RestController
@RequestMapping( value = "/v1/ftp/upload")
public class FTPController {

    @Autowired
    private FTPService ftpService;

    @GetMapping
    public void uploadExample(){
        try {

            ftpService.connectToFTP("192.168.1.102","admin","password");
            ftpService.uploadFileToFTP(new File("/home/home/img.png"),"uploads/","foto.png");
            ftpService.downloadFileFromFTP("uploads/foto.png","/home/kaka.png");

        } catch (FTPErrors ftpErrors) {
            System.out.println(ftpErrors.getMessage());
        }
    }



}