package com.kruger.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class UserSystem {

	@Id
	private Integer idUserSystem;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_rol", joinColumns = @JoinColumn(name = "id_user_system", referencedColumnName = "idUserSystem"), inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol"))
	private List<Rol> rols;

	public Integer getIdUserSystem() {
		return idUserSystem;
	}

	public void setIdUserSystem(Integer idUserSystem) {
		this.idUserSystem = idUserSystem;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Rol> getRols() {
		return rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}
	
}
