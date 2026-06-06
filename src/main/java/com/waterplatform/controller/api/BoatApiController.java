package com.waterplatform.controller.api;

import com.waterplatform.dto.BoatDto;
import com.waterplatform.service.BoatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boats")
public class BoatApiController {
    private final BoatService boatService;

    public BoatApiController(BoatService boatService) {
        this.boatService = boatService;
    }

    @GetMapping
    public List<BoatDto> getAll() {
        return boatService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoatDto> getById(@PathVariable String id) {
        BoatDto dto = boatService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BoatDto> create(@RequestParam String id, @RequestParam String pointId,
                                           @RequestParam String serialNumber, @RequestParam String boatType,
                                           @RequestParam Integer capacity) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(boatService.create(id, pointId, serialNumber, boatType, capacity));
    }

    @GetMapping("/by-point/{pointId}")
    public List<BoatDto> getByPoint(@PathVariable String pointId) {
        return boatService.findByPoint(pointId);
    }
}
