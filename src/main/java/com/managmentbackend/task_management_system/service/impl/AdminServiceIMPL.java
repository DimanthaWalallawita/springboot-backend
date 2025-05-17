package com.managmentbackend.task_management_system.service.impl;

import com.managmentbackend.task_management_system.dto.request.AdminLoginDTO;
import com.managmentbackend.task_management_system.dto.request.AdminSaveDTO;
import com.managmentbackend.task_management_system.entity.Admin;
import com.managmentbackend.task_management_system.exception.EntryDuplicateException;
import com.managmentbackend.task_management_system.exception.NotFoundException;
import com.managmentbackend.task_management_system.exception.RuntimeErrorException;
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
        try {
            if (adminRepository.existsByEmail(adminSaveDTO.getEmail())) {
                throw new EntryDuplicateException("Admin already exist!");
            }

            Admin admin = modelMapper.map(adminSaveDTO, Admin.class);
            admin.setPassword(bCryptPasswordEncoder.encode(adminSaveDTO.getPassword()));
            adminRepository.save(admin);
            return "Saved";
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String login(AdminLoginDTO adminLoginDTO) {
        try {
            if(!adminRepository.existsByEmail(adminLoginDTO.getEmail())){
                throw new NotFoundException("Admin email not founded!");
            } else{
                Admin admin = adminRepository.findByEmail(adminLoginDTO.getEmail());

               if(!bCryptPasswordEncoder.matches(adminLoginDTO.getPassword(), admin.getPassword())){
                   throw new NotFoundException("Password is not matched!");
               }

               return "Login success!";
            }
        } catch (RuntimeErrorException e) {
            throw new RuntimeErrorException("Error in runtime");
        }
    }
}
