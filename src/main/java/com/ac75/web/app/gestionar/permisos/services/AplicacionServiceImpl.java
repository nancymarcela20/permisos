package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ac75.web.app.gestionar.permisos.Repository.IAplicacionRepository;
import com.ac75.web.app.gestionar.permisos.domain.Aplicacion;

@Service
public class AplicacionServiceImpl implements IAplicacionService{

	@Autowired
	private IAplicacionRepository aplicacionRepository;
	
	@Override
	public Aplicacion save(Aplicacion aplicacion) throws Exception {
		
		if(aplicacion.getNombre()==null) {
			throw new Exception("El nombre de la aplicación es requerido");
		}
		
		if(aplicacionRepository.findByNombre(aplicacion.getNombre())!=null) {
			throw new Exception("Ya existe una aplicación registrada con ese nombre");
		}
		
		aplicacion.setEstado(true);
		
		return aplicacionRepository.save(aplicacion);
	}

	@Override
	public Aplicacion edit(Aplicacion aplicacion, Long id) throws Exception {
		
		if(aplicacion.getNombre()==null) {
			throw new Exception("El nombre de la aplicación es requerido");
		}
						
		Aplicacion aplicacionbd = aplicacionRepository.findById(id).get();
		
		if(aplicacionbd==null) {
			throw new Exception("No existe una aplicación en el sistema registrada con ese identificador");
		}
		
		aplicacion.setIdAplicacion(id);
		
				
		return aplicacionRepository.save(aplicacion);
	}
	

	@Override
	public List<Aplicacion> getAllAplicaciones() {
			
		return aplicacionRepository.findAll();
	}

	@Override
	public Aplicacion getAplicacionById(Long id) throws Exception {
		
		Aplicacion aplicacion = aplicacionRepository.findById(id).get();
		
		if(aplicacion==null) {
			throw new Exception("No existe una aplicación con este identificador");
		}
		
		return aplicacion;
	}

	@Override
	public List<Aplicacion> getAllActiveAplicaciones() {
		
		return aplicacionRepository.findAllActiveAplicaciones();
	}

	@Override
	public void delete(Long id) throws Exception {
		
		Aplicacion aplicacion = aplicacionRepository.findById(id).get();
		
		if(aplicacion==null) {
			throw new Exception("La aplicación con ese identificador no existe en el sistema");
		}
		
		aplicacionRepository.delete(aplicacion);
		
	}
	
	

	
	
}
