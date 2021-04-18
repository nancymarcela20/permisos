package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import com.ac75.web.app.gestionar.permisos.domain.Servidor;

public interface IServidorService {

	Servidor save(Servidor servidor) throws Exception;
	
	Servidor edit(Servidor servidor, Long id) throws Exception;
	
	Servidor getServidorById(Long id) throws Exception;
	
	List<Servidor> getAllServidores();
	
	List<Servidor> getAllActiveServidores();
	
	void delete(Long id) throws Exception;
	
}
