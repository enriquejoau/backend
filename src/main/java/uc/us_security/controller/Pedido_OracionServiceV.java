package uc.us_security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uc.us_security.entity.Pedido_Oracion;
import uc.us_security.serviceImpl.Pedido_OracionServiceImpl;


@RestController
@RequestMapping("/oracion")
public class Pedido_OracionServiceV {
	@Autowired
	private Pedido_OracionServiceImpl pedidooracionseviceimpl;
	
	@PostMapping("/create")
	public ResponseEntity<Pedido_Oracion> save(@RequestBody Pedido_Oracion alum){
		try {
			Pedido_Oracion al = pedidooracionseviceimpl.create(alum);
			
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//----------------------------------------------------------------------------------------
		@GetMapping("/listado")
		public ResponseEntity<List<Pedido_Oracion>> getAlumnos(){
			try {
				List<Pedido_Oracion> list = new ArrayList<>();
				list = pedidooracionseviceimpl.readAll();
				if(list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list, HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		@GetMapping("/todo")
		public ResponseEntity<List<Map<String, Object>> > SP_LISTA_COMENTARIO(){
			try {
				 List<Map<String, Object>> list = new ArrayList<>();
				list = pedidooracionseviceimpl.SP_LISTA_COMENTARIO();
				if(list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list, HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//---------------------------------------------------------------------------------------------
		@PutMapping("/update/{id}")
		public ResponseEntity<Pedido_Oracion> update(@RequestBody Pedido_Oracion alum, @PathVariable("id") int id){
			try {
				Pedido_Oracion ul = pedidooracionseviceimpl.read(id);
				if(ul.getId_pedido()>0) {
					ul.setF_pedido(alum.getF_pedido());
					ul.setEstado(alum.getEstado());
					ul.setF_respuesta(alum.getF_respuesta());
					ul.setOracion(alum.getOracion());
					ul.setRespuesta(alum.getRespuesta());
					
					return new ResponseEntity<>(pedidooracionseviceimpl.create(ul),HttpStatus.OK);
				}else {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}			

			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		//---------------------------------------------------------------------------------
		@DeleteMapping("delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
			try {
				pedidooracionseviceimpl.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
	
	

}
