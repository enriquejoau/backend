package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.Seminario;

public interface SeminarioService {
	List<Seminario> readAll();
	Seminario create(Seminario seminario);
	Seminario update(Seminario seminario);
	Seminario read(int id);
	void delete(int id);
}
