package com.waterplatform.service;

import com.waterplatform.dto.*;
import com.waterplatform.model.*;
import com.waterplatform.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;
    private final TeamMemberRepository teamMemberRepository;

    public TournamentService(TournamentRepository tr, MatchRepository mr,
                             TeamRepository teamR, TeamMemberRepository tmr) {
        this.tournamentRepository = tr; this.matchRepository = mr;
        this.teamRepository = teamR; this.teamMemberRepository = tmr;
    }

    public List<TournamentDto> findAll() {
        return tournamentRepository.findAll().stream().map(TournamentDto::fromEntity).toList();
    }

    public TournamentDto create(String id, String eventId, String title) {
        return TournamentDto.fromEntity(tournamentRepository.save(new Tournament(id, eventId, title)));
    }

    public List<TeamDto> findAllTeams() {
        return teamRepository.findAll().stream().map(TeamDto::fromEntity).toList();
    }

    public TeamDto createTeam(String id, String title, String captainUserId) {
        return TeamDto.fromEntity(teamRepository.save(new Team(id, title, captainUserId)));
    }

    public List<MatchDto> findMatchesByTournament(String tournamentId) {
        return matchRepository.findByTournamentId(tournamentId).stream().map(MatchDto::fromEntity).toList();
    }

    public MatchDto createMatch(String id, String eventId, String teamAId, String teamBId) {
        return MatchDto.fromEntity(matchRepository.save(new Match(id, eventId, teamAId, teamBId, "planned")));
    }

    public MatchDto updateScore(String id, Integer scoreA, Integer scoreB) {
        Match m = matchRepository.findById(id).orElse(null);
        if (m == null) return null;
        m.setScoreA(scoreA); m.setScoreB(scoreB); m.setStatus("completed");
        return MatchDto.fromEntity(matchRepository.save(m));
    }
}
