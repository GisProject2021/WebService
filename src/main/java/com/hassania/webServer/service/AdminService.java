package com.hassania.webServer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassania.webServer.model.Admin;
import com.hassania.webServer.repository.AdminRepository;


@Service
public class AdminService {

    @Autowired
    
    private AdminRepository AdminRepository;

    public Optional<Admin> getAdmin(final Integer id) {
        return AdminRepository.findById(id);
    }

    public Iterable<Admin> getAdmins() {
        return AdminRepository.findAll();
    }

    public void deleteAdmin(final Integer id) {
    	AdminRepository.deleteById(id);
    }

    public Admin saveAdmin(Admin Admin) {
    	Admin savedAdmin = AdminRepository.save(Admin);
        return savedAdmin;
    }

}
