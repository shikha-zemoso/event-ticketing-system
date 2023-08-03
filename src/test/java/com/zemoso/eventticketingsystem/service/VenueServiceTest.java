package com.zemoso.eventticketingsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Optional;

import com.zemoso.eventticketingsystem.exception.VenueNotFoundException;
import com.zemoso.eventticketingsystem.repository.VenueRepository;
import com.zemoso.eventticketingsystem.entities.Venue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class VenueServiceTest {

    @Mock
    private VenueRepository venueRepository;

    @InjectMocks
    private VenueService venueService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetVenueById_ExistingVenueId_ShouldReturnVenue() {
        int venueId = 1;
        Venue mockVenue = new Venue(venueId, "Test Venue", "Venue Address");
        when(venueRepository.findById(venueId)).thenReturn(Optional.of(mockVenue));

        Venue result = venueService.getVenueById(venueId);

        assertEquals(mockVenue, result);
        verify(venueRepository, times(1)).findById(venueId);
    }

    @Test
    void testGetVenueById_NonExistingVenueId_ShouldThrowException() {
        int venueId = 999;
        when(venueRepository.findById(venueId)).thenReturn(Optional.empty());

        assertThrows(VenueNotFoundException.class, () -> venueService.getVenueById(venueId));
    }

    @Test
    void testGetVenueById_VenueNotFoundExceptionMessage() {
        int venueId = 999;
        String expectedMessage = "Venue not found with ID: " + venueId;
        when(venueRepository.findById(venueId)).thenReturn(Optional.empty());

        VenueNotFoundException exception = assertThrows(VenueNotFoundException.class, () -> venueService.getVenueById(venueId));

        assertEquals(expectedMessage, exception.getMessage());
        verify(venueRepository, times(1)).findById(venueId);
    }

    @Test
    void testGetVenueById_VenueNotFoundExceptionWithCause() {
        int venueId = 999;
        String expectedMessage = "Venue not found with ID: " + venueId;
        Throwable expectedCause = new IllegalArgumentException("Invalid venue ID");

        when(venueRepository.findById(venueId)).thenReturn(Optional.empty());

        VenueNotFoundException exception = assertThrows(VenueNotFoundException.class, () -> {
            try {
                venueService.getVenueById(venueId);
            } catch (VenueNotFoundException ex) {
                throw new VenueNotFoundException(expectedMessage, expectedCause);
            }
        });

        assertEquals(expectedMessage, exception.getMessage());
        assertEquals(expectedCause, exception.getCause());
        verify(venueRepository, times(1)).findById(venueId);
    }

}
