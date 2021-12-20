package uc.us_security.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Rol;
import uc.us_security.repository.RolRepository;
import uc.us_security.service.RolService;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolrepository;
	
	@Override
	public Rol create(Rol rol) {
		// TODO Auto-generated method stub
		return rolrepository.save(rol);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolrepository.findAll();
	}

	@Override
	public Rol read(int id) {
		// TODO Auto-generated method stub
		return rolrepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rolrepository.deleteById(id);
	}

	@Override
	public Rol update(Rol rol) {
		// TODO Auto-generated method stub
		return rolrepository.save(rol);
	}
}
