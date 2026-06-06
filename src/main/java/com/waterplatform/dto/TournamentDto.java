package com.waterplatform.dto;

import com.waterplatform.model.Tournament;

public record TournamentDto(String id, String eventId, String title, String format, String status) {
    public static TournamentDto fromEntity(Tournament t) {
        return new TournamentDto(t.getId(), t.getEventId(), t.getTitle(), t.getFormat(), t.getStatus());
    }
}
