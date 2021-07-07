package es.bligor.mc.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
	
	private Integer id_vuelo;

	private Integer id_terminal;

	private String compania;

	private Date fechaHora;

	private String destino;

	private String origen; 

	private Double duracion;
}
