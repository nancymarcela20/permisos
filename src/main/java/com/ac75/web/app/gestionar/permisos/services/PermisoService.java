package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ac75.web.app.gestionar.permisos.Repository.IPermisoRepository;
import com.ac75.web.app.gestionar.permisos.domain.Permiso;

@Service
public class PermisoService implements IPermisoService{

	private IPermisoRepository permisoRepository;
	
	@Override
	@Transactional
	public Permiso save(Permiso permiso) throws Exception {
		
		if(permisoRepository.findByTipoAndRutaFrontendAndRutaBackend(permiso.getTipo(), permiso.getRutaFrontend(), permiso.getRutaBackend())!=null) {
			throw new Exception("Ya existe un permiso registrado con el mismo tipo y url de Fronted y Backend");
		}
		
		this.validarCamposRequeridos(permiso);
		
		permiso.setEstado(true);
		
		return permisoRepository.save(permiso);
		
	}
	
	private void validarCamposRequeridos(Permiso permiso) throws Exception {
		
		if(permiso.getTipo()==null) {
			throw new Exception("El tipo es un dato requerido");
		}
		
		if(permiso.getDescripcion()==null) {
			throw new Exception("La descripción es un dato requerido");
		}
		
		if(permiso.getRutaBackend()==null) {
			throw new Exception("La ruta del BackEnd es un dato requerido");
		}
		
		if(permiso.getRutaFrontend()==null) {
			throw new Exception("La ruta del FrontEnd es un dato requerido");
		}
		
		if(permiso.getAplicacion()==null) {
			throw new Exception("El sistema requiere saber cual es la aplicación para la cual se va a crear el permiso");
		}
		
	}

	@Override
	public Permiso edit(Permiso permiso, Long id) throws Exception {
		
		this.validarCamposRequeridos(permiso);
		
		Permiso permisobd = permisoRepository.findById(id).get();
		
		if(permisobd==null) {
			throw new Exception("No existe en el sistema un permiso con ese identificador");
		}
		
		permiso.setIdPermiso(id);
		
		return permisoRepository.save(permiso);
		
	}

	@Override
	public Permiso getPermisoById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permiso> getAllPermisos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permiso> getAllPermisosActive() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
