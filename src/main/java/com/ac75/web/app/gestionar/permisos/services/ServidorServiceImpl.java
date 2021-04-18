package com.ac75.web.app.gestionar.permisos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ac75.web.app.gestionar.permisos.Repository.IServidorRepository;
import com.ac75.web.app.gestionar.permisos.domain.Aplicacion;
import com.ac75.web.app.gestionar.permisos.domain.Servidor;

@Service
public class ServidorServiceImpl implements IServidorService{

	@Autowired
	private IServidorRepository servidorRepository;
	
	@Override
	@Transactional
	public Servidor save(Servidor servidor) throws Exception {
		
		if(servidorRepository.findByIpAndPuerto(servidor.getIp(), servidor.getPuerto())!=null) {
			throw new Exception("Ya existe un servidor registrado con la misma ip y puerto");
		}
		
		servidor.setEstado(true);
		
		return servidorRepository.save(servidor);
	}

	@Override
	@Transactional
	public Servidor edit(Servidor servidor, Long id) throws Exception {
		
		Servidor servidorbd = servidorRepository.findById(id).get();
		
		if(servidorbd==null) {
			throw new Exception("El servidor con esa identificación no se encuentra registrado en el sistema");
		}
		
		
		if(!servidor.isEstado()&&servidorbd.getAplicaciones().size()>0) {
			throw new Exception("No se puede deshabilitar porque tiene aplicaciones asociadas: "+ this.listarAplicacionesAsociadas(servidorbd.getAplicaciones()));
		}
		
		servidor.setIdServidor(servidorbd.getIdServidor());
		
		return servidorRepository.save(servidor);
	}
	
	private String listarAplicacionesAsociadas(List<Aplicacion> aplicaciones) {
		
		String nombres = " ";
		
		int c=aplicaciones.size();
		
		for(Aplicacion a: aplicaciones) {
			
			if(c==1) {
				nombres+=a.getNombre();
			}else {
				nombres+=a.getNombre()+",";
			}
			
			c--;
		}
		
		return nombres;
	}

	@Override
	public Servidor getServidorById(Long id) throws Exception {
		Servidor servidor = servidorRepository.findById(id).get();
		
		if(servidor == null) {
			throw new Exception("No existe un servidor registrado con ese identificador en el sistema");
		}
		
		return servidor;
	}

	@Override
	public List<Servidor> getAllServidores() {
		return servidorRepository.findAll();
	}

	@Override
	public void delete(Long id) throws Exception {
		
		Servidor servidor = servidorRepository.findById(id).get();
		
		if(servidor==null) {
			throw new Exception("El servidor con ese identificador no se encuentra en el sistema");
		}
		
		if(servidor.getAplicaciones().size()>0) {
			throw new Exception("El servidor no se puede eliminar porque tiene aplicaciones asociadas: "+
			this.listarAplicacionesAsociadas(servidor.getAplicaciones()));
		}
		
		servidorRepository.delete(servidor);
		
	}

	@Override
	public List<Servidor> getAllActiveServidores() {
		return servidorRepository.findAllActiveServidores();
	}

	
	
}
