package com.managmentbackend.task_management_system.service.impl;

import com.managmentbackend.task_management_system.dto.request.AdminSaveDTO;
import com.managmentbackend.task_management_system.entity.Admin;
import com.managmentbackend.task_management_system.repository.AdminRepository;
import com.managmentbackend.task_management_system.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceIMPL implements AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String save(AdminSaveDTO adminSaveDTO) {
        if(adminRepository.existsByEmail(adminSaveDTO.getEmail())){
            return "Admin already exists";
        }

        Admin admin = modelMapper.map(adminSaveDTO, Admin.class);
        admin.setPassword(bCryptPasswordEncoder.encode(adminSaveDTO.getPassword()));
        adminRepository.save(admin);
        return "Saved";
    }
}
