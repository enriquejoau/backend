package uc.us_security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uc.us_security.entity.Seminario;
import uc.us_security.serviceImpl.SeminarioServiceImpl;

@RestController
@RequestMapping("/api/seminario")
public class SeminarioController {
	@Autowired
	private SeminarioServiceImpl seminarioservice;
	
	//Funciona
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/all")
		public ResponseEntity<List<Seminario>> getSeminario(){
			try {
				List<Seminario> list = new ArrayList<>();
				list=seminarioservice.readAll();
				if (list.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				return new ResponseEntity<>(list,HttpStatus.OK);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/search/{id}")
		public ResponseEntity<Seminario> getSeminario(@PathVariable("id") int id){
			Seminario s = seminarioservice.read(id);
			if (s.getId_seminario()>0) {
				return new ResponseEntity<>(s,HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}
		
		//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/post")
	public ResponseEntity<Seminario> save(@RequestBody Seminario rec) {
		try {
			Seminario r = seminarioservice.create(rec);
			return new ResponseEntity<>(r, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		
		//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			seminarioservice.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		}
		
		//Funciona
	@CrossOrigin(origins = "http://localhost:4200")
		@PutMapping("/update/{id}")
		public ResponseEntity<Seminario> update(@RequestBody Seminario rec, @PathVariable("id") int id){
		try {
			Seminario ul = seminarioservice.read(id);
			if (ul.getId_seminario()>0) {
				ul.setNombre(rec.getNombre());
				ul.setUrl(rec.getUrl());
				ul.setFecha_fin(rec.getFecha_fin());
				ul.setFecha_inicio(rec.getFecha_inicio());
				return new ResponseEntity<>(seminarioservice.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		}
}
