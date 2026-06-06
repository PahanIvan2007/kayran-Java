package com.waterplatform.service;

import com.waterplatform.dto.BoatDto;
import com.waterplatform.model.Boat;
import com.waterplatform.model.enums.BoatStatus;
import com.waterplatform.repository.BoatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatService {
    private final BoatRepository boatRepository;

    public BoatService(BoatRepository boatRepository) {
        this.boatRepository = boatRepository;
    }

    public List<BoatDto> findAll() {
        return boatRepository.findAll().stream().map(BoatDto::fromEntity).toList();
    }

    public BoatDto findById(String id) {
        return boatRepository.findById(id).map(BoatDto::fromEntity).orElse(null);
    }

    public BoatDto create(String id, String pointId, String serialNumber, String boatType, Integer capacity) {
        Boat boat = new Boat(id, pointId, serialNumber, boatType, capacity);
        return BoatDto.fromEntity(boatRepository.save(boat));
    }

    public BoatDto updateStatus(String id, BoatStatus status) {
        Boat boat = boatRepository.findById(id).orElse(null);
        if (boat == null) return null;
        boat.setStatus(status);
        return BoatDto.fromEntity(boatRepository.save(boat));
    }

    public List<BoatDto> findByPoint(String pointId) {
        return boatRepository.findByPointId(pointId).stream().map(BoatDto::fromEntity).toList();
    }

    public List<BoatDto> findByPointAndStatus(String pointId, BoatStatus status) {
        return boatRepository.findByPointIdAndStatus(pointId, status).stream().map(BoatDto::fromEntity).toList();
    }
}
