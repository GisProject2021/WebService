package com.hassania.webServer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hassania.webServer.model.Incident;
import com.hassania.webServer.model.Prof;

@Repository
public interface ProfRepository extends CrudRepository<Prof, Integer> {
	
	public Iterable<Prof> findBySecteur(String secteur);

}
