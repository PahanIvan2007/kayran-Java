package com.waterplatform.controller.api;

import com.waterplatform.dto.RentalDto;
import com.waterplatform.service.RentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalApiController {
    private final RentalService rentalService;

    public RentalApiController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping
    public List<RentalDto> getAll() {
        return rentalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> getById(@PathVariable String id) {
        RentalDto dto = rentalService.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<RentalDto> create(@RequestParam String id, @RequestParam String eventId,
                                             @RequestParam String userId, @RequestParam String boatId) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(rentalService.create(id, eventId, userId, boatId, LocalDateTime.now()));
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<RentalDto> complete(@PathVariable String id) {
        RentalDto dto = rentalService.completeRental(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/by-user/{userId}")
    public List<RentalDto> getByUser(@PathVariable String userId) {
        return rentalService.findByUser(userId);
    }
}
