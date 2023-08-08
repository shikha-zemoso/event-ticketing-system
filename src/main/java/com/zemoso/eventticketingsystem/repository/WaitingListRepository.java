package com.zemoso.eventticketingsystem.repository;

import com.zemoso.eventticketingsystem.entities.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaitingListRepository extends JpaRepository<WaitingList, Integer> {

    List<WaitingList> findByEvent_Id(int eventId);

    List<WaitingList> findByUser_Id(int userId);
}
