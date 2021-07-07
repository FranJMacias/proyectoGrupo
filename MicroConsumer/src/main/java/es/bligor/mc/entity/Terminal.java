package es.bligor.mc.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("Terminal")
public class Terminal implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idTerminal;
	private String nombre;
	private Integer numeroPuertas;
	private List<ObjetoPerdido> objetosPerdidos;
}
