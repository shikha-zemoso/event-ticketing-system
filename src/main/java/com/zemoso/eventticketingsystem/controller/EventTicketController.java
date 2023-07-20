package com.zemoso.eventticketingsystem.controller;
import com.zemoso.eventticketingsystem.controller.request.PurchaseRequest;
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
    private UserService userService;

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private WaitingListService waitingListService;

    // Endpoint to get event details by event_id
    @GetMapping("/events/{event_id}")
    public Event getEventDetails(@PathVariable int event_id) {
        return eventService.getEventById(event_id);
    }

    // Endpoint to get venue details by venue_id
    @GetMapping("/venues/{venue_id}")
    public Venue getVenueDetails(@PathVariable int venue_id) {
        return venueService.getVenueById(venue_id);
    }

    // Endpoint to get ticket availability for an event
    @GetMapping("/tickets/{event_id}")
    public List<Ticket> getTicketAvailability(@PathVariable int event_id) {
        return ticketService.getTicketsByEventId(event_id);
    }

    // Endpoint to purchase tickets
    @PostMapping("/purchases")
    public Purchase purchaseTickets(@RequestBody PurchaseRequest purchaseRequest) {
        return purchaseService.purchaseTickets(purchaseRequest);
    }

    // Endpoint to get user purchases
    @GetMapping("/users/{user_id}/purchases")
    public List<Purchase> getUserPurchases(@PathVariable int user_id) {
        return purchaseService.getPurchasesByUserId(user_id);
    }

    // Endpoint to get available seats for an event
    @GetMapping("/seats/{event_id}")
    public List<Seat> getAvailableSeats(@PathVariable int event_id) {
        return seatService.getAvailableSeats(event_id);
    }

    // Endpoint to join waiting list for an event
    @PostMapping("/waiting-list")
    public WaitingList joinWaitingList(@RequestBody WaitingListRequest waitingListRequest) {
        return waitingListService.joinWaitingList(waitingListRequest);
    }

}
