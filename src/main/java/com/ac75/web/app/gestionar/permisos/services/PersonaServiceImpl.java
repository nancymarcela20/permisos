package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac75.web.app.gestionar.permisos.Repository.IPersonaRepository;
import com.ac75.web.app.gestionar.permisos.domain.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private IPersonaRepository personaRepository;
	
	@Override
	public Persona registrarPersona(Persona p) {
				
		if(personaRepository.findByCedula(p.getCedula())==null){
			return null;
		}
		return personaRepository.save(p);
	}

	@Override
	public List<Persona> listarPersonas() {
				
		return personaRepository.findAll();
	}


	
}
