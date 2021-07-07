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

	public Pasajero_DTO convertirModel_Dto(Pasajero pasajero) {
		Pasajero_DTO pasajero_DTO = new Pasajero_DTO();
		pasajero_DTO.setId_pasajero(pasajero.getId_pasajero());
		pasajero_DTO.setId_vuelo(pasajero.getId_vuelo());
		pasajero_DTO.setNombre(pasajero.getNombre());
		pasajero_DTO.setNif(pasajero.getNif());
		pasajero_DTO.setTelefono(pasajero.getTelefono());
		pasajero_DTO.setEmail(pasajero.getEmail());

		return pasajero_DTO;
	}
}
