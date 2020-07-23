package com.project.hibernate.helpers;

import com.project.hibernate.entity.Report;
import java.util.List;

/**
 * HTML helper class
 */
public class HtmlHelper {

    // GET OPTIONS
    public static String getOptions(List<String> options) {
        StringBuilder optionsBuilder = new StringBuilder();
        for (String option : options) {
            optionsBuilder.append(String.format("<option>%s</option>", option));
        }
        return optionsBuilder.toString();
    }

    // GET TABLE
    public static String getTable(List<Report> reportList) {
        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append(String.format("<tr><th>%s</th><th>%s</th><th>%s</th><th>%s</th></tr>",
                "Start Date",
                "End Date",
                "Performer",
                "Activity"));
        for (Report reportsEntity : reportList) {
            tableBuilder.append(String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>",
                    reportsEntity.getStartDate(),
                    reportsEntity.getEndDate(),
                    reportsEntity.getPerformer(),
                    reportsEntity.getActivity()));
        }
        return tableBuilder.toString();
    }
}