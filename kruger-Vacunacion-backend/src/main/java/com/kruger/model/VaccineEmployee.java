package com.kruger.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VaccineEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVaccineEmployee;
	
	@ManyToOne
	@JoinColumn(name = "id_employee", nullable = false, foreignKey = @ForeignKey(name = "FK_VE_EMPLOYEE"))
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "id_vaccine_type", nullable = false, foreignKey = @ForeignKey(name = "FK_VE_VACCINETYPE"))
	private VaccineType vaccineType;
	
	@Column(nullable = false)
	private LocalDateTime vaccineDate;
	
	@Column(nullable = false)
	private Integer doseNumbers;

	
	public Integer getIdVaccineEmployee() {
		return idVaccineEmployee;
	}

	public void setIdVaccineEmployee(Integer idVaccineEmployee) {
		this.idVaccineEmployee = idVaccineEmployee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public VaccineType getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(VaccineType vaccineType) {
		this.vaccineType = vaccineType;
	}

	public LocalDateTime getVaccineDate() {
		return vaccineDate;
	}

	public void setVaccineDate(LocalDateTime vaccineDate) {
		this.vaccineDate = vaccineDate;
	}

	public Integer getDoseNumbers() {
		return doseNumbers;
	}

	public void setDoseNumbers(Integer doseNumbers) {
		this.doseNumbers = doseNumbers;
	}
	
}
