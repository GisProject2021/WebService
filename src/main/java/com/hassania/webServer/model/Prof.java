package com.hassania.webServer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

//Data
@Getter
@Setter
@Entity
@Table(name = "professionnel")
public class Prof implements Serializable{
	
private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nom")
    private String nom;
    
    @Column(name = "prenom")
    private String prenom;
    
    @Column(name = "secteur")
    private String secteur;
    
    @Column(name = "organisme")
    private String organisme;
    
    @Column(name = "telephone")
    private String telephone;
    
    @Column(name = "nom_utilisateur")
    private String nom_utilisateur;
    
    @Column(name = "mot_de_passe")
    private String mot_de_passe;
    


}
