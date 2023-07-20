package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.repository.VenueRepository;
import com.zemoso.eventticketingsystem.entities.Venue;
import com.zemoso.eventticketingsystem.exception.VenueNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    private final VenueRepository venueRepository;

    @Autowired
    public VenueService(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    public Venue getVenueById(int venueId) {
        return venueRepository.findById(venueId)
                .orElseThrow(() -> new VenueNotFoundException("Venue not found with ID: " + venueId));
    }
}
