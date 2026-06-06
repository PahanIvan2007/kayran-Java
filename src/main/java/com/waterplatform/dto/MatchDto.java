package com.waterplatform.dto;

import com.waterplatform.model.Match;
import java.time.LocalDateTime;

public record MatchDto(String id, String eventId, String tournamentId, String teamAId, String teamBId,
                       String judgeUserId, LocalDateTime startTime, LocalDateTime endTime,
                       Integer scoreA, Integer scoreB, String status) {
    public static MatchDto fromEntity(Match m) {
        return new MatchDto(m.getId(), m.getEventId(), m.getTournamentId(), m.getTeamAId(), m.getTeamBId(),
            m.getJudgeUserId(), m.getStartTime(), m.getEndTime(), m.getScoreA(), m.getScoreB(), m.getStatus());
    }
}
