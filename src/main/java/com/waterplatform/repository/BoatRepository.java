package com.waterplatform.repository;

import com.waterplatform.model.Boat;
import com.waterplatform.model.enums.BoatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoatRepository extends JpaRepository<Boat, String> {
    List<Boat> findByPointId(String pointId);
    List<Boat> findByStatus(BoatStatus status);
    List<Boat> findByPointIdAndStatus(String pointId, BoatStatus status);
}
