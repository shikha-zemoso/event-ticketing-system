package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.repository.TicketRepository;
import com.zemoso.eventticketingsystem.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getTicketsByEventId(int eventId) {
        // SELECT * from Ticket where event_id = "123"
        return ticketRepository.findByEvent_Id(eventId);
    }
}

