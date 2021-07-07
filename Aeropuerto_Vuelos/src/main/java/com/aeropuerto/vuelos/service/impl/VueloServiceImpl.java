package com.aeropuerto.vuelos.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeropuerto.vuelos.model.dto.Vuelo_DTO;
import com.aeropuerto.vuelos.repository.IVueloRepository;
import com.aeropuerto.vuelos.service.IVueloService;
import com.aeropuerto.vuelos.util.Converter;

@Service
public class VueloServiceImpl implements IVueloService {

	@Autowired
	private IVueloRepository vueloRepository;
	
	@Override
	public List<Vuelo_DTO> getAllVuelos() {
		return Converter.convertirLista(vueloRepository.findAll());
	}

	@Override
	public Vuelo_DTO findVueloById(int id) {
		return Converter.convertirModel_Dto(vueloRepository.findById(id).orElse(null));
	}

	@Override
	public Vuelo_DTO saveVuelo(Vuelo_DTO vuelo_dto) {
		return Converter.convertirModel_Dto(vueloRepository.save(Converter.convertirDto_Model(vuelo_dto)));
	}

	@Override
	public void deleteVuelo(int id) {
		vueloRepository.deleteById(id);		
	}

	@Override
	public List<Vuelo_DTO> findVuelosByTerminal(int id_terminal) {
		return Converter.convertirLista(vueloRepository.findAll().stream().filter(v->v.getId_terminal() == id_terminal).collect(Collectors.toList()));
	}

}
