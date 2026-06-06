package com.waterplatform.service;

import com.waterplatform.dto.CreateUserRequest;
import com.waterplatform.dto.UserDto;
import com.waterplatform.model.User;
import com.waterplatform.model.enums.UserRole;
import com.waterplatform.model.enums.UserStatus;
import com.waterplatform.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).toList();
    }

    public UserDto findById(String id) {
        return userRepository.findById(id).map(UserDto::fromEntity).orElse(null);
    }

    public UserDto create(CreateUserRequest req) {
        if (userRepository.existsByUsername(req.username())) {
            throw new RuntimeException("Username already taken");
        }
        User user = new User(req.id(), req.firstName(), req.lastName(),
            req.phone(), req.email(), req.role(), UserStatus.active);
        user.setUsername(req.username());
        user.setPassword(passwordEncoder.encode(req.password()));
        return UserDto.fromEntity(userRepository.save(user));
    }

    public UserDto register(CreateUserRequest req) {
        return create(req);
    }

    public UserDto update(String id, CreateUserRequest req) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        user.setFirstName(req.firstName());
        user.setLastName(req.lastName());
        user.setPhone(req.phone());
        user.setEmail(req.email());
        if (req.role() != null) user.setRole(req.role());
        if (req.username() != null) user.setUsername(req.username());
        if (req.password() != null && !req.password().isBlank()) {
            user.setPassword(passwordEncoder.encode(req.password()));
        }
        return UserDto.fromEntity(userRepository.save(user));
    }

    public void delete(String id) {
        userRepository.findById(id).ifPresent(u -> {
            u.setStatus(UserStatus.deleted);
            userRepository.save(u);
        });
    }

    public List<UserDto> findByRole(UserRole role) {
        return userRepository.findByRole(role).stream().map(UserDto::fromEntity).toList();
    }

    public boolean usernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}
