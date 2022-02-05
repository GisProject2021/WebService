package com.hassania.webServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.hassania.webServer.model.Incident;
import com.hassania.webServer.service.IncidentService;


@RestController
public class IncidentController {
	
	 @Autowired
	    private IncidentService IncidentService;

	    
	    @GetMapping("/Incidents")
	    
	    public Iterable<Incident> getIncidents() {
	        return IncidentService.getIncidents();
	    }
	    
	    
	    @RequestMapping(value = "/AddIncident", method = RequestMethod.POST)
		public Incident createIncident(@RequestBody Incident Incident) {
			return IncidentService.saveIncident(Incident);
		}
	    
	    @DeleteMapping("/Incident/{id}")
		public void deleteIncident(@PathVariable("id") final Integer id) {
			IncidentService.deleteIncident(id);
		}
	    
	    @RequestMapping(value = "/incidentsMobile/{declarant}", method = RequestMethod.GET)
	    public Iterable<Incident> getIncidentsM(@PathVariable("declarant") final String declarant) {
	    	return IncidentService.getIncidentsDec(declarant);
			
		}
	    
	    

}

