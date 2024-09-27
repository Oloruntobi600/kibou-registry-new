package com.algomart.kibouregistry.controller;

import com.algomart.kibouregistry.entity.Events;
import com.algomart.kibouregistry.services.impl.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public ResponseEntity<Events> createEvent(@RequestBody Events event) {
        Events createdEvent = eventService.createEvent(event);
        return ResponseEntity.ok(createdEvent);
    }
}
