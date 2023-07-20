package com.zemoso.eventticketingsystem.repository;

import com.zemoso.eventticketingsystem.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> findByEvent_Id(int eventId);

    // Add other custom queries as needed
}

