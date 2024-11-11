package com.algomart.kibouregistry.config;
import com.algomart.kibouregistry.entity.Events;
import com.algomart.kibouregistry.enums.EventType;
import com.algomart.kibouregistry.models.request.EventsRequest;
import com.algomart.kibouregistry.services.impl.EventsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDate;

@Configuration
@EnableScheduling
@Slf4j
public class ScheduledConfig {
    @Autowired
    private EventsServiceImpl eventsService;
    @Scheduled(cron = "0 20 15 * * MON,TUE,WED")
    public void scheduleRegularEvents() {
        log.info("Running Scheduler");
        EventsRequest regularEvent = new EventsRequest();
        regularEvent.setEventType(EventType.REGULAR);
        regularEvent.setVenue("Lagos Event Centre");
        regularEvent.setDate(LocalDate.now());
        eventsService.addEvents(regularEvent);

    }


    @Scheduled(cron = "0 0 9 ? 1/1 MON#1")
    public void scheduleSpecialEvents() {
        Events specialEvents = new Events();
        specialEvents.setEventType(EventType.SPECIAL);

    }
    }


