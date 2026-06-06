package com.waterplatform.controller.api;

import com.waterplatform.dto.PointDto;
import com.waterplatform.model.Point;
import com.waterplatform.model.enums.PointType;
import com.waterplatform.repository.PointRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/points")
public class PointApiController {
    private final PointRepository pointRepository;

    public PointApiController(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @GetMapping
    public List<PointDto> getAll() {
        return pointRepository.findAll().stream().map(PointDto::fromEntity).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointDto> getById(@PathVariable String id) {
        return pointRepository.findById(id)
            .map(p -> ResponseEntity.ok(PointDto.fromEntity(p)))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PointDto> create(@RequestParam String id, @RequestParam String title,
                                            @RequestParam PointType type, @RequestParam Double lat,
                                            @RequestParam Double lng) {
        Point point = new Point(id, title, type, lat, lng);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(PointDto.fromEntity(pointRepository.save(point)));
    }
}
