package com.ac75.web.app.gestionar.permisos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "servidores")
public class Servidor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8347349121873451537L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idServidor;
	
	@Column(length = 100)
	private String nombre;
	
	@Column(length = 100)
	private String ip;
	
	@Column(length = 12)
	private String puerto;
	
	private boolean estado;
	
	@OneToMany(mappedBy = "servidor") 	
	@JsonBackReference
	private List<Aplicacion> aplicaciones;	

	public Long getIdServidor() {
		return idServidor;
	}

	public void setIdServidor(Long idServidor) {
		this.idServidor = idServidor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public List<Aplicacion> getAplicaciones() {
		return aplicaciones;
	}

	public void setAplicaciones(List<Aplicacion> aplicaciones) {
		this.aplicaciones = aplicaciones;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
		
}
