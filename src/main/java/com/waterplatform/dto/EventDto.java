package com.waterplatform.dto;

import com.waterplatform.model.Event;
import com.waterplatform.model.enums.EventStatus;
import com.waterplatform.model.enums.EventType;
import java.time.LocalDateTime;

public record EventDto(
    String id,
    EventType eventType,
    String title,
    String description,
    LocalDateTime startTime,
    LocalDateTime endTime,
    String pointId,
    String routeId,
    String createdBy,
    EventStatus status,
    LocalDateTime createdAt
) {
    public static EventDto fromEntity(Event e) {
        return new EventDto(
            e.getId(), e.getEventType(), e.getTitle(),
            e.getDescription(), e.getStartTime(), e.getEndTime(),
            e.getPointId(), e.getRouteId(), e.getCreatedBy(),
            e.getStatus(), e.getCreatedAt()
        );
    }
}
