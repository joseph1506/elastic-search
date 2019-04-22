package com.joe.elsk.springelsk.config;


import org.elasticsearch.node.NodeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.joe.elsk.springelsk.repositories")
public class ElasticConfiguration {

    /*@Bean
    NodeBuilder nodeBuilder(){

    }*/
}
