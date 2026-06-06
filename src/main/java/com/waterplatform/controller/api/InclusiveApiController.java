package com.waterplatform.controller.api;

import com.waterplatform.dto.InclusiveProfileDto;
import com.waterplatform.service.InclusiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inclusive")
public class InclusiveApiController {
    private final InclusiveService inclusiveService;

    public InclusiveApiController(InclusiveService inclusiveService) { this.inclusiveService = inclusiveService; }

    @GetMapping
    public List<InclusiveProfileDto> getAll() { return inclusiveService.findAll(); }

    @GetMapping("/user/{userId}")
    public ResponseEntity<InclusiveProfileDto> getByUser(@PathVariable String userId) {
        InclusiveProfileDto dto = inclusiveService.findByUserId(userId);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<InclusiveProfileDto> create(@RequestParam String id, @RequestParam String userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inclusiveService.create(id, userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InclusiveProfileDto> update(@PathVariable String id,
                                                       @RequestParam(required=false) String healthRestrictions,
                                                       @RequestParam(required=false) String allowedLoadLevel,
                                                       @RequestParam(required=false) String accessibilityNeeds,
                                                       @RequestParam(required=false) String supportPersonId) {
        InclusiveProfileDto dto = inclusiveService.update(id, healthRestrictions, allowedLoadLevel,
            accessibilityNeeds, supportPersonId);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
}
