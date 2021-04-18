package com.ac75.web.app.gestionar.permisos.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="permisos")
public class Permiso implements Serializable, Comparable<Permiso>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1381296891384660697L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idPermiso;	
	
	@Column(length = 10, nullable = false)
	private String tipo;
	
	@Column(length = 200, nullable = false)
	private String descripcion;
	
	@Column(name="rutafrontend", length = 500, nullable = false)
	private String rutaFrontend;
	
	@Column(name="rutabackend", length = 500, nullable = false)
	private String rutaBackend;
			
	private boolean estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_APLICACION", nullable = false, updatable = true)	
	private Aplicacion aplicacion;

	
	public Long getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Long idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRutaFrontend() {
		return rutaFrontend;
	}

	public void setRutaFrontend(String rutaFrontend) {
		this.rutaFrontend = rutaFrontend;
	}

	public String getRutaBackend() {
		return rutaBackend;
	}

	public void setRutaBackend(String rutaBackend) {
		this.rutaBackend = rutaBackend;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}


	@Override
	public int compareTo(Permiso o) {
		
		int resultado = 0;
		
		if(this.aplicacion.getIdAplicacion() < o.getAplicacion().getIdAplicacion())
			resultado = -1;
		else if(this.aplicacion.getIdAplicacion() > o.getAplicacion().getIdAplicacion())
			resultado = 1;
		
		return resultado;
	}
		
	
	
}
