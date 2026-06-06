package com.waterplatform.repository;

import com.waterplatform.model.InclusiveProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InclusiveProfileRepository extends JpaRepository<InclusiveProfile, String> {
    Optional<InclusiveProfile> findByUserId(String userId);
}
