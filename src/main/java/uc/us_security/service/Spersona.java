package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.Persona;





public interface Spersona {
	Persona create(Persona al);
	List<Persona> readAll();
	Persona read(int id);
	void delete(int id);
	Persona update(Persona al);
}
