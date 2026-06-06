package com.waterplatform.service;

import com.waterplatform.dto.InclusiveProfileDto;
import com.waterplatform.model.InclusiveProfile;
import com.waterplatform.repository.InclusiveProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InclusiveService {
    private final InclusiveProfileRepository repository;

    public InclusiveService(InclusiveProfileRepository repository) { this.repository = repository; }

    public List<InclusiveProfileDto> findAll() {
        return repository.findAll().stream().map(InclusiveProfileDto::fromEntity).toList();
    }

    public InclusiveProfileDto findByUserId(String userId) {
        return repository.findByUserId(userId).map(InclusiveProfileDto::fromEntity).orElse(null);
    }

    public InclusiveProfileDto create(String id, String userId) {
        return InclusiveProfileDto.fromEntity(repository.save(new InclusiveProfile(id, userId)));
    }

    public InclusiveProfileDto update(String id, String healthRestrictions, String allowedLoadLevel,
                                       String accessibilityNeeds, String supportPersonId) {
        InclusiveProfile p = repository.findById(id).orElse(null);
        if (p == null) return null;
        if (healthRestrictions != null) p.setHealthRestrictions(healthRestrictions);
        if (allowedLoadLevel != null) p.setAllowedLoadLevel(allowedLoadLevel);
        if (accessibilityNeeds != null) p.setAccessibilityNeeds(accessibilityNeeds);
        if (supportPersonId != null) p.setSupportPersonId(supportPersonId);
        return InclusiveProfileDto.fromEntity(repository.save(p));
    }
}
