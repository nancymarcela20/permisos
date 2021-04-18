package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import com.ac75.web.app.gestionar.permisos.domain.Persona;

public interface IPersonaService {
	
	Persona registrarPersona(Persona p);
	
	List<Persona> listarPersonas();

}
