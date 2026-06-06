package com.waterplatform.service;

import com.waterplatform.dto.CreateEventRequest;
import com.waterplatform.dto.EventDto;
import com.waterplatform.model.Event;
import com.waterplatform.model.enums.EventStatus;
import com.waterplatform.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<EventDto> findAll() {
        return eventRepository.findAll().stream().map(EventDto::fromEntity).toList();
    }

    public EventDto findById(String id) {
        return eventRepository.findById(id).map(EventDto::fromEntity).orElse(null);
    }

    public EventDto create(CreateEventRequest req) {
        Event event = new Event(req.id(), req.eventType(), req.title(),
            req.pointId(), req.createdBy(), req.startTime());
        event.setDescription(req.description());
        event.setEndTime(req.endTime());
        event.setRouteId(req.routeId());
        return EventDto.fromEntity(eventRepository.save(event));
    }

    public EventDto updateStatus(String id, EventStatus status) {
        Event event = eventRepository.findById(id).orElse(null);
        if (event == null) return null;
        event.setStatus(status);
        return EventDto.fromEntity(eventRepository.save(event));
    }

    public void delete(String id) {
        eventRepository.deleteById(id);
    }

    public List<EventDto> findByPoint(String pointId) {
        return eventRepository.findByPointId(pointId).stream().map(EventDto::fromEntity).toList();
    }
}
