package com.waterplatform.dto;

import com.waterplatform.model.enums.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record CreateEventRequest(
    @NotBlank String id,
    @NotNull EventType eventType,
    @NotBlank String title,
    String description,
    @NotNull LocalDateTime startTime,
    LocalDateTime endTime,
    @NotBlank String pointId,
    String routeId,
    @NotBlank String createdBy
) {}
