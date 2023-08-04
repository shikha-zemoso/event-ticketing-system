package com.zemoso.eventticketingsystem.service;

import com.zemoso.eventticketingsystem.controller.request.WaitingListRequest;
import com.zemoso.eventticketingsystem.entities.Event;
import com.zemoso.eventticketingsystem.entities.User;
import com.zemoso.eventticketingsystem.entities.Venue;
import com.zemoso.eventticketingsystem.entities.WaitingList;
import com.zemoso.eventticketingsystem.exception.EventNotFoundException;
import com.zemoso.eventticketingsystem.exception.UserNotFoundException;
import com.zemoso.eventticketingsystem.repository.EventRepository;
import com.zemoso.eventticketingsystem.repository.UserRepository;
import com.zemoso.eventticketingsystem.repository.WaitingListRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Date;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class WaitingListServiceTest {

    @Mock
    private WaitingListRepository waitingListRepository;

    @Mock
    private EventRepository eventRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private WaitingListService waitingListService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testJoinWaitingList_ValidRequest() {
        int eventId = 1;
        int userId = 101;

        WaitingListRequest waitingListRequest = new WaitingListRequest(eventId, userId);

        Event mockEvent = new Event(eventId, "Event A", new Date(), "Description A", new Venue());
        User mockUser = new User(userId, "John Doe", "john@example.com", "1234567890");

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));
        when(userRepository.findById(userId)).thenReturn(Optional.of(mockUser));
        when(waitingListRepository.save(any(WaitingList.class))).thenAnswer(invocation -> invocation.getArgument(0));

        WaitingList result = waitingListService.joinWaitingList(waitingListRequest);

        assertEquals(eventId, result.getEvent().getId());
        assertEquals(userId, result.getUser().getId());
        assertEquals(mockUser.getUserPhone(), result.getUser().getUserPhone());
        assertEquals(mockUser.getUserName(), result.getUser().getUserName());
        assertEquals(mockUser.getUserEmail(), result.getUser().getUserEmail());
    }

    @Test
    void testJoinWaitingList_InvalidEventId() {
        int invalidEventId = 100;
        int userId = 101;

        WaitingListRequest waitingListRequest = new WaitingListRequest(invalidEventId, userId);

        when(eventRepository.findById(invalidEventId)).thenReturn(Optional.empty());

        assertThrows(EventNotFoundException.class, () -> waitingListService.joinWaitingList(waitingListRequest));
        verify(waitingListRepository, never()).save(any(WaitingList.class));
    }

    @Test
    void testJoinWaitingList_InvalidUserId() {
        int eventId = 1;
        int invalidUserId = 200;

        WaitingListRequest waitingListRequest = new WaitingListRequest(eventId, invalidUserId);

        Event mockEvent = new Event(eventId, "Event A", new Date(), "Description A", new Venue());

        when(eventRepository.findById(eventId)).thenReturn(Optional.of(mockEvent));
        when(userRepository.findById(invalidUserId)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> waitingListService.joinWaitingList(waitingListRequest));
        verify(waitingListRepository, never()).save(any(WaitingList.class));
    }
}
