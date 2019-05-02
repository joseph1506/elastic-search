package com.joe.elsk.springelsk.builder;

import com.joe.elsk.springelsk.model.User;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchQueryBuilder {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    public List<User> searchUsers(String text) {


        QueryBuilder query = QueryBuilders.boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(text)
                        .lenient(true)
                        .field("name")
                        .field("teamName")

                )
                .should(
                        QueryBuilders.queryStringQuery("*"+text+"*")
                                .lenient(true)
                                .field("name")
                                .field("teamName")
                );

        NativeSearchQuery queryNative = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();
        List<User> users = elasticsearchTemplate.queryForList(queryNative,User.class);
        return users;
    }
}
