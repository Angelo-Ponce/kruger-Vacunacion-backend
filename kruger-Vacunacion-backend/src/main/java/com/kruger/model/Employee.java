package com.kruger.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmployee;
	
	@Column(nullable = false, length = 10)
	private String dni;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column(nullable = false, length = 50)
	private String lastName;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = true)
	private LocalDateTime dateOfBirth;
	
	@Column(nullable = true)
	private String address;
	
	@Column(nullable = true)
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "id_vaccine_status", nullable = true, foreignKey = @ForeignKey(name = "FK_em_va_status"))
    private VaccineStatus vaccineStatus;
	
	@OneToMany(mappedBy = "employee", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<VaccineEmployee> vaccineEmployee;

	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public VaccineStatus getVaccineStatus() {
		return vaccineStatus;
	}

	public void setVaccineStatus(VaccineStatus vaccineStatus) {
		this.vaccineStatus = vaccineStatus;
	}

	public List<VaccineEmployee> getVaccineEmployee() {
		return vaccineEmployee;
	}

	public void setVaccineEmployee(List<VaccineEmployee> vaccineEmployee) {
		this.vaccineEmployee = vaccineEmployee;
	}
	
}
