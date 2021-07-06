package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pasajero")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pasajero {

	@Id
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
}
