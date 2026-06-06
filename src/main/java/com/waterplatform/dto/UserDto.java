package com.waterplatform.dto;

import com.waterplatform.model.User;
import com.waterplatform.model.enums.UserRole;
import com.waterplatform.model.enums.UserStatus;
import java.time.LocalDateTime;

public record UserDto(
    String id,
    String firstName,
    String lastName,
    String phone,
    String email,
    String username,
    UserRole role,
    String medicalFlags,
    String accessibilityLevel,
    UserStatus status,
    LocalDateTime createdAt
) {
    public static UserDto fromEntity(User u) {
        return new UserDto(
            u.getId(), u.getFirstName(), u.getLastName(),
            u.getPhone(), u.getEmail(), u.getUsername(),
            u.getRole(), u.getMedicalFlags(), u.getAccessibilityLevel(),
            u.getStatus(), u.getCreatedAt()
        );
    }
}
