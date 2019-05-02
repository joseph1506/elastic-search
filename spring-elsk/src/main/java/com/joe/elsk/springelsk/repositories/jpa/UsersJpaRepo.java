package com.joe.elsk.springelsk.repositories.jpa;

import com.joe.elsk.springelsk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJpaRepo extends JpaRepository<User,Long> {

}
