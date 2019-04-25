package com.joe.elsk.springelsk.load;

import com.joe.elsk.springelsk.model.User;
import com.joe.elsk.springelsk.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations elasticsearchOperations;

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){
        elasticsearchOperations.putMapping(User.class);
        usersRepository.save(getUsersData());
        System.out.println("Loading completed");
    }

    private List<User> getUsersData() {
        List<User> users = new ArrayList<>();
        for(int i =1 ;i<2000;i++){
            User user = new User("Name:"+i, (long) i,"Team::"+i, (long) (+1000+i));
            users.add(user);
        }
        return users;
    }


}
