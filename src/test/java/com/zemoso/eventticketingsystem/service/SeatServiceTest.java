package com.zemoso.eventticketingsystem.service;
import com.zemoso.eventticketingsystem.entities.Event;
import com.zemoso.eventticketingsystem.entities.Seat;
import com.zemoso.eventticketingsystem.entities.Venue;
import com.zemoso.eventticketingsystem.exception.NotEnoughSeatsException;
import com.zemoso.eventticketingsystem.repository.SeatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class SeatServiceTest {

    @Mock
    private SeatRepository seatRepository;

    @InjectMocks
    private SeatService seatService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAvailableSeats() {
        int eventId = 1;
        Event mockEvent = new Event(eventId, "Event Title", new Date(), "Event Description", new Venue());
        List<Seat> mockSeats = new ArrayList<>();
        mockSeats.add(new Seat(1, mockEvent, 101, false));
        when(seatRepository.findByEvent_Id(eventId)).thenReturn(mockSeats);

        List<Seat> result = seatService.getAvailableSeats(eventId);

        assertEquals(1, result.size());
        assertEquals(101, result.get(0).getSeatNumber());
        assertEquals(false, result.get(0).getIsBooked());
        assertEquals(1, result.get(0).getId());
        assertEquals(mockEvent, result.get(0).getEvent());
    }

}
