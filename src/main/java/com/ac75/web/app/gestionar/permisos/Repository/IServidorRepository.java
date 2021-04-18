package com.ac75.web.app.gestionar.permisos.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ac75.web.app.gestionar.permisos.domain.Servidor;

public interface IServidorRepository extends JpaRepository<Servidor, Long>{

	//@Query("SELECT s FROM Servidor s WHERE s.ip=?1 and s.puerto=?2")
	Servidor findByIpAndPuerto(String ip, String puerto);
	
	@Query("SELECT s FROM Servidor s WHERE s.estado=1")
    List<Servidor> findAllActiveServidores();
	
}
