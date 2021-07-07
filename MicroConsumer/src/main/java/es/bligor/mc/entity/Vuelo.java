package es.bligor.mc.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
	
	private Integer id;

	private Integer idTerminal;

	private String compañia;

	private Date fecha;

	private String destino;

	private String origen; 

	private Double duracion;
}
