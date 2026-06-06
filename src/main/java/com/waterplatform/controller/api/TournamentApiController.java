package com.waterplatform.controller.api;

import com.waterplatform.dto.*;
import com.waterplatform.service.TournamentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TournamentApiController {
    private final TournamentService tournamentService;

    public TournamentApiController(TournamentService tournamentService) { this.tournamentService = tournamentService; }

    @GetMapping("/tournaments")
    public List<TournamentDto> getAllTournaments() { return tournamentService.findAll(); }

    @PostMapping("/tournaments")
    public ResponseEntity<TournamentDto> createTournament(@RequestParam String id, @RequestParam String eventId,
                                                           @RequestParam String title) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tournamentService.create(id, eventId, title));
    }

    @GetMapping("/teams")
    public List<TeamDto> getAllTeams() { return tournamentService.findAllTeams(); }

    @PostMapping("/teams")
    public ResponseEntity<TeamDto> createTeam(@RequestParam String id, @RequestParam String title,
                                               @RequestParam String captainUserId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tournamentService.createTeam(id, title, captainUserId));
    }

    @GetMapping("/tournaments/{id}/matches")
    public List<MatchDto> getMatches(@PathVariable String id) {
        return tournamentService.findMatchesByTournament(id);
    }

    @PostMapping("/matches")
    public ResponseEntity<MatchDto> createMatch(@RequestParam String id, @RequestParam String eventId,
                                                 @RequestParam String teamAId, @RequestParam String teamBId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tournamentService.createMatch(id, eventId, teamAId, teamBId));
    }

    @PostMapping("/matches/{id}/score")
    public ResponseEntity<MatchDto> updateScore(@PathVariable String id, @RequestParam Integer scoreA,
                                                 @RequestParam Integer scoreB) {
        MatchDto dto = tournamentService.updateScore(id, scoreA, scoreB);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
}
