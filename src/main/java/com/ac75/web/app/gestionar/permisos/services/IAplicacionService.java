package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import com.ac75.web.app.gestionar.permisos.domain.Aplicacion;

public interface IAplicacionService {

	Aplicacion save(Aplicacion aplicacion) throws Exception;
	
	Aplicacion edit(Aplicacion aplicacion, Long id) throws Exception;
	
	List<Aplicacion> getAllAplicaciones();
	
	Aplicacion getAplicacionById(Long id) throws Exception;

	List<Aplicacion> getAllActiveAplicaciones();
	
	void delete(Long id) throws Exception;
	
}
