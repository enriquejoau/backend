package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Asistencia;
import uc.us_security.repository.AsistenciaRepository;
import uc.us_security.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService{
	@Autowired
	private AsistenciaRepository asistenciarepository;

	@Override
	public Asistencia create(Asistencia asistencia) {
		// TODO Auto-generated method stub
		return asistenciarepository.save(asistencia);
	}

	@Override
	public List<Asistencia> readAll() {
		// TODO Auto-generated method stub
		return asistenciarepository.findAll();
	}

	@Override
	public Asistencia read(int id) {
		// TODO Auto-generated method stub
		return asistenciarepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		asistenciarepository.deleteById(id);
	}

	@Override
	public Asistencia update(Asistencia asistencia) {
		// TODO Auto-generated method stub
		return asistenciarepository.save(asistencia);
	}
}
