package com.waterplatform.repository;

import com.waterplatform.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TeamRepository extends JpaRepository<Team, String> {
    List<Team> findByCaptainUserId(String userId);
}
