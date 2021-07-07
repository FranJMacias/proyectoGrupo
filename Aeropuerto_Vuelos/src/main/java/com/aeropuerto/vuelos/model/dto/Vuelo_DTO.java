package com.aeropuerto.vuelos.model.dto;

import java.sql.Date;

import com.aeropuerto.vuelos.model.Vuelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor
@Data
public class Vuelo_DTO {

	private int id_vuelo;
	private int id_terminal;
	private String compania;
	private Date fechaHora;
	private String destino;
	private String origen;
	private double duracion;

	public Vuelo_DTO(Vuelo vuelo) {
		super();
		this.id_vuelo = vuelo.getId_vuelo();
		this.id_terminal = vuelo.getId_terminal();
		this.compania = vuelo.getCompania();
		this.fechaHora = vuelo.getFechaHora();
		this.destino = vuelo.getDestino();
		this.origen = vuelo.getOrigen();
		this.duracion = vuelo.getDuracion();
	}

	public Vuelo_DTO(int id_terminal, String compania, Date fechaHora, String destino, String origen, double duracion) {
		super();
		this.id_terminal = id_terminal;
		this.compania = compania;
		this.fechaHora = fechaHora;
		this.destino = destino;
		this.origen = origen;
		this.duracion = duracion;
	}

}
