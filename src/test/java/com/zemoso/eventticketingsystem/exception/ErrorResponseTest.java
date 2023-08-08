package com.zemoso.eventticketingsystem.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {
    @Test
    void testErrorResponseConstructor() {
        // Arrange
        int status = 404;
        String message = "Not Found";

        // Act
        ErrorResponse errorResponse = new ErrorResponse(status, message);

        // Assert
        assertEquals(status, errorResponse.getStatus());
        assertEquals(message, errorResponse.getMessage());
    }

    @Test
    void testGetStatus() {
        // Arrange
        int status = 500;
        String message = "Internal Server Error";
        ErrorResponse errorResponse = new ErrorResponse(status, message);

        // Act and Assert
        assertEquals(status, errorResponse.getStatus());
    }

    @Test
    void testGetMessage() {
        // Arrange
        int status = 400;
        String message = "Bad Request";
        ErrorResponse errorResponse = new ErrorResponse(status, message);

        // Act and Assert
        assertEquals(message, errorResponse.getMessage());
    }

}