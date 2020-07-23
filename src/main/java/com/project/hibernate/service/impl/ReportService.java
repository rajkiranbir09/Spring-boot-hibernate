package com.project.hibernate.service.impl;


import com.project.hibernate.dao.impl.ReportDAO;
import com.project.hibernate.entity.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class ReportService {

    @Autowired
    private ReportDAO reportDAO;

    // GET PERFORMERS
    public List<String> getPerformers() {
        List<String> performers = new ArrayList<>();
        performers.add("All Performers");
        performers.addAll(reportDAO.getPerformers());
        return performers;
    }

    public List<String> getTimeIntervals() {
        String[] options = {
                "Last Qtr",
                "Last Month",
                "Last Calendar Year",
                "Current Year to Date",
                "Current Qtr to Date",
                "Current Month to Date"};
        return Arrays.asList(options);
    }

    public List<Report> getReport(String startDateString, String endDateString, String performer) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d,yyyy", Locale.ENGLISH);

        List<Report> reportList;
        Date startDate;
        Date endDate;

        if (startDateString.length() > 0) {
            startDate = simpleDateFormat.parse(startDateString);
        } else {
            startDate = new Date(0);
        }
        if (endDateString.length() > 0) {
            endDate = simpleDateFormat.parse(endDateString);
        } else {
            endDate = new Date();
        }
        if (performer.equals("All Performers")) {
            reportList = reportDAO.getAllTasks(startDate, endDate);
        } else {
            reportList = reportDAO.getAllTasks(performer, startDate, endDate);
        }
        return reportList;
    }
}