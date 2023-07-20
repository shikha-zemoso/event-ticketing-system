package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.repository.EventRepository;
import com.zemoso.eventticketingsystem.entities.Event;
import com.zemoso.eventticketingsystem.exception.EventNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    // Method to get event details by event_id
    public Event getEventById(int eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + eventId));
    }

}
