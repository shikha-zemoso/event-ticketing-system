package com.zemoso.eventticketingsystem.repository;

import com.zemoso.eventticketingsystem.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

    List<Seat> findByEvent_Id(int eventId);

    // Add other custom queries as needed
}

