package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.model.Pasajero_DTO;

public interface IPasajero {

	public List<Pasajero_DTO> getAllPasajeros();

	public Pasajero_DTO findPasajeroById(int id);

	public Pasajero_DTO savePasajero(Pasajero_DTO pasajero_dto);

	public void deletePasajero(int id);
}
