package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public List<Pasajero_DTO> get_listar_pasajeros() {
		return ipasajeros.getAllPasajeros();
	}

	@GetMapping("/obtener_pasajero/{id}")
	public Pasajero_DTO get_cita(@PathVariable("id") int id) {
		return ipasajeros.findPasajeroById(id);
	}

	@PostMapping("/crear_pasajero")
	public Pasajero_DTO get_crear_pasajero(@RequestBody Pasajero_DTO pasajero_DTO) {
		return ipasajeros.savePasajero(pasajero_DTO);
	}

	@PutMapping("/actualizar_pasajero")
	public Pasajero_DTO get_actualizar_pasajero(@RequestBody Pasajero_DTO pasajero_DTO) {
		return ipasajeros.updatePasajero(pasajero_DTO);
	}

	@DeleteMapping("/delete_pasajero/{id}")
	public void get_eliminar_pasajero(@PathVariable("id") int id) {
		ipasajeros.deletePasajero(id);
	}

}
