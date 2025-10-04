package com.my_find_albanil.demo.domain.models.request.user;

import jakarta.validation.constraints.*;
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
    
    @NotBlank(message = "Role is required")
    @Pattern(regexp = "worker|employer|admin", message = "Role must be worker, employer, or admin")
    private String role;
    
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String passwordHash;
    
    @Size(max = 255, message = "Full name must not exceed 255 characters")
    private String fullName;
    
    @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Phone must be a valid phone number", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String phone;
    
    private String location;
    
    @Size(max = 1000, message = "Bio must not exceed 1000 characters")
    private String bio;
    
    private String avatarUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}