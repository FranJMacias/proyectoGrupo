package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Pasajero;
import com.example.demo.converter.Converter;
import com.example.demo.interfaces.IPasajero;
import com.example.demo.model.Pasajero_DTO;
import com.example.demo.repository.PasajeroRepository;

@Service
public class PasajeroService implements IPasajero {

	@Autowired
	PasajeroRepository pasajeroRepository;

	@Override
	public List<Pasajero_DTO> getAllPasajeros() {
		return Converter.convertirLista(pasajeroRepository.findAll());
	}

	@Override
	public Pasajero_DTO findPasajeroById(int id){
		try {
			return Converter.convertirModel_Dto(pasajeroRepository.findById(id).orElse(null));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
			
	}

	@Override
	public Pasajero_DTO savePasajero(Pasajero_DTO pasajerio_dto) {
		return Converter.convertirModel_Dto(pasajeroRepository.save(Converter.convertirDto_Model(pasajerio_dto)));
	}

	@Override
	public void deletePasajero(int id) {
		pasajeroRepository.deleteById(id);
	}

	@Override
	public Pasajero_DTO findPasajeroByNif(String nif) {
		try {
			Pasajero pasajero = pasajeroRepository.findAll().stream().filter(s -> nif.equalsIgnoreCase(s.getNif()))
					.findFirst().get();
			return Converter.convertirModel_Dto(pasajero);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
			
	}
}
