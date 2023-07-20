package com.zemoso.eventticketingsystem.repository;

import com.zemoso.eventticketingsystem.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
