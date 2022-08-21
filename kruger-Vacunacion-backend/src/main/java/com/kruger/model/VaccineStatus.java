package com.kruger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vaccinestatus")
public class VaccineStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVaccineStatus;
	
	@Column(name = "description", nullable = false, length = 150, unique = true)
	private String description;
	

	public Integer getIdVaccineStatus() {
		return idVaccineStatus;
	}

	public void setIdVaccineStatus(Integer idVaccineStatus) {
		this.idVaccineStatus = idVaccineStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
