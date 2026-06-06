package com.waterplatform.model;

import com.waterplatform.model.enums.RouteDifficulty;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "routes")
public class Route {
    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private RouteDifficulty difficulty;

    private Double distanceKm;

    private Integer estimatedDurationMin;

    private String routeType;

    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); }

    public Route() {}

    public Route(String id, String title, RouteDifficulty difficulty, Double distanceKm) {
        this.id = id; this.title = title; this.difficulty = difficulty; this.distanceKm = distanceKm;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public RouteDifficulty getDifficulty() { return difficulty; }
    public void setDifficulty(RouteDifficulty difficulty) { this.difficulty = difficulty; }
    public Double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(Double distanceKm) { this.distanceKm = distanceKm; }
    public Integer getEstimatedDurationMin() { return estimatedDurationMin; }
    public void setEstimatedDurationMin(Integer d) { this.estimatedDurationMin = d; }
    public String getRouteType() { return routeType; }
    public void setRouteType(String routeType) { this.routeType = routeType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
