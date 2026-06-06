package com.waterplatform.dto;

import com.waterplatform.model.Rental;
import com.waterplatform.model.enums.RentalStatus;
import java.time.LocalDateTime;

public record RentalDto(
    String id,
    String eventId,
    String userId,
    String boatId,
    LocalDateTime startTime,
    LocalDateTime endTime,
    RentalStatus status
) {
    public static RentalDto fromEntity(Rental r) {
        return new RentalDto(
            r.getId(), r.getEventId(), r.getUserId(),
            r.getBoatId(), r.getStartTime(), r.getEndTime(),
            r.getStatus()
        );
    }
}
