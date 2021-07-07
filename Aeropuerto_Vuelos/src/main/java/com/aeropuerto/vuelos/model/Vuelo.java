package com.aeropuerto.vuelos.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.aeropuerto.vuelos.model.dto.Vuelo_DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vuelo")
@AllArgsConstructor @NoArgsConstructor
@Data
public class Vuelo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vuelo")
	private int id_vuelo;

	@Column(name = "id_terminal")
	private int id_terminal;
	@Column(name = "compania")
	private String compania;
	@Column(name = "fecha_hora")
	private Date fechaHora;
	@Column(name = "destino")
	private String destino;
	@Column(name = "origen")
	private String origen;
	@Column(name = "duracion")
	private double duracion;
	
	public Vuelo(Vuelo_DTO vuelo_dto) {
		super();
		this.id_vuelo = vuelo_dto.getId_vuelo();
		this.id_terminal = vuelo_dto.getId_terminal();
		this.compania = vuelo_dto.getCompania();
		this.fechaHora = vuelo_dto.getFechaHora();
		this.destino = vuelo_dto.getDestino();
		this.origen = vuelo_dto.getOrigen();
		this.duracion = vuelo_dto.getDuracion();
	}

	public Vuelo(int id_terminal, String compania, Date fechaHora, String destino, String origen, double duracion) {
		super();
		this.id_terminal = id_terminal;
		this.compania = compania;
		this.fechaHora = fechaHora;
		this.destino = destino;
		this.origen = origen;
		this.duracion = duracion;
	}

}
