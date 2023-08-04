package com.zemoso.eventticketingsystem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import com.zemoso.eventticketingsystem.entities.Event;
import com.zemoso.eventticketingsystem.entities.Venue;
import com.zemoso.eventticketingsystem.exception.EventNotFoundException;
import com.zemoso.eventticketingsystem.repository.EventRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEventById_EventFound() {
        int eventId = 1;
        Event expectedEvent = new Event(eventId, "Event Title", new Date(), "Event Description", new Venue());
        when(eventRepository.findById(eventId)).thenReturn(Optional.of(expectedEvent));

        Event actualEvent = eventService.getEventById(eventId);

        assertNotNull(actualEvent);
        assertEquals(expectedEvent.getId(), actualEvent.getId());
        assertEquals(expectedEvent.getEventName(), actualEvent.getEventName());
        assertEquals(expectedEvent.getEventDescription(), actualEvent.getEventDescription());
        assertEquals(expectedEvent.getVenue(), actualEvent.getVenue());

        verify(eventRepository, times(1)).findById(eventId);
    }

    @Test
    void testGetEventById_EventNotFound() {
        int eventId = 999;
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        assertThrows(EventNotFoundException.class, () -> eventService.getEventById(eventId));

        verify(eventRepository, times(1)).findById(eventId);
    }
    @Test
    void testGetEventById_EventNotFoundExceptionMessage() {
        int eventId = 999;
        String expectedMessage = "Event not found with ID: " + eventId;
        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        EventNotFoundException exception = assertThrows(EventNotFoundException.class, () -> eventService.getEventById(eventId));

        assertEquals(expectedMessage, exception.getMessage());
        verify(eventRepository, times(1)).findById(eventId);
    }

    @Test
    void testGetEventById_EventNotFoundExceptionWithCause() {
        int eventId = 999;
        String expectedMessage = "Event not found with ID: " + eventId;
        Throwable expectedCause = new IllegalArgumentException("Invalid event ID");

        when(eventRepository.findById(eventId)).thenReturn(Optional.empty());

        EventNotFoundException exception = assertThrows(EventNotFoundException.class, () -> {
            try {
                eventService.getEventById(eventId);
            } catch (EventNotFoundException ex) {
                throw new EventNotFoundException(expectedMessage, expectedCause);
            }
        });

        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(expectedCause, exception.getCause());
        verify(eventRepository, times(1)).findById(eventId);
    }

}
