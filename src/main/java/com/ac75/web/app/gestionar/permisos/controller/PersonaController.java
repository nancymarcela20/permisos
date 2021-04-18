package com.ac75.web.app.gestionar.permisos.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ac75.web.app.gestionar.permisos.domain.Persona;
import com.ac75.web.app.gestionar.permisos.services.IPersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private IPersonaService personaService;
	
	@PostMapping(path = "registrarPersona")
	public Persona registrarPersona(@RequestBody Persona p){
		
		return personaService.registrarPersona(p);
		
	}
	
	@GetMapping(path = "obtenerPersonas")
	public ResponseEntity<Object> getAllPersonas(HttpServletRequest httpServletRequest){
		
		HashMap<String, Object> datos = new HashMap<>();
		try {
			List<Persona> personas = personaService.listarPersonas();
			datos.put("msj", "Lista de Usuarios");
			datos.put("status", "sucess");
			datos.put("Personas", personas);
			return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Conexión fallida", e);
		}
		
	}
	
	 
	
	
}
