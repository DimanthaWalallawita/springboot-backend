package com.managmentbackend.task_management_system.service;

import com.managmentbackend.task_management_system.dto.request.AdminLoginDTO;
import com.managmentbackend.task_management_system.dto.request.AdminSaveDTO;

public interface AdminService {
    String save(AdminSaveDTO adminSaveDTO);

    String login(AdminLoginDTO adminLoginDTO);
}
