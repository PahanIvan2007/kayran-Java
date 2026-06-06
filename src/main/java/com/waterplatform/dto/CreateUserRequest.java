package com.waterplatform.dto;

import com.waterplatform.model.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
    @NotBlank String id,
    @NotBlank String firstName,
    @NotBlank String lastName,
    String phone,
    String email,
    @NotBlank @Size(min = 3) String username,
    @NotBlank @Size(min = 4) String password,
    UserRole role
) {}
