package com.zemoso.eventticketingsystem.controller;

import com.zemoso.eventticketingsystem.controller.request.PurchaseRequest;
import com.zemoso.eventticketingsystem.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.zemoso.eventticketingsystem.entities.Purchase;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // Endpoint to purchase tickets
    @PostMapping("/purchases")
    public Purchase purchaseTickets(@RequestBody PurchaseRequest purchaseRequest) {
        return purchaseService.purchaseTickets(purchaseRequest);
    }
}
