package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.repository.SeatRepository;
import com.zemoso.eventticketingsystem.entities.Seat;
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

    public List<Seat> getAvailableSeats(int eventId) {
        return seatRepository.findByEvent_Id(eventId);
    }
}
