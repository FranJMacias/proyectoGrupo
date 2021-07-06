package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.converter.Converter;
import com.example.demo.interfaces.IPasajero;
import com.example.demo.model.Pasajero_DTO;
import com.example.demo.repository.PasajeroRepository;

@Service
public class PasajeroService implements IPasajero {

	@Autowired
	PasajeroRepository pasajeroRepository;
	@Autowired
	Converter converter;

	@Override
	public List<Pasajero_DTO> getAllPasajeros() {
		return converter.convertirLista(pasajeroRepository.findAll());
	}

	@Override
	public Pasajero_DTO findPasajeroById(int id) {
		return new Pasajero_DTO(pasajeroRepository.findById(id).orElse(null));
	}

	@Override
	public Pasajero_DTO savePasajero(Pasajero_DTO pasajero_dto) {
		return new Pasajero_DTO(pasajeroRepository.save(converter.convertirDto_Model(pasajero_dto)));
	}

	@Override
	public Pasajero_DTO updatePasajero(Pasajero_DTO pasajero_dto) {
		return new Pasajero_DTO(pasajeroRepository.save(converter.convertirDto_Model(pasajero_dto)));
	}

	@Override
	public void deletePasajero(int id) {
		pasajeroRepository.deleteById(id);
	}
}
