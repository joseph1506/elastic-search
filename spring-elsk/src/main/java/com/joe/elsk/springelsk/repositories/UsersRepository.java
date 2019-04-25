package com.joe.elsk.springelsk.repositories;

import com.joe.elsk.springelsk.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UsersRepository extends ElasticsearchRepository<User, Long> {
    List<User> findByName(String text);

    List<User> findBySalary(Long text);
}
