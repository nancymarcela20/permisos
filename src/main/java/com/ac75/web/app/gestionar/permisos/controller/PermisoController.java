package com.ac75.web.app.gestionar.permisos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ac75.web.app.gestionar.permisos.domain.Permiso;
import com.ac75.web.app.gestionar.permisos.services.IPermisoService;

@RestController
@RequestMapping("/permiso")
public class PermisoController {

	@Autowired
	private IPermisoService permisoService;
	
	@PostMapping(path = "registrarPermiso")
	public ResponseEntity<Object> savePermiso(@RequestBody Permiso permiso) {
		
		HashMap<String, Object> datos = new HashMap<>();

		try {
			Permiso newPermiso = permisoService.save(permiso);
			datos.put("Msj", "El permiso fue creado correctamente");
			datos.put("status", "sucess");
			datos.put("permiso", newPermiso);
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

	}
	
	@PutMapping(path = "editarPermiso/{id}")
	public ResponseEntity<Object> editPermiso(@RequestBody Permiso permiso, @PathVariable Long id){
		
		HashMap<String, Object> datos= new HashMap<>();

		try {
			datos.put("permiso", permisoService.edit(permiso, id));
			datos.put("Msj", "El permiso fue actualizado correctamente");
			datos.put("Status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);			
		}
		
	}
	
	
}
