package com.waterplatform.service;

import com.waterplatform.dto.RouteDto;
import com.waterplatform.dto.RoutePointDto;
import com.waterplatform.model.Route;
import com.waterplatform.model.RoutePoint;
import com.waterplatform.repository.RoutePointRepository;
import com.waterplatform.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteRepository routeRepository;
    private final RoutePointRepository routePointRepository;

    public RouteService(RouteRepository routeRepository, RoutePointRepository routePointRepository) {
        this.routeRepository = routeRepository;
        this.routePointRepository = routePointRepository;
    }

    public List<RouteDto> findAll() {
        return routeRepository.findAll().stream().map(RouteDto::fromEntity).toList();
    }

    public RouteDto findById(String id) {
        return routeRepository.findById(id).map(RouteDto::fromEntity).orElse(null);
    }

    public RouteDto create(String id, String title, String difficulty, Double distanceKm) {
        Route r = new Route(id, title, null, distanceKm);
        if (difficulty != null)
            r.setDifficulty(com.waterplatform.model.enums.RouteDifficulty.valueOf(difficulty));
        return RouteDto.fromEntity(routeRepository.save(r));
    }

    public List<RoutePointDto> getPoints(String routeId) {
        return routePointRepository.findByRouteIdOrderByOrderIndex(routeId)
            .stream().map(RoutePointDto::fromEntity).toList();
    }

    public RoutePointDto addPoint(String id, String routeId, Integer orderIndex, Double lat, Double lng, String title) {
        RoutePoint p = new RoutePoint(id, routeId, orderIndex, lat, lng, title);
        return RoutePointDto.fromEntity(routePointRepository.save(p));
    }
}
