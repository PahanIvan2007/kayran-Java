package com.waterplatform.dto;

import com.waterplatform.model.RoutePoint;

public record RoutePointDto(String id, String routeId, Integer orderIndex, Double lat, Double lng,
                            String title, String description, String checkpointType) {
    public static RoutePointDto fromEntity(RoutePoint p) {
        return new RoutePointDto(p.getId(), p.getRouteId(), p.getOrderIndex(), p.getLat(), p.getLng(),
            p.getTitle(), p.getDescription(), p.getCheckpointType());
    }
}
