package com.hassania.webServer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassania.webServer.model.Incident;
import com.hassania.webServer.repository.IncidentRepository;


@Service
public class IncidentService {

    @Autowired
    
    private IncidentRepository IncidentRepository;

    public Iterable<Incident> getIncidentsDec(final String declarant) {
        return IncidentRepository.findByDeclarant(declarant);
    }
    
    
    
    public Optional<Incident> getIncident(final Integer id) {
        return IncidentRepository.findById(id);
    }
    
    

    public Iterable<Incident> getIncidents() {
        return IncidentRepository.findAll();
    }
	

    public void deleteIncident(final Integer id) {
    	IncidentRepository.deleteById(id);
    }

    public Incident saveIncident(Incident Incident) {
    	Incident savedIncident = IncidentRepository.save(Incident);
        return savedIncident;
    }

}
