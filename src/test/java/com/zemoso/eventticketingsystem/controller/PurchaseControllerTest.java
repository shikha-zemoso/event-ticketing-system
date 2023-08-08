package com.zemoso.eventticketingsystem.controller;

import com.zemoso.eventticketingsystem.controller.request.PurchaseRequest;
import com.zemoso.eventticketingsystem.entities.Purchase;
import com.zemoso.eventticketingsystem.entities.Ticket;
import com.zemoso.eventticketingsystem.entities.User;
import com.zemoso.eventticketingsystem.service.PurchaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

class PurchaseControllerTest {

    @Mock
    private PurchaseService purchaseService;
    @InjectMocks
    private PurchaseController purchaseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testPurchaseTickets() {
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 101, 2, "Regular", null);
        Purchase mockPurchase = new Purchase(new User(), new Ticket(), new Date(), 1);
        when(purchaseService.purchaseTickets(purchaseRequest)).thenReturn(mockPurchase);

        Purchase result = purchaseController.purchaseTickets(purchaseRequest);

        assertEquals(mockPurchase.getPurchaseQuantity(), result.getPurchaseQuantity());
    }

}
