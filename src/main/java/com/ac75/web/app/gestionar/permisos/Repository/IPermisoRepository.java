package com.ac75.web.app.gestionar.permisos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ac75.web.app.gestionar.permisos.domain.Permiso;

public interface IPermisoRepository extends JpaRepository<Permiso, Long>{
	
	Permiso findByTipoAndRutaFrontendAndRutaBackend(String tipo, String rutaFrontend, String rutaBackend);

}
