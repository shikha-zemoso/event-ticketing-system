package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.controller.request.PurchaseRequest;
import com.zemoso.eventticketingsystem.repository.EventRepository;
import com.zemoso.eventticketingsystem.repository.PurchaseRepository;
import com.zemoso.eventticketingsystem.repository.SeatRepository;
import com.zemoso.eventticketingsystem.repository.TicketRepository;
import com.zemoso.eventticketingsystem.repository.UserRepository;
import com.zemoso.eventticketingsystem.repository.WaitingListRepository;
import com.zemoso.eventticketingsystem.entities.Purchase;
import com.zemoso.eventticketingsystem.entities.Seat;
import com.zemoso.eventticketingsystem.entities.Ticket;
import com.zemoso.eventticketingsystem.entities.User;
import com.zemoso.eventticketingsystem.exception.NotEnoughSeatsException;
import com.zemoso.eventticketingsystem.exception.PurchaseNotFoundException;
import com.zemoso.eventticketingsystem.exception.TicketNotFoundException;
import com.zemoso.eventticketingsystem.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final TicketRepository ticketRepository;
    private final SeatRepository seatRepository;
    private final WaitingListRepository waitingListRepository;
    private final EventRepository eventRepository;

    private final UserRepository userRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository,
                           TicketRepository ticketRepository,
                           SeatRepository seatRepository,
                           WaitingListRepository waitingListRepository,
                           EventRepository eventRepository,
                           UserRepository userRepository) {
        this.purchaseRepository = purchaseRepository;
        this.ticketRepository = ticketRepository;
        this.seatRepository = seatRepository;
        this.waitingListRepository = waitingListRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public Purchase getPurchaseById(int purchaseId) {
        return purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new PurchaseNotFoundException("Purchase not found with ID: " + purchaseId));
    }

    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public Purchase updatePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    public void deletePurchase(int purchaseId) {
        Purchase purchase = getPurchaseById(purchaseId);
        purchaseRepository.delete(purchase);
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public List<Purchase> getPurchasesByUserId(int userId) {
        return purchaseRepository.findByUser_Id(userId);
    }

    public Purchase purchaseTickets(PurchaseRequest purchaseRequest) {
        // Check if there are enough available seats for the requested quantity
        List<Seat> availableSeats = seatRepository.findByEvent_Id(purchaseRequest.getEventId());
        if (availableSeats.size() < purchaseRequest.getTicketQuantity()) {
            throw new NotEnoughSeatsException("Not enough available seats for the requested quantity.");
        }

        User user = userRepository.findById(purchaseRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + purchaseRequest.getUserId()));

        Ticket ticket = ticketRepository.findByEvent_Id(purchaseRequest.getEventId()).stream()
                .filter(t -> t.getTicketType().equalsIgnoreCase(purchaseRequest.getTicketType()))
                .findFirst().orElseThrow(() -> new TicketNotFoundException("Ticket not found"));

        // Create a new purchase record
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Purchase purchase = new Purchase(user, ticket, timestamp, purchaseRequest.getTicketQuantity());
        createPurchase(purchase);

        // Create ticket records for the purchased seats and mark them as sold
        List<Seat> selectedSeats = availableSeats.subList(0, purchaseRequest.getTicketQuantity());
        for (int i = 0; i < purchaseRequest.getSeatNumbers().size(); i++) {
            selectedSeats.get(i).setSeatNumber(purchaseRequest.getSeatNumbers().get(i));
        }
        for (Seat seat : selectedSeats) {
            seat.setIsBooked(true);
            seatRepository.save(seat);
            ticket.setTicketQuantity(ticket.getTicketQuantity() - purchaseRequest.getTicketQuantity());
            ticketRepository.save(ticket);
        }

        return purchase;
    }
}
