package com.aeropuerto.vuelos.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.aeropuerto.vuelos.model.dto.Vuelo_DTO;
import com.aeropuerto.vuelos.service.IVueloService;

@RestController
public class Controller {

	@Autowired
	private IVueloService vueloService;
	
	@GetMapping("/vuelos")
	public ResponseEntity<List<Vuelo_DTO>> getAllVuelos(){
		return new ResponseEntity<List<Vuelo_DTO>>(vueloService.getAllVuelos(), HttpStatus.OK);
	}
	
	@GetMapping("/vuelo/{id}")
	public ResponseEntity<Vuelo_DTO> getVuelo(@PathVariable("id") int id){
		return new ResponseEntity<Vuelo_DTO>(vueloService.findVueloById(id), HttpStatus.OK);
	}
	
	@PostMapping("/vuelo")
	public ResponseEntity<Vuelo_DTO> postVuelo(@RequestBody Vuelo_DTO vuelo_dto){
		return new ResponseEntity<Vuelo_DTO>(vueloService.saveVuelo(vuelo_dto), HttpStatus.CREATED);
	}
	
	@PutMapping("/vuelo")
	public ResponseEntity<Vuelo_DTO> putVuelo(@RequestBody Vuelo_DTO vuelo_dto){
		return new ResponseEntity<Vuelo_DTO>(vueloService.saveVuelo(vuelo_dto), HttpStatus.OK);
	}
	
	@DeleteMapping("/vuelo/{id}")
	public ResponseEntity deleteVuelo(@PathVariable("id") int id){
		vueloService.deleteVuelo(id);
		return new ResponseEntity(HttpStatus.OK);
	}
	
}
