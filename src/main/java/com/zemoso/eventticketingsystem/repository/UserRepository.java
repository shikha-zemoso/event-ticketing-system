package com.zemoso.eventticketingsystem.repository;

import com.zemoso.eventticketingsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Add custom queries as needed
}

