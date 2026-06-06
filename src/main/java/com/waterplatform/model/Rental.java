package com.waterplatform.model;

import com.waterplatform.model.enums.RentalStatus;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
public class Rental {
    @Id
    private String id;

    private String eventId;

    private String userId;

    private String boatId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String paymentId;

    @Enumerated(EnumType.STRING)
    private RentalStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) status = RentalStatus.active;
    }

    public Rental() {}

    public Rental(String id, String eventId, String userId, String boatId, LocalDateTime startTime) {
        this.id = id;
        this.eventId = eventId;
        this.userId = userId;
        this.boatId = boatId;
        this.startTime = startTime;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEventId() { return eventId; }
    public void setEventId(String eventId) { this.eventId = eventId; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getBoatId() { return boatId; }
    public void setBoatId(String boatId) { this.boatId = boatId; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public RentalStatus getStatus() { return status; }
    public void setStatus(RentalStatus status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
