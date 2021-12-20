package uc.us_security.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.us_security.entity.Pedido_Oracion;
import uc.us_security.repository.Pedido_OracionRespository;
import uc.us_security.service.Spedido_oracion;


@Service
public class Pedido_OracionServiceImpl implements Spedido_oracion{
	
	@Autowired
	private Pedido_OracionRespository pediso_oracionrepository;
	
	@Override
	public Pedido_Oracion create(Pedido_Oracion al) {
		// TODO Auto-generated method stub
		return pediso_oracionrepository.save(al);
	}

	@Override
	public List<Pedido_Oracion> readAll() {
		// TODO Auto-generated method stub
		return pediso_oracionrepository.findAll();
	}

	@Override
	public Pedido_Oracion read(int id) {
		// TODO Auto-generated method stub
		return pediso_oracionrepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pediso_oracionrepository.deleteById(id);
	}

	@Override
	public Pedido_Oracion update(Pedido_Oracion al) {
		// TODO Auto-generated method stub
		return pediso_oracionrepository.save(al);
	}

	@Override
	public List<Map<String, Object>> SP_LISTA_COMENTARIO() {
		// TODO Auto-generated method stub
		return pediso_oracionrepository.SP_LISTA_COMENTARIO();
	}

}
