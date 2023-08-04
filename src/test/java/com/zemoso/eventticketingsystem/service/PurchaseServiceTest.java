package com.zemoso.eventticketingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.zemoso.eventticketingsystem.controller.request.PurchaseRequest;
import com.zemoso.eventticketingsystem.entities.*;
import com.zemoso.eventticketingsystem.exception.NotEnoughSeatsException;
import com.zemoso.eventticketingsystem.exception.TicketNotFoundException;
import com.zemoso.eventticketingsystem.repository.PurchaseRepository;
import com.zemoso.eventticketingsystem.repository.SeatRepository;
import com.zemoso.eventticketingsystem.repository.TicketRepository;
import com.zemoso.eventticketingsystem.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PurchaseServiceTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private SeatRepository seatRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private PurchaseService purchaseService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPurchaseTickets_SuccessfulPurchase() {
        int userId = 1;
        int eventId = 2;
        Event event1 = new Event(eventId, "Event Title", new Date(), "Event Description", new Venue());
        String ticketType = "General Admission";
        int ticketQuantity = 3;
        List<Integer> seatNumbers = List.of(1, 2, 3);

        User user = new User(userId, "John Doe", "john@example.com", "123456789");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Ticket ticket = new Ticket(1, event1, 30.5,  ticketType, 10);
        when(ticketRepository.findByEvent_Id(eventId)).thenReturn(List.of(ticket));

        List<Seat> availableSeats = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            availableSeats.add(new Seat(event1, i));
        }
        when(seatRepository.findByEvent_Id(eventId)).thenReturn(availableSeats);

        Purchase savedPurchase = new Purchase(user, ticket, new Timestamp(new Date().getTime()), ticketQuantity);
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(savedPurchase);

        PurchaseRequest purchaseRequest = new PurchaseRequest(eventId, userId, ticketQuantity, ticketType, seatNumbers);
        Purchase resultPurchase = purchaseService.purchaseTickets(purchaseRequest);

        assertNotNull(resultPurchase);
        assertEquals(savedPurchase.getPurchaseQuantity(), resultPurchase.getPurchaseQuantity());
//        assertEquals(savedPurchase.getPurchaseDate(), resultPurchase.getPurchaseDate());
        assertEquals(savedPurchase.getTicket(), resultPurchase.getTicket());
        assertEquals(savedPurchase.getUser(), resultPurchase.getUser());

        verify(purchaseRepository, times(1)).save(any(Purchase.class));
        verify(seatRepository, times(ticketQuantity)).save(any(Seat.class));
    }

    @Test
    void testPurchaseTickets_NotEnoughSeatsException() {
        int userId = 1;
        int eventId = 2;
        Event event1 = new Event(eventId, "Event Title", new Date(), "Event Description", new Venue());
        String ticketType = "General Admission";
        int ticketQuantity = 3;
        List<Integer> seatNumbers = List.of(1, 2, 3);

        User user = new User(userId, "John Doe", "john@example.com", "123456789");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Ticket ticket = new Ticket(1, event1, 30.5,  ticketType, 10);
        when(ticketRepository.findByEvent_Id(eventId)).thenReturn(List.of(ticket));

        List<Seat> availableSeats = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            availableSeats.add(new Seat(event1, i));
        }
        when(seatRepository.findByEvent_Id(eventId)).thenReturn(availableSeats);

        Purchase savedPurchase = new Purchase(user, ticket, new Timestamp(new Date().getTime()), ticketQuantity);
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(savedPurchase);

        PurchaseRequest purchaseRequest = new PurchaseRequest(eventId, userId, ticketQuantity, ticketType, seatNumbers);
        NotEnoughSeatsException exception = assertThrows(NotEnoughSeatsException.class, () -> purchaseService.purchaseTickets(purchaseRequest) );
       assertEquals("Not enough available seats for the requested quantity.", exception.getMessage());

    }

    @Test
    void testPurchaseTickets_TicketNotFoundException() {
        int userId = 1;
        int eventId = 2;
        Event event1 = new Event(eventId, "Event Title", new Date(), "Event Description", new Venue());
        String ticketType = "General Admission";
        int ticketQuantity = 3;
        List<Integer> seatNumbers = List.of(1, 2, 3);

        User user = new User(userId, "John Doe", "john@example.com", "123456789");
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        Ticket ticket = new Ticket(1, event1, 30.5,  ticketType, 10);
        when(ticketRepository.findByEvent_Id(eventId)).thenReturn(new ArrayList<>());

        List<Seat> availableSeats = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            availableSeats.add(new Seat(event1, i));
        }
        when(seatRepository.findByEvent_Id(eventId)).thenReturn(availableSeats);

        Purchase savedPurchase = new Purchase(user, ticket, new Timestamp(new Date().getTime()), ticketQuantity);
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(savedPurchase);

        PurchaseRequest purchaseRequest = new PurchaseRequest(eventId, userId, ticketQuantity, ticketType, seatNumbers);
        TicketNotFoundException exception = assertThrows(TicketNotFoundException.class, () -> purchaseService.purchaseTickets(purchaseRequest) );
        assertEquals("Ticket not found", exception.getMessage());

    }

}
