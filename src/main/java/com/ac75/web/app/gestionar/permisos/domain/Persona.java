package com.ac75.web.app.gestionar.permisos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="persona")
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4244233412165159382L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	private String nombre;
	
	@Column(unique = true, nullable = false, length = 12)
	private String cedula;
	
	@Column(name = "codigoacopio", length = 10)
	private String codigoAcopio;
	
	@Column(name = "nombreacopio", length = 100)
	private String nombreAcopio;
		
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name="persona_roles", joinColumns = @JoinColumn(name="persona_id"), 
	inverseJoinColumns = @JoinColumn(name="role_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"persona_id", "role_id"})})
	private List<Role> roles;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name="persona_manuales", joinColumns = @JoinColumn(name="persona_id"), 
	inverseJoinColumns = @JoinColumn(name="manual_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"persona_id", "manual_id"})})
	private List<Role> manuales;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
	@JoinTable(name="persona_departamentos", joinColumns = @JoinColumn(name="persona_id"), 
	inverseJoinColumns = @JoinColumn(name="departamento_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames = {"persona_id", "departamento_id"})})
	private List<Departamento> departamentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigoAcopio() {
		return codigoAcopio;
	}

	public void setCodigoAcopio(String codigoAcopio) {
		this.codigoAcopio = codigoAcopio;
	}

	public String getNombreAcopio() {
		return nombreAcopio;
	}

	public void setNombreAcopio(String nombreAcopio) {
		this.nombreAcopio = nombreAcopio;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Role> getManuales() {
		return manuales;
	}

	public void setManuales(List<Role> manuales) {
		this.manuales = manuales;
	}

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	

}
