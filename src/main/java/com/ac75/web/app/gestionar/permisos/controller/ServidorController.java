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

import com.ac75.web.app.gestionar.permisos.domain.Servidor;
import com.ac75.web.app.gestionar.permisos.services.IServidorService;

@RestController
@RequestMapping("/servidor")
public class ServidorController {

	@Autowired
	private IServidorService servidorService;
	
	@PostMapping(path = "registrarServidor")
	public ResponseEntity<Object> saveServidor(@RequestBody Servidor servidor) {
		
		HashMap<String, Object> datos = new HashMap<>();

		try {
			Servidor newServidor = servidorService.save(servidor);
			datos.put("Msj", "El servidor fue creado correctamente");
			datos.put("status", "sucess");
			datos.put("servidor", newServidor);
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

	}
	
	@PutMapping(path = "editarServidor/{id}")
	public ResponseEntity<Object> editServidor(@RequestBody Servidor servidor, @PathVariable Long id){
		
		HashMap<String, Object> datos= new HashMap<>();

		try {
			datos.put("servidor", servidorService.edit(servidor, id));
			datos.put("Msj", "El servidor fue actualizado correctamente");
			datos.put("Status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);			
		}
		
	}
	
	@GetMapping("getServidorById/{id}")
	public ResponseEntity<Object> getRoleById(@PathVariable Long id){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			Servidor servidor = servidorService.getServidorById(id);
			datos.put("servidor", servidor);
			datos.put("status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		
	}
	
	@GetMapping(path = "obtenerServidores")
	public ResponseEntity<Object> getAllServidores(HttpServletRequest httpServletRequest){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			  List<Servidor> servidores = servidorService.getAllServidores();
			  datos.put("Servidores", servidores); 
			  datos.put("Msj", "Lista de servidores"); 
			  datos.put("Status", "sucess"); 
			  
			  return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, pérdida de conexión", e);
		}
		
	}
	
	@GetMapping("listarServidoresActivos")
	public ResponseEntity<Object> getAllActiveServidores(){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			  List<Servidor> servidoresActivos = servidorService.getAllActiveServidores();
			  datos.put("Servidores Activos", servidoresActivos); 
			  datos.put("Msj", "Lista de servidores activos"); 
			  datos.put("Status", "sucess"); 
			  
			  return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, pérdida de conexión", e);
		}
	}
	
	@DeleteMapping("eliminarServidor/{id}")
	public ResponseEntity<Object> deleteServidor(@PathVariable Long id){
		HashMap<String, Object> datos= new HashMap<>();
		try {
			servidorService.delete(id);
			datos.put("Msj", "Se ha eliminado el servidor con identificador "+ id);
			datos.put("Status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
				
	}
	
}
