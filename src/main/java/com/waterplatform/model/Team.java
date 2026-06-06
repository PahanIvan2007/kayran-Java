package com.waterplatform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    private String id;

    @Column(nullable = false)
    private String title;

    private String captainUserId;

    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); }

    public Team() {}

    public Team(String id, String title, String captainUserId) {
        this.id = id; this.title = title; this.captainUserId = captainUserId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getCaptainUserId() { return captainUserId; }
    public void setCaptainUserId(String captainUserId) { this.captainUserId = captainUserId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
