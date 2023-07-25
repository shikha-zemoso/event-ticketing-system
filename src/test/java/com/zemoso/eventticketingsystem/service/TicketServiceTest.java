package com.zemoso.eventticketingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zemoso.eventticketingsystem.entities.Event;
import com.zemoso.eventticketingsystem.entities.Ticket;
import com.zemoso.eventticketingsystem.entities.Venue;
import com.zemoso.eventticketingsystem.repository.TicketRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetTicketsByEventId_ShouldReturnListOfTickets() {
        int eventId = 1;
        Event event = new Event(eventId, "Event Title", new Date(), "Event Description", new Venue());
        List<Ticket> mockTickets = new ArrayList<>();
        mockTickets.add(new Ticket(1, event, 30.5, "Ticket 1", 100));
        mockTickets.add(new Ticket(2, event, 50.0 ,"Ticket 2", 50));
        when(ticketRepository.findByEvent_Id(eventId)).thenReturn(mockTickets);

        List<Ticket> result = ticketService.getTicketsByEventId(eventId);

        assertEquals(mockTickets, result);
        verify(ticketRepository, times(1)).findByEvent_Id(eventId);
    }
}
