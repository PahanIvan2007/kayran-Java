package com.waterplatform.repository;

import com.waterplatform.model.Event;
import com.waterplatform.model.enums.EventStatus;
import com.waterplatform.model.enums.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
    List<Event> findByEventType(EventType eventType);
    List<Event> findByStatus(EventStatus status);
    List<Event> findByPointId(String pointId);
    List<Event> findByCreatedBy(String userId);
    List<Event> findByStartTimeAfter(LocalDateTime date);
    List<Event> findByStartTimeBetween(LocalDateTime from, LocalDateTime to);
}
