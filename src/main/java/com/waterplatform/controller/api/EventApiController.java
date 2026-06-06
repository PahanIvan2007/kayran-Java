package com.waterplatform.controller.api;

import com.waterplatform.dto.CreateEventRequest;
import com.waterplatform.dto.EventDto;
import com.waterplatform.model.enums.EventStatus;
import com.waterplatform.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventApiController {
    private final EventService eventService;

    public EventApiController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<EventDto> getAll() {
        return eventService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getById(@PathVariable String id) {
        EventDto dto = eventService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<EventDto> create(@Valid @RequestBody CreateEventRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.create(req));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<EventDto> updateStatus(@PathVariable String id, @RequestParam EventStatus status) {
        EventDto dto = eventService.updateStatus(id, status);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        eventService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-point/{pointId}")
    public List<EventDto> getByPoint(@PathVariable String pointId) {
        return eventService.findByPoint(pointId);
    }
}
