package com.waterplatform.repository;

import com.waterplatform.model.Rental;
import com.waterplatform.model.enums.RentalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, String> {
    List<Rental> findByUserId(String userId);
    List<Rental> findByBoatId(String boatId);
    List<Rental> findByEventId(String eventId);
    List<Rental> findByStatus(RentalStatus status);
}
