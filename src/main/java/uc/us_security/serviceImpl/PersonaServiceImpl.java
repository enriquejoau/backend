package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Persona;
import uc.us_security.repository.PersonaRepository;
import uc.us_security.service.Spersona;



@Service
public class PersonaServiceImpl implements Spersona{
	@Autowired
	private PersonaRepository personarepository;

	@Override
	public Persona create(Persona al) {
		// TODO Auto-generated method stub
		return personarepository.save(al);
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return personarepository.findAll();
	}

	@Override
	public Persona read(int id) {
		// TODO Auto-generated method stub
		return personarepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		personarepository.deleteById(id);
	}

	@Override
	public Persona update(Persona al) {
		// TODO Auto-generated method stub
		return personarepository.save(al);
	}
	

}
