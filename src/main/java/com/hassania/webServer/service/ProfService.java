package com.hassania.webServer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hassania.webServer.model.Incident;
import com.hassania.webServer.model.Prof;
import com.hassania.webServer.repository.ProfRepository;


@Service
public class ProfService {

    @Autowired
    
    private ProfRepository ProfRepository;

    public Optional<Prof> getProf(final Integer id) {
        return ProfRepository.findById(id);
    }
    
    public Iterable<Prof> getProfsSecteur(final String secteur) {
        return ProfRepository.findBySecteur(secteur);
    }

    public Iterable<Prof> getProfs() {
        return ProfRepository.findAll();
    }

    public void deleteProf(final Integer id) {
    	ProfRepository.deleteById(id);
    }

    public Prof saveProf(Prof Prof) {
    	Prof savedProf = ProfRepository.save(Prof);
        return savedProf;
    }

}
