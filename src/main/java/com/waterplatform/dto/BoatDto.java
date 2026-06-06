package com.waterplatform.dto;

import com.waterplatform.model.Boat;
import com.waterplatform.model.enums.BoatStatus;

public record BoatDto(
    String id,
    String pointId,
    String serialNumber,
    String color,
    String boatType,
    Integer capacity,
    BoatStatus status,
    String conditionLevel
) {
    public static BoatDto fromEntity(Boat b) {
        return new BoatDto(
            b.getId(), b.getPointId(), b.getSerialNumber(),
            b.getColor(), b.getBoatType(), b.getCapacity(),
            b.getStatus(), b.getConditionLevel()
        );
    }
}
