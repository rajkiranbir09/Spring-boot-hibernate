package com.project.hibernate.config.batch;


import javax.sql.DataSource;

import com.project.hibernate.batch.CategoryItemProcessor;
import com.project.hibernate.batch.JobCompletionNotificationListener;
import com.project.hibernate.pojos.Category;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
//
//@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {

//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    @Qualifier("dataSource")
//    public DataSource dataSource;
//
//    // tag::readerwriterprocessor[]
//    @Bean
//    public FlatFileItemReader<Category> reader() {
//        FlatFileItemReader<Category> reader = new FlatFileItemReader<Category>();
//        reader.setResource(new ClassPathResource("sample-data.csv"));
//        reader.setLineMapper(new DefaultLineMapper<Category>() {{
//            setLineTokenizer(new DelimitedLineTokenizer() {{
//                setNames(new String[] { "name", "description" });
//            }});
//            setFieldSetMapper(new BeanWrapperFieldSetMapper<Category>() {{
//                setTargetType(Category.class);
//            }});
//        }});
//        return reader;
//    }
//
//    @Bean
//    public CategoryItemProcessor processor() {
//        return new CategoryItemProcessor();
//    }
//
//    @Bean
//    public JdbcBatchItemWriter<Category> writer() {
//        JdbcBatchItemWriter<Category> writer = new JdbcBatchItemWriter<Category>();
//        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Category>());
//        writer.setSql("INSERT INTO category (name, description) VALUES (:name, :description)");
//        writer.setDataSource(dataSource);
//        return writer;
//    }
//    // end::readerwriterprocessor[]
//
//    // tag::jobstep[]
//    @Bean
//    public Job importUserJob(JobCompletionNotificationListener listener) {
//        return jobBuilderFactory.get("importUserJob")
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1())
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1() {
//        return stepBuilderFactory.get("step1")
//                .<Category, Category> chunk(10)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer())
//                .build();
//    }
//    // end::jobstep[]
}