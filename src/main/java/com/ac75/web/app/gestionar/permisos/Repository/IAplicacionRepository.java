package com.ac75.web.app.gestionar.permisos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ac75.web.app.gestionar.permisos.domain.Aplicacion;

public interface IAplicacionRepository extends JpaRepository<Aplicacion, Long>{

	
	Aplicacion findByNombre(String nombre);
	
	@Query("SELECT a FROM Aplicacion a WHERE a.estado = 1")
	List<Aplicacion> findAllActiveAplicaciones();
	
}
