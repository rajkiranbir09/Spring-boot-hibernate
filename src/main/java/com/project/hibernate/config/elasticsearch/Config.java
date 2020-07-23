package com.project.hibernate.config.elasticsearch;

import javafx.scene.NodeBuilder;
import org.elasticsearch.common.settings.Settings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.project.hibernate.repository")
//@ComponentScan(basePackages = {"com.project.hibernate.service"})@Configuration
//@EnableElasticsearchRepositories(basePackages = "org/springframework/data/elasticsearch/repositories")

public class Config {

//    @Bean
//    public NodeBuilder nodeBuilder() {
//        return new NodeBuilder();
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        Settings.Builder elasticsearchSettings =
//                Settings.settingsBuilder()
//                        .put("http.enabled", "false") // 1
//                        .put("path.data", tmpDir.toAbsolutePath().toString()) // 2
//                        .put("path.home", "PATH_TO_YOUR_ELASTICSEARCH_DIRECTORY"); // 3
//
//
//
//        return new ElasticsearchTemplate(nodeBuilder()
//                .local(true)
//                .settings(elasticsearchSettings.build())
//                .node()
//                .client());
//    }



//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchTemplate(nodeBuilder().local(true).node().client());
//    }
}