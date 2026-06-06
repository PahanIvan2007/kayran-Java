package com.waterplatform.dto;

import com.waterplatform.model.Route;
import com.waterplatform.model.enums.RouteDifficulty;

public record RouteDto(String id, String title, String description, RouteDifficulty difficulty,
                       Double distanceKm, Integer estimatedDurationMin, String routeType, String status) {
    public static RouteDto fromEntity(Route r) {
        return new RouteDto(r.getId(), r.getTitle(), r.getDescription(), r.getDifficulty(),
            r.getDistanceKm(), r.getEstimatedDurationMin(), r.getRouteType(), r.getStatus());
    }
}
