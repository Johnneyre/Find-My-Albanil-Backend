package com.my_find_albanil.demo.domain.models.request.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private UUID id;
    private String role;
    private String email;
    private String passwordHash;
    private String fullName;
    private String phone;
    private String location;
    private String bio;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}