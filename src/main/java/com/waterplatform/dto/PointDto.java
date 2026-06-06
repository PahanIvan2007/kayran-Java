package com.waterplatform.dto;

import com.waterplatform.model.Point;
import com.waterplatform.model.enums.PointType;

public record PointDto(
    String id,
    String title,
    PointType type,
    String address,
    Double lat,
    Double lng,
    String status
) {
    public static PointDto fromEntity(Point p) {
        return new PointDto(
            p.getId(), p.getTitle(), p.getType(),
            p.getAddress(), p.getLat(), p.getLng(),
            p.getStatus()
        );
    }
}
