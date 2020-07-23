package com.project.hibernate.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class MySQLBackUpScript {

    private static final Logger log = LoggerFactory.getLogger(MySQLBackUpScript.class);
//    ExecuteShellComand obj = new ExecuteShellComand();

    String domainName = "google.com";

    //in mac oxs
    String command = "pwd";
    String mysqlbackupcommand = "sh /Users/hien/Desktop/sp/project/hibernate-springboot/scripts/mysql-backup.sh";

    String output = this.executeCommand(mysqlbackupcommand);



    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }


    @Scheduled(cron = "0 1 1 * * ?")
//    @Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]")
    public void reportCurrentTime() {
        log.info("The time is now {}"+output);


    }

}
