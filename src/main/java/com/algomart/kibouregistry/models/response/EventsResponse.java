package com.algomart.kibouregistry.models.response;

import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventsResponse {
    private Long eventId;
    private LocalDate date;
    private String eventType;
    private String venue;
}
