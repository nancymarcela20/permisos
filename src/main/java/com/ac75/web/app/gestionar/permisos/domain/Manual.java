package com.ac75.web.app.gestionar.permisos.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="manuales")
public class Manual implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5976908612033612677L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idManual;
	
	@Column(name="nombre", unique = true, nullable = false, length = 100)
	private String nombre;
	
	@Column(name="descripcion", length = 200)	
	private String descripcion;
	
	@Column(name="tipoinformacion", nullable = false, length = 30)
	private String tipoInformacion;
	
	@Column(name="fecharegistro", nullable = false)
	private Date fechaRegistro;
	
	@Column(name="fechaactualizacion", nullable = false)
	private Date fechaActualizacion;
	
	@Column(name = "estado")
	private boolean estado;
	
	@Column(name="urlimagen", nullable = false, length = 100)
	private String urlImagen;
	
	@Column(name="urlarchivo", nullable = false, length = 100)
	private String urlArchivo;
	
	@Column(name="urlvideo", length = 100)
	private String urlVideo;
	
	@ManyToOne	  
	@JoinColumn(name = "FK_CLASIFICACION", nullable = false, updatable = true)	
	private Clasificacion clasificacion;
		
	public Long getIdManual() {
		return idManual;
	}

	public void setIdManual(Long idManual) {
		this.idManual = idManual;
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

	public String getTipoInformacion() {
		return tipoInformacion;
	}

	public void setTipoInformacion(String tipoInformacion) {
		this.tipoInformacion = tipoInformacion;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getUrlArchivo() {
		return urlArchivo;
	}

	public void setUrlArchivo(String urlArchivo) {
		this.urlArchivo = urlArchivo;
	}

	public String getUrlVideo() {
		return urlVideo;
	}

	public void setUrlVideo(String urlVideo) {
		this.urlVideo = urlVideo;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	
}
