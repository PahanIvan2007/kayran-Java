package com.waterplatform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "inclusive_profiles")
public class InclusiveProfile {
    @Id
    private String id;

    @Column(nullable = false)
    private String userId;

    private String healthRestrictions;

    private String allowedLoadLevel;

    private String accessibilityNeeds;

    private String supportPersonId;

    private String adaptiveEquipment;

    private String trainingLevel;

    private String safetyNotes;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() { createdAt = LocalDateTime.now(); updatedAt = LocalDateTime.now(); }

    @PreUpdate
    protected void onUpdate() { updatedAt = LocalDateTime.now(); }

    public InclusiveProfile() {}

    public InclusiveProfile(String id, String userId) {
        this.id = id; this.userId = userId;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getHealthRestrictions() { return healthRestrictions; }
    public void setHealthRestrictions(String healthRestrictions) { this.healthRestrictions = healthRestrictions; }
    public String getAllowedLoadLevel() { return allowedLoadLevel; }
    public void setAllowedLoadLevel(String allowedLoadLevel) { this.allowedLoadLevel = allowedLoadLevel; }
    public String getAccessibilityNeeds() { return accessibilityNeeds; }
    public void setAccessibilityNeeds(String accessibilityNeeds) { this.accessibilityNeeds = accessibilityNeeds; }
    public String getSupportPersonId() { return supportPersonId; }
    public void setSupportPersonId(String supportPersonId) { this.supportPersonId = supportPersonId; }
    public String getAdaptiveEquipment() { return adaptiveEquipment; }
    public void setAdaptiveEquipment(String adaptiveEquipment) { this.adaptiveEquipment = adaptiveEquipment; }
    public String getTrainingLevel() { return trainingLevel; }
    public void setTrainingLevel(String trainingLevel) { this.trainingLevel = trainingLevel; }
    public String getSafetyNotes() { return safetyNotes; }
    public void setSafetyNotes(String safetyNotes) { this.safetyNotes = safetyNotes; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
