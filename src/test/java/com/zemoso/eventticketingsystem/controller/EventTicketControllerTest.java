package com.zemoso.eventticketingsystem.controller;

import com.zemoso.eventticketingsystem.controller.request.PurchaseRequest;
import com.zemoso.eventticketingsystem.controller.request.WaitingListRequest;
import com.zemoso.eventticketingsystem.entities.*;
import com.zemoso.eventticketingsystem.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EventTicketControllerTest {

    @Mock
    private EventService eventService;

    @Mock
    private VenueService venueService;

    @Mock
    private TicketService ticketService;

    @Mock
    private PurchaseService purchaseService;

    @Mock
    private SeatService seatService;

    @Mock
    private WaitingListService waitingListService;

    @InjectMocks
    private EventTicketController eventTicketController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetEventDetails() {
        int eventId = 1;
        Event mockEvent = new Event(eventId, "Event A", new Date(), "Description A", new Venue());
        when(eventService.getEventById(eventId)).thenReturn(mockEvent);

        Event result = eventTicketController.getEventDetails(eventId);

        assertEquals(mockEvent.getEventName(), result.getEventName());
    }

    @Test
    void testGetVenueDetails() {
        int venueId = 101;
        Venue mockVenue = new Venue(venueId, "Venue X", "Location X");
        when(venueService.getVenueById(venueId)).thenReturn(mockVenue);

        Venue result = eventTicketController.getVenueDetails(venueId);

        assertEquals(mockVenue.getVenueName(), result.getVenueName());
    }

    @Test
    void testGetTicketAvailability() {
        int eventId = 1;
        List<Ticket> mockTickets = new ArrayList<>();
        mockTickets.add(new Ticket(1, new Event(), 50.00, "Regular", 100));
        when(ticketService.getTicketsByEventId(eventId)).thenReturn(mockTickets);

        List<Ticket> result = eventTicketController.getTicketAvailability(eventId);

        assertEquals(mockTickets.size(), result.size());
    }

//    @Test
//    void testPurchaseTickets() {
//        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 101, 2, "Regular", null);
//        Purchase mockPurchase = new Purchase(new User(), new Ticket(), new Date(), 1);
//        when(purchaseService.purchaseTickets(purchaseRequest)).thenReturn(mockPurchase);
//
//        Purchase result = PurchaseController.purchaseTickets(purchaseRequest);
//
//        assertEquals(mockPurchase.getPurchaseQuantity(), result.getPurchaseQuantity());
//    }

    @Test
    void testGetAvailableSeats() {
        int eventId = 1;
        List<Seat> mockSeats = new ArrayList<>();
        Event event = new Event(eventId, "Event A", new Date(), "Description A", new Venue());
        mockSeats.add(new Seat(event, 1));
        when(seatService.getAvailableSeats(eventId)).thenReturn(mockSeats);

        List<Seat> result = eventTicketController.getAvailableSeats(eventId);

        assertEquals(mockSeats.size(), result.size());
    }

    @Test
    void testJoinWaitingList() {
        WaitingListRequest waitingListRequest = new WaitingListRequest(101, 123);
        WaitingList mockWaitingList = new WaitingList(new Event(), new User(), new Date());
        when(waitingListService.joinWaitingList(waitingListRequest)).thenReturn(mockWaitingList);

        WaitingList result = eventTicketController.joinWaitingList(waitingListRequest);

        assertEquals(mockWaitingList.getUser().getUserEmail(), result.getUser().getUserEmail());
    }
}
