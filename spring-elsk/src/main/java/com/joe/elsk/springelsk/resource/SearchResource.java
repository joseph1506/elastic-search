package com.joe.elsk.springelsk.resource;

import com.joe.elsk.springelsk.model.User;
import com.joe.elsk.springelsk.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class SearchResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/name/{text}")
    public List<User> searchByName(@PathVariable("text") String text){
        return usersRepository.findByName(text);
    }

    @GetMapping(value = "/salary/{text}")
    public List<User> searchBySalary(@PathVariable("text") Long text){
        return usersRepository.findBySalary(text);
    }

    @GetMapping(value = "/all")
    public List<User> fetchAll(){
        List<User> retList = new ArrayList<>();
        Iterable<User> users= usersRepository.findAll();
        users.forEach(retList::add);
        return retList;
    }

}
