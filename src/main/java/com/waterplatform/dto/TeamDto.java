package com.waterplatform.dto;

import com.waterplatform.model.Team;

public record TeamDto(String id, String title, String captainUserId, String status) {
    public static TeamDto fromEntity(Team t) {
        return new TeamDto(t.getId(), t.getTitle(), t.getCaptainUserId(), t.getStatus());
    }
}
