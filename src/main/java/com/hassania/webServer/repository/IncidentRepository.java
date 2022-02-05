package com.hassania.webServer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hassania.webServer.model.Incident;

@Repository
public interface IncidentRepository extends CrudRepository<Incident, Integer> {
	
	public Iterable<Incident> findByDeclarant(String declarant);

}
