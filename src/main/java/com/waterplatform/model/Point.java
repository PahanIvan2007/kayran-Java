package com.waterplatform.model;

import com.waterplatform.model.enums.PointType;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "points")
public class Point {
    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    private PointType type;

    private String franchiseId;

    private String address;

    private Double lat;

    private Double lng;

    private String timezone;

    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public Point() {}

    public Point(String id, String title, PointType type, Double lat, Double lng) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.lat = lat;
        this.lng = lng;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public PointType getType() { return type; }
    public void setType(PointType type) { this.type = type; }
    public String getFranchiseId() { return franchiseId; }
    public void setFranchiseId(String franchiseId) { this.franchiseId = franchiseId; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }
    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }
    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
