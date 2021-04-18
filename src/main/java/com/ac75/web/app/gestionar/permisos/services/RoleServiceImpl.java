package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac75.web.app.gestionar.permisos.Repository.IRoleRepository;
import com.ac75.web.app.gestionar.permisos.domain.Role;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleRepository roleRepository;	
	
	@Override
	public Role save(Role role) throws Exception {
		
		if(roleRepository.findByNombre(role.getNombre())!=null) {
			throw new Exception("Ya existe un rol creado con ese nombre");
		}
		
		role.setEstado(true);
		
		return roleRepository.save(role);
	}

	@Override
	public Role edit(Role role, Long id) throws Exception {
		
		Role rolebd = roleRepository.findById(id).get();
		
		if(rolebd==null) {
			throw new Exception("No existe un rol registrado con ese identificador");
		}
		
		rolebd.setNombre(role.getNombre());
		rolebd.setDescripcion(role.getDescripcion());
		rolebd.setEstado(role.isEstado());
		
		return roleRepository.save(rolebd);
	}

	@Override
	public Role getRoleById(Long id) throws Exception {
		
		Role role = roleRepository.findById(id).get();
		
		if(role==null) {
			throw new Exception("No existe un rol registrado con este identificador");
		}
				
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		
		return roleRepository.findAll();
	}

	@Override
	public List<Role> getAllRolesActive() {
	
		return roleRepository.findAllRolesActive();
	}

	@Override
	public void delete(Long id) throws Exception {
		
		Role role = roleRepository.findById(id).get();
		
		if(role==null) {
			throw new Exception("No existe un rol registrado con ese identificador");
		}
		
		roleRepository.delete(role);
		
	}

	@Override
	public List<Role> getAllRolesSinAsignar(Long idPersona) {
		return roleRepository.findAllRolesSinAsignar(idPersona);
	}

	
	
}
