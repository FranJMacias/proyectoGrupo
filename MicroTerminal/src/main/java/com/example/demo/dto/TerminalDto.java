package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TerminalDto {

	private Integer idTerminal;
	private String nombre;
	private Integer numeroPuertas;
	private List<ObjetoPerdidoDto> objetosPerdidos;
	
	
}
