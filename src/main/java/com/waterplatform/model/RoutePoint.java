package com.waterplatform.model;

import jakarta.persistence.*;

@Entity
@Table(name = "route_points")
public class RoutePoint {
    @Id
    private String id;

    private String routeId;

    private Integer orderIndex;

    private Double lat;

    private Double lng;

    private String title;

    @Column(length = 500)
    private String description;

    private String checkpointType;

    public RoutePoint() {}

    public RoutePoint(String id, String routeId, Integer orderIndex, Double lat, Double lng, String title) {
        this.id = id; this.routeId = routeId; this.orderIndex = orderIndex;
        this.lat = lat; this.lng = lng; this.title = title;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getRouteId() { return routeId; }
    public void setRouteId(String routeId) { this.routeId = routeId; }
    public Integer getOrderIndex() { return orderIndex; }
    public void setOrderIndex(Integer orderIndex) { this.orderIndex = orderIndex; }
    public Double getLat() { return lat; }
    public void setLat(Double lat) { this.lat = lat; }
    public Double getLng() { return lng; }
    public void setLng(Double lng) { this.lng = lng; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCheckpointType() { return checkpointType; }
    public void setCheckpointType(String checkpointType) { this.checkpointType = checkpointType; }
}
