package com.ac75.web.app.gestionar.permisos.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="aplicaciones")
public class Aplicacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -647927326911097813L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idAplicacion;
	
	@Column(unique = true , nullable = false, length = 100)
	private String nombre;
	
	@Column(length = 200)
	private String descripcion;
	
	@Column(length = 100)
	private String ruta;
	
	@Column(length = 6)
	private String puerto;
	
	private boolean estado;
	
	@ManyToOne()
	@JoinColumn(name = "FK_SERVIDOR", nullable = false, updatable = true)		
	private Servidor servidor;
	
	@OneToMany(mappedBy = "aplicacion", cascade = CascadeType.ALL) 	
	@JsonBackReference
	private List<Permiso> permisos;

	public Long getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Long idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
}
