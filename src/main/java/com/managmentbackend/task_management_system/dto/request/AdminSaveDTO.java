package com.managmentbackend.task_management_system.dto.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminSaveDTO {
    private String name;
    private String email;
    private String password;
}
