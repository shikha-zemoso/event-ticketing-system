package com.zemoso.eventticketingsystem.controller;

import com.zemoso.eventticketingsystem.controller.request.WaitingListRequest;
import com.zemoso.eventticketingsystem.entities.*;
import com.zemoso.eventticketingsystem.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventTicketController {

    @Autowired
    private EventService eventService;

    @Autowired
    private VenueService venueService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private WaitingListService waitingListService;

    // Endpoint to get event details by eventId
    @GetMapping("/events/{eventId}")
    public Event getEventDetails(@PathVariable int eventId) {
        return eventService.getEventById(eventId);
    }

    // Endpoint to get venue details by venueId
    @GetMapping("/venues/{venueId}")
    public Venue getVenueDetails(@PathVariable int venueId) {
        return venueService.getVenueById(venueId);
    }

    // Endpoint to get ticket availability for an event
    @GetMapping("/tickets/{eventId}")
    public List<Ticket> getTicketAvailability(@PathVariable int eventId) {
        return ticketService.getTicketsByEventId(eventId);
    }

    // Endpoint to get available seats for an event
    @GetMapping("/seats/{eventId}")
    public List<Seat> getAvailableSeats(@PathVariable int eventId) {
        return seatService.getAvailableSeats(eventId);
    }

    // Endpoint to join waiting list for an event
    @PostMapping("/waiting-list")
    public WaitingList joinWaitingList(@RequestBody WaitingListRequest waitingListRequest) {
        return waitingListService.joinWaitingList(waitingListRequest);
    }

}
