package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import com.ac75.web.app.gestionar.permisos.domain.Role;

public interface IRoleService {

	Role save(Role role) throws Exception;
	
	Role edit(Role role, Long id) throws Exception;
	
	Role getRoleById(Long id) throws Exception;
	
	List<Role> getAllRoles();
	
	List<Role> getAllRolesActive();
	
	List<Role> getAllRolesSinAsignar(Long idPersona);
	
	void delete(Long id) throws Exception;
	
}
