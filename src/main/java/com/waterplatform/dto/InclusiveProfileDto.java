package com.waterplatform.dto;

import com.waterplatform.model.InclusiveProfile;
import java.time.LocalDateTime;

public record InclusiveProfileDto(String id, String userId, String healthRestrictions, String allowedLoadLevel,
                                  String accessibilityNeeds, String supportPersonId, String adaptiveEquipment,
                                  String trainingLevel, String safetyNotes, LocalDateTime createdAt) {
    public static InclusiveProfileDto fromEntity(InclusiveProfile p) {
        return new InclusiveProfileDto(p.getId(), p.getUserId(), p.getHealthRestrictions(), p.getAllowedLoadLevel(),
            p.getAccessibilityNeeds(), p.getSupportPersonId(), p.getAdaptiveEquipment(), p.getTrainingLevel(),
            p.getSafetyNotes(), p.getCreatedAt());
    }
}
