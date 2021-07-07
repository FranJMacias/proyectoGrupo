package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.ObjetoPerdidoDto;
import com.example.demo.dto.TerminalDto;
import com.example.demo.model.ObjetoPerdido;
import com.example.demo.model.Terminal;

public class Convertidor {

	public static TerminalDto terminalEntityToDto(Terminal t) {
		TerminalDto terminal = new TerminalDto();
		terminal.setIdTerminal(t.getIdTerminal());
		terminal.setNombre(t.getNombre());
		terminal.setNumeroPuertas(t.getNumeroPuertas());
		terminal.setObjetosPerdidos(listObjetoPerdidoEntityToDto(t.getObjetosPerdidos()));
		return terminal;
	}

	public static List<TerminalDto> listTerminalEntityToDto(List<Terminal> t) {
		List<TerminalDto> terminales = new ArrayList<TerminalDto>();
		for (Terminal terminal : t) {
			terminales.add(terminalEntityToDto(terminal));
		}
		return terminales;
	}

	public static ObjetoPerdidoDto objetoPerdidoEntityToDto(ObjetoPerdido o) {
		ObjetoPerdidoDto objeto = new ObjetoPerdidoDto();
		objeto.setIdObjeto(o.getIdObjeto());
		objeto.setFecha(o.getFecha());
		objeto.setNombre(o.getNombre());
		return objeto;
	}

	public static List<ObjetoPerdidoDto> listObjetoPerdidoEntityToDto(List<ObjetoPerdido> o) {
		List<ObjetoPerdidoDto> objetos = new ArrayList<ObjetoPerdidoDto>();
		for (ObjetoPerdido objetoPerdido : o) {
			objetos.add(objetoPerdidoEntityToDto(objetoPerdido));
		}
		return objetos;
	}

	public static Terminal terminalDtoToEntity(TerminalDto t) {
		Terminal terminal = new Terminal();
		terminal.setIdTerminal(t.getIdTerminal());
		terminal.setNombre(t.getNombre());
		terminal.setNumeroPuertas(t.getNumeroPuertas());
		terminal.setObjetosPerdidos(listObjetoPerdidoDtoToEntity(t.getObjetosPerdidos()));
		return terminal;
	}

	public static List<Terminal> listTerminalDtoToEntity(List<TerminalDto> t) {
		List<Terminal> terminales = new ArrayList<Terminal>();
		for (TerminalDto terminal : t) {
			terminales.add(terminalDtoToEntity(terminal));
		}
		return terminales;
	}

	public static ObjetoPerdido objetoPerdidoDtoToEntity(ObjetoPerdidoDto o) {
		ObjetoPerdido objeto = new ObjetoPerdido();
		objeto.setIdObjeto(o.getIdObjeto());
		objeto.setFecha(o.getFecha());
		objeto.setNombre(o.getNombre());
		return objeto;
	}

	public static List<ObjetoPerdido> listObjetoPerdidoDtoToEntity(List<ObjetoPerdidoDto> o) {
		List<ObjetoPerdido> objetos = new ArrayList<ObjetoPerdido>();
		for (ObjetoPerdidoDto objetoPerdido : o) {
			objetos.add(objetoPerdidoDtoToEntity(objetoPerdido));
		}
		return objetos;
	}

}
