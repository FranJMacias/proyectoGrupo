package es.bligor.mc.entity;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Pasajero_DTO")
public class Pasajero {

	private Integer id_pasajero;

	private Integer id_vuelo;

	private String nombre;

	private String Nif;

	private Integer telefono;

	private String email;
}
