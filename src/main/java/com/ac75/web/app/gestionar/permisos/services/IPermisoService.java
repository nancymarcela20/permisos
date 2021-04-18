package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import com.ac75.web.app.gestionar.permisos.domain.Permiso;

public interface IPermisoService {

	Permiso save(Permiso permiso) throws Exception;
	
	Permiso edit(Permiso permiso, Long id) throws Exception;
	
	Permiso getPermisoById(Long id);
	
	List<Permiso> getAllPermisos();
	
	List<Permiso> getAllPermisosActive();
	
	void delete(Long id);	
	
}
