package com.zemoso.eventticketingsystem.repository;

import com.zemoso.eventticketingsystem.entities.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    List<Purchase> findByUser_Id(int userId);

    // Add other custom queries as needed
}

