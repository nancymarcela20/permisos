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

import com.ac75.web.app.gestionar.permisos.domain.Role;
import com.ac75.web.app.gestionar.permisos.services.IRoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@PostMapping(path = "registrarRole")
	public ResponseEntity<Object> saveRole(@RequestBody Role role) {
		
		HashMap<String, Object> datos = new HashMap<>();

		try {
			Role newRole = roleService.save(role);
			datos.put("Msj", "El rol fue creado correctamente");
			datos.put("status", "sucess");
			datos.put("role", newRole);
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}

	}
	
	@PutMapping(path = "editarRole/{id}")
	public ResponseEntity<Object> editRole(@RequestBody Role role, @PathVariable Long id){
		
		HashMap<String, Object> datos= new HashMap<>();

		try {
			datos.put("role", roleService.edit(role, id));
			datos.put("Msj", "El rol fue actualizado correctamente");
			datos.put("Status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.CREATED);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);			
		}
		
	}
	
	@GetMapping("getRoleById/{id}")
	public ResponseEntity<Object> getRoleById(@PathVariable Long id){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			Role role = roleService.getRoleById(id);
			datos.put("role", role);
			datos.put("status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No existe un rol registrado con ese identificador", e);
		}
		
	}
	
	@GetMapping(path = "obtenerRoles")
	public ResponseEntity<Object> getAllRoles(HttpServletRequest httpServletRequest){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			  List<Role> roles = roleService.getAllRoles();
			  datos.put("Roles", roles); 
			  datos.put("Msj", "Lista de roles"); 
			  datos.put("Status", "sucess"); 
			  
			  return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, pérdida de conexión", e);
		}
		
	}
	
	@GetMapping("listarRolesActivos")
	public ResponseEntity<Object> getAllActiveRoles(){
		
		HashMap<String, Object> datos= new HashMap<>();
		
		try {
			  List<Role> rolesActivos = roleService.getAllRolesActive();
			  datos.put("Roles Activos", rolesActivos); 
			  datos.put("Msj", "Lista de roles activos"); 
			  datos.put("Status", "sucess"); 
			  
			  return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error, pérdida de conexión", e);
		}
	}	
	
	@DeleteMapping("eliminarRole/{id}")
	public ResponseEntity<Object> deleteRole(@PathVariable Long id){
		HashMap<String, Object> datos= new HashMap<>();
		try {
			roleService.delete(id);
			datos.put("Msj", "Se ha eliminado el role con el identificador "+ id);
			datos.put("Status", "sucess");
			return new ResponseEntity<>(datos, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
				
	}
	
}
