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

import com.example.demo.Entity.Pasajero;
import com.example.demo.interfaces.IPasajero;
import com.example.demo.model.Pasajero_DTO;

@RestController
@RequestMapping("/api")
public class Controlador {

	@Autowired
	IPasajero ipasajeros;

	@GetMapping("/listar_pasajeros")
	public ResponseEntity<List<Pasajero_DTO>> get_listar_pasajeros() {

		try {
			List<Pasajero_DTO> pasajeros = ipasajeros.getAllPasajeros();

			if (pasajeros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pasajeros, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/obtener_pasajero/{id}")
	public ResponseEntity<Pasajero_DTO> get_pasajero(@PathVariable("id") int id) {
		Pasajero_DTO pasajero = ipasajeros.findPasajeroById(id);
			return new ResponseEntity<>(pasajero, HttpStatus.OK);
	}

	@PostMapping("/crear_pasajero")
	public ResponseEntity<Pasajero_DTO> get_crear_pasajero(@RequestBody Pasajero_DTO pasajero_DTO) {
		try {

			Pasajero_DTO paDto = ipasajeros.findPasajeroById(pasajero_DTO.getId_pasajero());
			if (paDto == null) {
				Pasajero_DTO pasajero = ipasajeros
						.savePasajero(new Pasajero_DTO(pasajero_DTO.getId_vuelo(), pasajero_DTO.getNif(),
								pasajero_DTO.getNombre(), pasajero_DTO.getTelefono(), pasajero_DTO.getEmail()));

				return new ResponseEntity<>(pasajero, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar_pasajero")
	public ResponseEntity<Pasajero_DTO> get_actualizar_pasajero(@RequestBody Pasajero_DTO pasajero_DTO) {

		Pasajero_DTO paDto = ipasajeros.findPasajeroById(pasajero_DTO.getId_pasajero());
		if (paDto != null) {
			paDto.setId_vuelo(pasajero_DTO.getId_vuelo());
			paDto.setNif(pasajero_DTO.getNif());
			paDto.setNombre(pasajero_DTO.getNombre());
			paDto.setTelefono(pasajero_DTO.getTelefono());
			paDto.setEmail(pasajero_DTO.getEmail());
			return new ResponseEntity<>(ipasajeros.savePasajero(paDto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/delete_pasajero/{id}")
	public ResponseEntity get_eliminar_pasajero(@PathVariable("id") int id) {
		try {
			ipasajeros.deletePasajero(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/obtener_pasajero_nif/{nif}")
	public ResponseEntity<Pasajero_DTO> getPasajeroByNif(@PathVariable("nif") String nif) throws Exception {

		Pasajero_DTO pasajero = ipasajeros.findPasajeroByNif(nif);
		return new ResponseEntity<>(pasajero, HttpStatus.OK);
	}
}
