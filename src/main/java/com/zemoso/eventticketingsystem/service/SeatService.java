package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.repository.SeatRepository;
import com.zemoso.eventticketingsystem.entities.Seat;
import com.zemoso.eventticketingsystem.exception.SeatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat getSeatById(int seatId) {
        return seatRepository.findById(seatId)
                .orElseThrow(() -> new SeatNotFoundException("Seat not found with ID: " + seatId));
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat updateSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public void deleteSeat(int seatId) {
        Seat seat = getSeatById(seatId);
        seatRepository.delete(seat);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public List<Seat> getSeatsByEventId(int eventId) {
        return seatRepository.findByEvent_Id(eventId);
    }

    public List<Seat> getAvailableSeats(int eventId) {
        return seatRepository.findByEvent_Id(eventId);
    }
}
