package com.kruger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "vaccinetype")
public class VaccineType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVaccineType;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "description", nullable = false, length = 150)
	private String description;
	
}
