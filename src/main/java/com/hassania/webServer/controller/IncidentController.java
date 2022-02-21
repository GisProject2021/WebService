package com.hassania.webServer.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hassania.webServer.model.Incident;
import com.hassania.webServer.service.IncidentService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class IncidentController {
	
	 @Autowired
	    private IncidentService IncidentService;

	    
	    @GetMapping("/Incidents")
	    public Iterable<Incident> getIncidents() {
	        return IncidentService.getIncidents();
	    }
	   //get incident by id
	    @GetMapping("/Incident/{id}")
	    public Optional<Incident> getIncidentById(@PathVariable int id) {
	    	return IncidentService.getIncident(id);
	    }
	    
	    //Ajouter un incident
	    @RequestMapping(value = "/AddIncident", method = RequestMethod.POST)
		public Incident createIncident(@RequestBody Incident Incident) {
			return IncidentService.saveIncident(Incident);
		}
	    
	    //Supprimer un incident
	    @DeleteMapping("/DeleteIncident/{id}")
		public void deleteIncident(@PathVariable("id") final Integer id) {
			IncidentService.deleteIncident(id);
		}
	    
	    //Afficher les incidents d'un déclarant
	    @RequestMapping(value = "/incidentsMobile/{declarant}", method = RequestMethod.GET)
	    public Iterable<Incident> getIncidentsM(@PathVariable("declarant") final String declarant) {
	    	return IncidentService.getIncidentsDeclarant(declarant);
			
		}
	    
	    @RequestMapping(value = "/filtreSecteur/{secteur}", method = RequestMethod.GET)
	    public Iterable<Incident> getIncidentsSecteur(@PathVariable("secteur") final String secteur) {
	    	return IncidentService.getIncidentsSecteur(secteur);
			
		}
	    
	    @RequestMapping(value = "/filtreStatut/{statut}", method = RequestMethod.GET)
	    public Iterable<Incident> getIncidentsStatut(@PathVariable("statut") final String statut) {
	    	return IncidentService.getIncidentsStatut(statut);
			
		}
	    
	  //Modifier le statut d'un incident
	    @PutMapping("/ModifierStatut/{id}")
		public Incident updateIncidentStatut(@PathVariable("id") final Integer id, @RequestBody Incident Incident) {
			Optional<Incident> e = IncidentService.getIncident(id);
			if(e.isPresent()) {
				Incident currentIncident = e.get();
				
				String statut = Incident.getStatut();
				if(statut != null) {
					currentIncident.setStatut(statut);
				}
				
				IncidentService.saveIncident(currentIncident);
				return currentIncident;
			} else {
				return null;
			}
		}
	    
	    
	  //Modifier les informations d'un incident
	    @PutMapping("/ModifierIncident/{id}")
		public Incident updateIncident(@PathVariable("id") final Integer id, @RequestBody Incident Incident) {
			Optional<Incident> e = IncidentService.getIncident(id);
			if(e.isPresent()) {
				Incident currentIncident = e.get();
				
				String secteur = Incident.getSecteur();
				if(secteur != null) {
					currentIncident.setSecteur(secteur);
				}
				org.locationtech.jts.geom.Point position = Incident.getPosition();
				if(position != null) {
					currentIncident.setPosition(position);
				}
				String description = Incident.getDescription();
				if(description != null) {
					currentIncident.setDescription(description);
				}
				String statut = Incident.getStatut();
				if(statut != null) {
					currentIncident.setStatut(statut);
				}
				String type_incident = Incident.getType_incident();
				if(type_incident != null) {
					currentIncident.setType_incident(type_incident);
				}
				
				
				IncidentService.saveIncident(currentIncident);
				return currentIncident;
			} else {
				return null;
			}
		}
	    

}

