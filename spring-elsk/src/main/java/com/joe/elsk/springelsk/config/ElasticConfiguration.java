package com.joe.elsk.springelsk.config;


import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.joe.elsk.springelsk.repositories")
public class ElasticConfiguration {

    @Bean
    NodeBuilder nodeBuilder(){
        return new NodeBuilder();
    }

    @Bean
    ElasticsearchOperations elasticsearchOperations() throws IOException {
        /*File tempDir = File.createTempFile(
                "elastic",
                Long.toString(System.nanoTime()),
                new File("F:\\learning\\temp-elastic\\")
        );*/

        File tempDir = new File("F:\\learning\\temp-elastic\\elastic"+Long.toString(System.nanoTime())+"\\");
        tempDir.mkdir();

        Settings.Builder elasticSearchSettings = Settings.builder()
                .put("http.enabled", "true")
                .put("index.number_of_shards", "1")
                .put("path.data", new File(tempDir, "data").getAbsolutePath())
                .put("path.logs", new File(tempDir, "logs").getAbsolutePath())
                .put("path.work", new File(tempDir, "work").getAbsolutePath())
                .put("path.home", Paths.get(tempDir.getAbsolutePath()));


        return new ElasticsearchTemplate(nodeBuilder()
                .local(true)
                .settings(elasticSearchSettings.build())
                .node()
                .client()
        );

    }
}
