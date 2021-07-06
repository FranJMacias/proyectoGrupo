package com.aeropuerto.vuelos.service;

import java.util.List;

import com.aeropuerto.vuelos.model.dto.Vuelo_DTO;

public interface IVueloService {
	List<Vuelo_DTO> getAllVuelos();

	Vuelo_DTO findVueloById(int id);

	Vuelo_DTO saveVuelo(Vuelo_DTO vuelo_dto);

	void deleteVuelo(int id);
	
}
