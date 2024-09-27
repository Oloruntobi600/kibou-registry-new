package com.algomart.kibouregistry.services.impl;

import com.algomart.kibouregistry.entity.Events;
import com.algomart.kibouregistry.repository.EventsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    private EventsRepo eventsRepo;

    public Events createEvent(Events event) {
        return eventsRepo.save(event);
    }
}
