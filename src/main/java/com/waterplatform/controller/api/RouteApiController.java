package com.waterplatform.controller.api;

import com.waterplatform.dto.RouteDto;
import com.waterplatform.dto.RoutePointDto;
import com.waterplatform.service.RouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteApiController {
    private final RouteService routeService;

    public RouteApiController(RouteService routeService) { this.routeService = routeService; }

    @GetMapping
    public List<RouteDto> getAll() { return routeService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<RouteDto> getById(@PathVariable String id) {
        RouteDto dto = routeService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RouteDto> create(@RequestParam String id, @RequestParam String title,
                                            @RequestParam(required=false) String difficulty,
                                            @RequestParam(required=false) Double distanceKm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.create(id, title, difficulty, distanceKm));
    }

    @GetMapping("/{routeId}/points")
    public List<RoutePointDto> getPoints(@PathVariable String routeId) {
        return routeService.getPoints(routeId);
    }

    @PostMapping("/{routeId}/points")
    public ResponseEntity<RoutePointDto> addPoint(@RequestParam String id, @PathVariable String routeId,
                                                   @RequestParam Integer orderIndex, @RequestParam Double lat,
                                                   @RequestParam Double lng, @RequestParam String title) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(routeService.addPoint(id, routeId, orderIndex, lat, lng, title));
    }
}
