package com.aeropuerto.vuelos.util;

import java.util.List;
import java.util.stream.Collectors;

import com.aeropuerto.vuelos.model.Vuelo;
import com.aeropuerto.vuelos.model.dto.Vuelo_DTO;

public class Converter {
	public static List<Vuelo_DTO> convertirLista(List<Vuelo> vuelos) {		
		return vuelos.stream().map(Vuelo_DTO::new).collect(Collectors.toList());
		
	}
	
	public static Vuelo convertirDto_Model(Vuelo_DTO vuelo_DTO) {
		Vuelo vuelo = new Vuelo();
		vuelo.setId_vuelo(vuelo_DTO.getId_vuelo());
		vuelo.setId_terminal(vuelo_DTO.getId_terminal());
		vuelo.setCompania(vuelo_DTO.getCompania());
		vuelo.setFechaHora(vuelo_DTO.getFechaHora());
		vuelo.setDestino(vuelo_DTO.getDestino());
		vuelo.setOrigen(vuelo_DTO.getOrigen());
		vuelo.setDuracion(vuelo_DTO.getDuracion());
		return vuelo;
		
	}
	
	public static Vuelo_DTO convertirModel_Dto(Vuelo vuelo) {
		Vuelo_DTO vuelo_DTO = new Vuelo_DTO();
		vuelo_DTO.setId_vuelo(vuelo.getId_vuelo());
		vuelo_DTO.setId_terminal(vuelo.getId_terminal());
		vuelo_DTO.setCompania(vuelo.getCompania());
		vuelo_DTO.setFechaHora(vuelo.getFechaHora());
		vuelo_DTO.setDestino(vuelo.getDestino());
		vuelo_DTO.setOrigen(vuelo.getOrigen());
		vuelo_DTO.setDuracion(vuelo.getDuracion());
		return vuelo_DTO;
	}
}
