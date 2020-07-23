package com.project.hibernate.ftp;

import org.apache.commons.net.ftp.FTPClient;

import java.io.IOException;
import java.net.SocketException;

public class FTPConnect {
    FTPClient ftpClient = new FTPClient();

    public void connectFTP(){
        try {
            // pass directory path on server to connect
            ftpClient.connect("hostname.com");

            // pass username and password, returned true if authentication is
            // successful
            boolean login = ftpClient.login("admin", "password");

            if (login) {
                System.out.println("Connection established...");
                System.out.println("Status: "+ftpClient.getStatus());
                // logout the user, returned true if logout successfully
                boolean logout = ftpClient.logout();
                if (logout) {
                    System.out.println("Connection close...");
                }
            } else {
                System.out.println("Connection fail...");
            }

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

