package com.managmentbackend.task_management_system.controller;

import com.managmentbackend.task_management_system.dto.request.AdminLoginDTO;
import com.managmentbackend.task_management_system.dto.request.AdminSaveDTO;
import com.managmentbackend.task_management_system.service.AdminService;
import com.managmentbackend.task_management_system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveAdmin(@RequestBody AdminSaveDTO adminSaveDTO){
        String message = adminService.save(adminSaveDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Saved", message), HttpStatus.CREATED
        );
    }

    @PostMapping(path = "/login")
    public ResponseEntity<StandardResponse> loginAdmin(@RequestBody AdminLoginDTO adminLoginDTO){
        String message = adminService.login(adminLoginDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Logged", message), HttpStatus.OK
        );
    }
}
