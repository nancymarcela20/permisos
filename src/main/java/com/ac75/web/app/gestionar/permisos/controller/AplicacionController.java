package com.ac75.web.app.gestionar.permisos.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ac75.web.app.gestionar.permisos.domain.Aplicacion;
import com.ac75.web.app.gestionar.permisos.services.IAplicacionService;

@RestController
@RequestMapping("/aplicacion")
public class AplicacionController {

	@Autowired
	private IAplicacionService aplicacionService;
	
	@PostMapping(path = "registrarAplicacion")
	public ResponseEntity<Object> saveAplicacion(@RequestBody Aplicacion aplicacion) {
		
		HashMap<String, Object> datos = new HashMap<>();

		try {
			Aplicacion newAplicacion = aplicacionService.save(aplicacion);
			datos.put("Msj", "La aplicación fue creada correctamente");
			datos.put("status", "sucess");
			datos.put("aplicacion", newAplicacion);
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

	}
	
	@PutMapping(path = "editarAplicacion/{id}")
	public ResponseEntity<Object> editAplicacion(@RequestBody Aplicacion aplicacion, @PathVariable Long id){
		
		HashMap<String, Object> datos= new HashMap<>();

		try {
			datos.put("aplicacion", aplicacionService.edit(aplicacion, id));
			datos.put("Msj", "La aplicación fue actualizada correctamente");
			datos.put("Status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);			
		}
		
	}
	
	@GetMapping("getAplicacionById/{id}")
	public ResponseEntity<Object> getAplicacionById(@PathVariable Long id){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			Aplicacion aplicacion = aplicacionService.getAplicacionById(id);
			datos.put("aplicacion", aplicacion);
			datos.put("status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No existe una aplicación registrada con ese identificador", e);
		}
		
	}
	
	@GetMapping(path = "obtenerAplicaciones")
	public ResponseEntity<Object> getAllAplicaciones(HttpServletRequest httpServletRequest){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			  List<Aplicacion> aplicaciones = aplicacionService.getAllAplicaciones();
			  datos.put("Aplicaciones", aplicaciones); 
			  datos.put("Msj", "Lista de aplicaciones"); 
			  datos.put("Status", "sucess"); 
			  
			  return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, pérdida de conexión", e);
		}
		
	}
	
	
	@GetMapping("listarAplicacionesActivas")
	public ResponseEntity<Object> getAllActiveAplicaciones(){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			  List<Aplicacion> aplicacionesActivas = aplicacionService.getAllActiveAplicaciones();
			  datos.put("Aplicaciones Activas", aplicacionesActivas); 
			  datos.put("Msj", "Lista de aplicaciones activas"); 
			  datos.put("Status", "sucess"); 
			  
			  return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, pérdida de conexión", e);
		}
	}
	
	@DeleteMapping("eliminarAplicacion/{id}")
	public ResponseEntity<Object> deleteAplicacion(@PathVariable Long id){
		HashMap<String, Object> datos= new HashMap<>();
		try {
			aplicacionService.delete(id);
			datos.put("Msj", "Se ha eliminado la aplicación con el identificador "+ id);
			datos.put("Status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
				
	}
	
	
	
}
