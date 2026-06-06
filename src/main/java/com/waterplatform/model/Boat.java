package com.waterplatform.model;

import com.waterplatform.model.enums.BoatStatus;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "boats")
public class Boat {
    @Id
    private String id;

    private String pointId;

    @Column(unique = true)
    private String serialNumber;

    private String color;

    private String boatType;

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private BoatStatus status;

    private String conditionLevel;

    private LocalDate lastServiceDate;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        if (status == null) status = BoatStatus.available;
    }

    public Boat() {}

    public Boat(String id, String pointId, String serialNumber, String boatType, Integer capacity) {
        this.id = id;
        this.pointId = pointId;
        this.serialNumber = serialNumber;
        this.boatType = boatType;
        this.capacity = capacity;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getPointId() { return pointId; }
    public void setPointId(String pointId) { this.pointId = pointId; }
    public String getSerialNumber() { return serialNumber; }
    public void setSerialNumber(String serialNumber) { this.serialNumber = serialNumber; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getBoatType() { return boatType; }
    public void setBoatType(String boatType) { this.boatType = boatType; }
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    public BoatStatus getStatus() { return status; }
    public void setStatus(BoatStatus status) { this.status = status; }
    public String getConditionLevel() { return conditionLevel; }
    public void setConditionLevel(String conditionLevel) { this.conditionLevel = conditionLevel; }
    public LocalDate getLastServiceDate() { return lastServiceDate; }
    public void setLastServiceDate(LocalDate lastServiceDate) { this.lastServiceDate = lastServiceDate; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
