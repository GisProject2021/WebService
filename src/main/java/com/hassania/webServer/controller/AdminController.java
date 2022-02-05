package com.hassania.webServer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.hassania.webServer.model.Admin;
import com.hassania.webServer.service.AdminService;


@RestController
public class AdminController {
	
	 @Autowired
	    private AdminService AdminService;

	    
	    @GetMapping("/Admins")
	    
	    public Iterable<Admin> getAdmins() {
	        return AdminService.getAdmins();
	    }
	    
	    
	    
	    @RequestMapping(value = "/AddAdmin", method = RequestMethod.POST)
		public Admin createAdmin(Admin Admin) {
			return AdminService.saveAdmin(Admin);
		}

}