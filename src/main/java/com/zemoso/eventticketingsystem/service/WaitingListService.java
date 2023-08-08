package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.controller.request.WaitingListRequest;
import com.zemoso.eventticketingsystem.repository.EventRepository;
import com.zemoso.eventticketingsystem.repository.UserRepository;
import com.zemoso.eventticketingsystem.repository.WaitingListRepository;
import com.zemoso.eventticketingsystem.entities.Event;
import com.zemoso.eventticketingsystem.entities.User;
import com.zemoso.eventticketingsystem.entities.WaitingList;
import com.zemoso.eventticketingsystem.exception.EventNotFoundException;
import com.zemoso.eventticketingsystem.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WaitingListService {

    private final WaitingListRepository waitingListRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public WaitingListService(WaitingListRepository waitingListRepository,
                              EventRepository eventRepository,
                              UserRepository userRepository) {
        this.waitingListRepository = waitingListRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public WaitingList joinWaitingList(WaitingListRequest waitingListRequest) {
        Event event = eventRepository.findById(waitingListRequest.getEventId())
                .orElseThrow(() -> new EventNotFoundException("Event not found with ID: " + waitingListRequest.getEventId()));

        User user = userRepository.findById(waitingListRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + waitingListRequest.getUserId()));

        WaitingList waitingListEntry = new WaitingList(event, user, new java.sql.Timestamp(new Date().getTime()));
        return waitingListRepository.save(waitingListEntry);
    }
}
