package com.zemoso.eventticketingsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.zemoso.eventticketingsystem.exception.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

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

    @Test
    public void testHandleTicketNotFoundException() {
        TicketNotFoundException exception = new TicketNotFoundException("Ticket not found");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
        assertEquals("Ticket not found", response.getBody().getMessage());
    }

    @Test
    public void testHandleNotEnoughSeatsException() {
        NotEnoughSeatsException exception = new NotEnoughSeatsException("Not enough seats found");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
        assertEquals("Not enough seats found", response.getBody().getMessage());
    }

    @Test
    public void testHandleUserNotFoundException() {
        UserNotFoundException exception = new UserNotFoundException("User not found");
        ResponseEntity<ErrorResponse> response = exceptionHandler.handleNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus());
        assertEquals("User not found", response.getBody().getMessage());
    }


    @Test
    public void testHandleIOException() {
        // Arrange
        String errorMessage = "IO error";
        IOException exception = new IOException(errorMessage);

        // Act
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleNotFoundException(exception);
        ErrorResponse errorResponse = responseEntity.getBody();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatus());
        assertEquals(errorMessage, errorResponse.getMessage());
    }

}
