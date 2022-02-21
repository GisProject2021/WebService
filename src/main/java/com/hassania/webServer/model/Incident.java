package com.hassania.webServer.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.locationtech.jts.geom.Point;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
@Table(name = "incident")

public class Incident implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;

    @Column(name = "secteur")
    private String secteur ;

    //, columnDefinition = "geometry(Point,4326)"
    @Column(name = "geom")
    private Point position;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "statut")
    private String statut;
    
    
    
    @Column(name = "date_declaration")
    private Date date_declaration;
    
    @Column(name = "type_incident")
    private String type_incident;
    
    @Column(name = "declarant")
    private String declarant;
    
    //@Column(name = "img")
    //private Byte img;
    
    

}
