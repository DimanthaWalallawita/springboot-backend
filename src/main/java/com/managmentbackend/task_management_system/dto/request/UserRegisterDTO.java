package com.managmentbackend.task_management_system.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRegisterDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String address;
    private String password;
    private String role;
}
