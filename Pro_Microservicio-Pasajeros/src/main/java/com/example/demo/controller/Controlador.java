package com.example.demo.controller;

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

import com.example.demo.interfaces.IPasajero;
import com.example.demo.model.Pasajero_DTO;

@RestController
@RequestMapping("/api")
public class Controlador {

	@Autowired
	IPasajero ipasajeros;

	@GetMapping("/listar_pasajeros")
	public ResponseEntity<List<Pasajero_DTO>> get_listar_pasajeros() {
		return new ResponseEntity<List<Pasajero_DTO>>(ipasajeros.getAllPasajeros(), HttpStatus.OK);
	}

	@GetMapping("/obtener_pasajero/{id}")
	public ResponseEntity<Pasajero_DTO> get_pasajero(@PathVariable("id") int id) {
		return new ResponseEntity<Pasajero_DTO>(ipasajeros.findPasajeroById(id), HttpStatus.OK);
	}

	@PostMapping("/crear_pasajero")
	public ResponseEntity<Pasajero_DTO> get_crear_pasajero(@RequestBody Pasajero_DTO pasajero_DTO) {
		try {
			ipasajeros.findPasajeroById(pasajero_DTO.getId_pasajero());
			return new ResponseEntity<Pasajero_DTO>( new Pasajero_DTO(), HttpStatus.FOUND);

		} catch (NullPointerException e) {
			return new ResponseEntity<Pasajero_DTO>(ipasajeros.savePasajero(pasajero_DTO), HttpStatus.CREATED);
		}
	}

	@PutMapping("/actualizar_pasajero")
	public ResponseEntity<Pasajero_DTO> get_actualizar_pasajero(@RequestBody Pasajero_DTO pasajero_DTO) {
		try {
			ipasajeros.findPasajeroById(pasajero_DTO.getId_pasajero());
			return new ResponseEntity<Pasajero_DTO>(ipasajeros.savePasajero(pasajero_DTO), HttpStatus.OK);

		} catch (NullPointerException e) {
			return new ResponseEntity<Pasajero_DTO>( new Pasajero_DTO(), HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete_pasajero/{id}")
	public ResponseEntity get_eliminar_pasajero(@PathVariable("id") int id) {
		ipasajeros.deletePasajero(id);
		return new ResponseEntity(HttpStatus.OK);
	}

	
	@GetMapping("/obtener_pasajero_nif/{nif}")
	public ResponseEntity<Pasajero_DTO> getPasajeroByNif(@PathVariable("nif") String nif) {
		return new ResponseEntity<Pasajero_DTO>(ipasajeros.findPasajeroByNif(nif), HttpStatus.OK);
	}
}
