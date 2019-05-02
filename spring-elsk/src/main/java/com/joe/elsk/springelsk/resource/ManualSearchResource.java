package com.joe.elsk.springelsk.resource;

import com.joe.elsk.springelsk.builder.SearchQueryBuilder;
import com.joe.elsk.springelsk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/manual/search")
public class ManualSearchResource {

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;

    @RequestMapping("/{text}")
    public List<User> searchUsers(@PathVariable("text") String text){
        return searchQueryBuilder.searchUsers(text);

    }

}
