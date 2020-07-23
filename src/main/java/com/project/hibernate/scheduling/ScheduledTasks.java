package com.project.hibernate.scheduling;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {


//    private MySQLBackUpScript mySQLBackUpScript;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");


    private static final SimpleDateFormat dateFormat1 = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss");
//
//    @Scheduled(fixedRate = 5000)
////    @Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]")
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//
//    }
//
//
//    // fire at 12 pm everyday
//    @Scheduled(cron = "0 0 12 * * ?")
//    public void report12pmeveryday(){
//        log.info("12 pm everyday The time is now {}", dateFormat.format(new Date()));
//    }
//
//
//    @Scheduled(fixedRate = 10000)
//    public void performTask() {
//
//        System.out.println("Regular task performed at "
//                + dateFormat.format(new Date()));
//
//    }
//
//    @Scheduled(initialDelay = 1000, fixedRate = 10000)
//    public void performDelayedTask() {
//
//        System.out.println("Delayed Regular task performed at "
//                + dateFormat.format(new Date()));
//
//    }
//
//    @Scheduled(cron = "*/5 * * * * *")
//    public void performTaskUsingCron() {
//
//        System.out.println("Regular task performed using Cron at "
//                + dateFormat.format(new Date()));
//
//    }
//
//    // send mail to customer
//    private static final SimpleDateFormat dateFormat =
//            new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
//
//    @Scheduled(fixedRate = 10000)
//    public void sendMailToCustomers() {
//
//        System.out.println("sendMailToCustomers Job ran at "
//                + dateFormat.format(new Date()));
//
//    }

}