package com.project.hibernate.config.elasticsearch;

import com.sun.deploy.util.SessionState;
//import javafx.scene.NodeBuilder;
//import org.elasticsearch.node.
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.Resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

//@Configuration
//@EnableElasticsearchRepositories(basePackages = "com.baeldung.spring.data.es.repository")
//@ComponentScan(basePackages = { "com.baeldung.spring.data.es.service" })
public class ElasticSearchConfiguration {
//
//    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/2.3.2}")
//    private String elasticsearchHome;
//
//    private static Logger logger = LoggerFactory.getLogger(Config.class);
//
//    @Bean
//    public Client client() {
//        try {
//            final Path tmpDir = Files.createTempDirectory(Paths.get(System.getProperty("java.io.tmpdir")), "elasticsearch_data");
//            logger.debug(tmpDir.toAbsolutePath().toString());
//
//            // @formatter:off
//
////            final Settings.Builder elasticsearchSettings =
////                    Settings.settingsBuilder().put("http.enabled", "false")
////                            .put("path.data", tmpDir.toAbsolutePath().toString())
////                            .put("path.home", elasticsearchHome);
////
////            return new NodeBuilder()
////                    .local(true)
////                    .settings(elasticsearchSettings)
////                    .node()
////                    .client();
//
//            // @formatter:on
//        } catch (final IOException ioex) {
//            logger.error("Cannot create temp dir", ioex);
//            throw new RuntimeException();
//        }
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchTemplate(client());
//    }
}