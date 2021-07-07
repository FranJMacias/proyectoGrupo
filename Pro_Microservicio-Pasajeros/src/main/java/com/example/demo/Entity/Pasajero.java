package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.model.Pasajero_DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pasajero")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Pasajero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pasajero")
	private int id_pasajero;
	@Column(name = "id_vuelo")
	private int id_vuelo;
	@Column(name = "nif")
	private String nif;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "telefono")
	private int telefono;
	@Column(name = "email")
	private String email;
	
	
	public Pasajero(Pasajero_DTO pasajero) {
		this.id_pasajero = pasajero.getId_pasajero();
		this.id_vuelo = pasajero.getId_vuelo();
		this.nombre = pasajero.getNombre();
		this.nif = pasajero.getNif();
		this.telefono = pasajero.getTelefono();
		this.email = pasajero.getEmail();

	}
	
	public Pasajero(int id_vuelo, String nif, String nombre, int telefono, String email) {
		this.id_vuelo = id_vuelo;
		this.nif = nif;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	

}
