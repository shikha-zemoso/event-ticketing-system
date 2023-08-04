package com.zemoso.eventticketingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.zemoso.eventticketingsystem.exception.ErrorResponse;
import com.zemoso.eventticketingsystem.exception.EventNotFoundException;
import com.zemoso.eventticketingsystem.exception.GlobalExceptionHandler;
import com.zemoso.eventticketingsystem.exception.VenueNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler exceptionHandler;

    @Before
    public void setup() {
        exceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    public void testHandleNotFoundException() {
        Exception exception = new Exception("Some exception");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
        assertEquals("Some exception", response.getBody().getMessage());
    }

    @Test
    public void testHandleEventNotFoundException() {
        EventNotFoundException exception = new EventNotFoundException("Event not found");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
        assertEquals("Event not found", response.getBody().getMessage());
    }

    @Test
    public void testHandleVenueNotFoundException() {
        VenueNotFoundException exception = new VenueNotFoundException("Venue not found");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
        assertEquals("Venue not found", response.getBody().getMessage());
    }

}
