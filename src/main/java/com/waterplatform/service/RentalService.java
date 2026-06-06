package com.waterplatform.service;

import com.waterplatform.dto.RentalDto;
import com.waterplatform.model.Rental;
import com.waterplatform.model.enums.RentalStatus;
import com.waterplatform.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RentalService {
    private final RentalRepository rentalRepository;
    private final BoatService boatService;
    private final EventService eventService;

    public RentalService(RentalRepository rentalRepository, BoatService boatService, EventService eventService) {
        this.rentalRepository = rentalRepository;
        this.boatService = boatService;
        this.eventService = eventService;
    }

    public List<RentalDto> findAll() {
        return rentalRepository.findAll().stream().map(RentalDto::fromEntity).toList();
    }

    public RentalDto findById(String id) {
        return rentalRepository.findById(id).map(RentalDto::fromEntity).orElse(null);
    }

    public RentalDto create(String id, String eventId, String userId, String boatId, LocalDateTime startTime) {
        Rental rental = new Rental(id, eventId, userId, boatId, startTime);
        return RentalDto.fromEntity(rentalRepository.save(rental));
    }

    public RentalDto completeRental(String id) {
        Rental rental = rentalRepository.findById(id).orElse(null);
        if (rental == null) return null;
        rental.setEndTime(LocalDateTime.now());
        rental.setStatus(RentalStatus.completed);
        return RentalDto.fromEntity(rentalRepository.save(rental));
    }

    public List<RentalDto> findByUser(String userId) {
        return rentalRepository.findByUserId(userId).stream().map(RentalDto::fromEntity).toList();
    }

    public List<RentalDto> findByBoat(String boatId) {
        return rentalRepository.findByBoatId(boatId).stream().map(RentalDto::fromEntity).toList();
    }
}
