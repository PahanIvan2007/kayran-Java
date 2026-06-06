package com.waterplatform.repository;

import com.waterplatform.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TournamentRepository extends JpaRepository<Tournament, String> {
    List<Tournament> findByEventId(String eventId);
}
