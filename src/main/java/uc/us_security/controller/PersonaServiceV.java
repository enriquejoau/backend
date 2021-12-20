package uc.us_security.controller;

import java.util.ArrayList;
import java.util.List;

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

import uc.us_security.entity.Persona;
import uc.us_security.serviceImpl.PersonaServiceImpl;



@RestController
@RequestMapping("/persona")
public class PersonaServiceV {
	
	@Autowired
	private  PersonaServiceImpl personaserviceimpl;
	@PostMapping("/create")
	public ResponseEntity<Persona> save(@RequestBody Persona alum){
		try {
			Persona al = personaserviceimpl.create(alum);
			
			return new ResponseEntity<>(al, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//----------------------------------------------------------------------------------------
		@GetMapping("/listar")
		public ResponseEntity<List<Persona>> getAlumnos(){
			try {
				List<Persona> list = new ArrayList<>();
				list = personaserviceimpl.readAll();
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
		public ResponseEntity<Persona> update(@RequestBody Persona alum, @PathVariable("id") int id){
			try {
				Persona ul = personaserviceimpl.read(id);
				if(ul.getIdpersona()>0) {
					ul.setCorreo(alum.getCorreo());
					ul.setDni(alum.getDni());
					ul.setEstado(alum.getEstado());
					ul.setM_apellidos(alum.getM_apellidos());
					ul.setNombre(alum.getNombre());
					ul.setP_apellidos(alum.getP_apellidos());
					ul.setTelefono(alum.getTelefono());
					return new ResponseEntity<>(personaserviceimpl.create(ul),HttpStatus.OK);
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
				personaserviceimpl.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		
		

}
