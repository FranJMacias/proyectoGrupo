package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.Pasajero;
import com.example.demo.model.Pasajero_DTO;

@Component
public class Converter {

	public List<Pasajero_DTO> convertirLista(List<Pasajero> pasajeros) {
		return pasajeros.stream().map(Pasajero_DTO::new).collect(Collectors.toList());
	}

	public Pasajero convertirDto_Model(Pasajero_DTO pasajero_DTO) {
		Pasajero pasajero = new Pasajero();
		pasajero.setId_pasajero(pasajero_DTO.getId_pasajero());
		pasajero.setId_vuelo(pasajero_DTO.getId_vuelo());
		pasajero.setNombre(pasajero_DTO.getNombre());
		pasajero.setNif(pasajero_DTO.getNif());
		pasajero.setTelefono(pasajero_DTO.getTelefono());
		pasajero.setEmail(pasajero_DTO.getEmail());

		return pasajero;
	}

}
