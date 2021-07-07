package es.bligor.mc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pasajero {

	private Integer id;

	private Integer id_vuelo;

	private String name;

	private String Nif;

	private Integer telefono;

	private String email;
}
