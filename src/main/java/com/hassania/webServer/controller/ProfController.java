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
import com.hassania.webServer.model.Prof;
import com.hassania.webServer.service.ProfService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class ProfController {
	
	 @Autowired
	    private ProfService ProfService;

	    //Afficher la liste des professionnels
	    @GetMapping("/Profs")
	    
	    public Iterable<Prof> getProfs() {
	        return ProfService.getProfs();
	    }
	    
	    
	    //Ajouter un professionel
	    @RequestMapping(value = "/AddProf", method = RequestMethod.POST)
		public Prof createProf(Prof Prof) {
			return ProfService.saveProf(Prof);
		}
	    
	    
	    //Modifier les informations d'un professionnel
	    @PutMapping("/ModifierProf/{id}")
		public Prof updateProf(@PathVariable("id") final Integer id, @RequestBody Prof Prof) {
			Optional<Prof> e = ProfService.getProf(id);
			if(e.isPresent()) {
				Prof currentProf = e.get();
				
				String nom = Prof.getNom();
				if(nom != null) {
					currentProf.setNom(nom);
				}
				String prenom = Prof.getPrenom();
				if(prenom != null) {
					currentProf.setPrenom(prenom);
				}
				String secteur = Prof.getSecteur();
				if(secteur != null) {
					currentProf.setSecteur(secteur);
				}
				String organisme = Prof.getOrganisme();
				if(organisme != null) {
					currentProf.setOrganisme(organisme);
				}
				String nom_utilisateur = Prof.getNom_utilisateur();
				if(nom_utilisateur != null) {
					currentProf.setNom_utilisateur(nom_utilisateur);
				}
				String mot_de_passe = Prof.getMot_de_passe();
				if(mot_de_passe != null) {
					currentProf.setMot_de_passe(mot_de_passe);;
				}
				ProfService.saveProf(currentProf);
				return currentProf;
			} else {
				return null;
			}
		}
	    
	    //Supprimer un professionnel
	    @DeleteMapping("/SupprimerProf/{id}")
		public void deleteProf(@PathVariable("id") final Integer id) {
			ProfService.deleteProf(id);
		}
	    
	    
	    //Trouver les proffessionnels par secteur
	    @RequestMapping(value = "/ProfSecteur/{secteur}", method = RequestMethod.GET)
	    public Iterable<Prof> getProfsSecteur(@PathVariable("secteur") final String secteur) {
	    	return ProfService.getProfsSecteur(secteur);
			
		}

}
