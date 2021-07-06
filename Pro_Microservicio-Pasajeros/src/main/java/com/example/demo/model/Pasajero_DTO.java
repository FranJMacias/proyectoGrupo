package com.example.demo.model;

import java.io.Serializable;

import com.example.demo.Entity.Pasajero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasajero_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_pasajero;
	private int id_vuelo;
	private String nif;
	private String nombre;
	private int telefono;
	private String email;

	public Pasajero_DTO(Pasajero pasajero) {
		this.id_pasajero = pasajero.getId_pasajero();
		this.id_vuelo = pasajero.getId_vuelo();
		this.nombre = pasajero.getNombre();
		this.nif = pasajero.getNif();
		this.telefono = pasajero.getTelefono();
		this.email = pasajero.getEmail();

	}
}
