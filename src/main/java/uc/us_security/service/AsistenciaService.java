package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.Asistencia;

public interface AsistenciaService {
	List<Asistencia> readAll();
	Asistencia create(Asistencia asistencia);
	Asistencia update(Asistencia asistencia);
	Asistencia read(int id);
	void delete(int id);
}
