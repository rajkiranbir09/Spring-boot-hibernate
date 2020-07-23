package com.project.hibernate.batch;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.project.hibernate.pojos.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

//@Component
//@Slf4j
public class JobCompletionNotificationListener {

//    private final JdbcTemplate jdbcTemplate;
//
//    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//
//        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {


//            List<Category> results = jdbcTemplate
//                    .query("SELECT name, description FROM category", new RowMapper<Category>() {
//                        @Override
//                        public Category mapRow(ResultSet rs, int row) throws SQLException {
//                            return new Category(rs.getString(1), rs.getString(2));
//                        }
//                    });

//            for (Category person : results) {
//                log.info("Found <" + person + "> in the database.");
//            }

//        }
//    }
}