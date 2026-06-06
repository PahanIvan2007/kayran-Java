package com.waterplatform.repository;

import com.waterplatform.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatchRepository extends JpaRepository<Match, String> {
    List<Match> findByTournamentId(String tournamentId);
    List<Match> findByEventId(String eventId);
    List<Match> findByJudgeUserId(String judgeUserId);
}
