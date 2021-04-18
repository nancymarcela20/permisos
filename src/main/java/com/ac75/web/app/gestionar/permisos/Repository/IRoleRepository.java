package com.ac75.web.app.gestionar.permisos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ac75.web.app.gestionar.permisos.domain.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

	Role findByNombre(String nombre);
	
	@Query("SELECT r FROM Role r WHERE r.estado = 1")
	List<Role> findAllRolesActive();
	
}
