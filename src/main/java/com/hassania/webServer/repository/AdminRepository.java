package com.hassania.webServer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hassania.webServer.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
