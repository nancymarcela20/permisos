package com.ac75.web.app.gestionar.permisos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ac75.web.app.gestionar.permisos.domain.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{

	Persona findByCedula(String cedula);
	
}
