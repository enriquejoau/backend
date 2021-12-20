package uc.us_security.service;

import java.util.List;

import uc.us_security.entity.Beneficiario;




public interface Sbeneficiario {
	Beneficiario create(Beneficiario al);
	List<Beneficiario> readAll();
	Beneficiario read(int id);
	void delete(int id);
	Beneficiario update(Beneficiario al);
}
