package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Seminario;
import uc.us_security.repository.SeminarioRepository;
import uc.us_security.service.SeminarioService;

@Service
public class SeminarioServiceImpl implements SeminarioService {

	@Autowired
	private SeminarioRepository seminario;
	
	@Override
	public Seminario create(Seminario s) {
		// TODO Auto-generated method stub
		//return sr.insertarSeminario(s.getNombre(),s.getFecha_inicio(), s.getFecha_fin(), s.getUrl());
		
		return seminario.save(s);
	}

	@Override
	public List<Seminario> readAll() {
		// TODO Auto-generated method stub
		return seminario.findAll();
	}

	@Override
	public Seminario read(int id) {
		// TODO Auto-generated method stub
		//return sr.buscarSeminario(id_seminario);
		return seminario.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		//return sr.eliminarSeminario(id_seminario);
		seminario.deleteById(id);
	}

	@Override
	public Seminario update(Seminario s) {
		// TODO Auto-generated method stub
		//return sr.actualizarSeminario(s.getId_seminario(), s.getNombre(),s.getFecha_inicio(), s.getFecha_fin(), s.getUrl());
		return seminario.save(s);
	}
}


