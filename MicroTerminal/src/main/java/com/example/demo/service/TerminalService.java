package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TerminalDto;
import com.example.demo.interfaces.ITerminalService;
import com.example.demo.model.Terminal;
import com.example.demo.repository.TerminalRepository;
import com.example.demo.util.Convertidor;

@Service
public class TerminalService implements ITerminalService {

	@Autowired
	TerminalRepository terminalRepository;

	@Override
	public List<TerminalDto> findAll() {
		return Convertidor.listTerminalEntityToDto(terminalRepository.findAll());
	}

	@Override
	public TerminalDto findById(Integer id) {
		Terminal terminal = terminalRepository.findById(id).orElse(null);
		if (terminal == null) {
			return null;
		} else {
			return Convertidor.terminalEntityToDto(terminal);
		}
	}

	@Override
	public String crearTerminal(TerminalDto t) {
		Terminal terminal = terminalRepository.findById(t.getIdTerminal()).orElse(null);
		if (terminal != null) {
			return "error";
		} else {
			terminal = new Terminal();
			terminal = Convertidor.terminalDtoToEntity(t);
			terminal = terminalRepository.save(terminal);
			return "ok";
		}
	}

	@Override
	public String editarTerminal(TerminalDto t) {
		Terminal terminal = terminalRepository.findById(t.getIdTerminal()).orElse(null);
		if (terminal == null) {
			return "error";
		} else {
			terminal.setNombre(t.getNombre());
			terminal.setNumeroPuertas(t.getNumeroPuertas());
			terminal.setObjetosPerdidos(Convertidor.listObjetoPerdidoDtoToEntity(t.getObjetosPerdidos()));
			terminal = terminalRepository.save(terminal);
			return "ok";
		}
	}

	@Override
	public String deleteById(int id) {
		Terminal t = terminalRepository.findById(id).orElse(null);
		if (t == null) {
			return "error";
		} else {
			terminalRepository.delete(t);
			return "ok";
		}
	}

	@Override
	public List<TerminalDto> findByNombre(String nombre) {
		List<TerminalDto> lista = Convertidor.listTerminalEntityToDto(terminalRepository.findAll());
		lista = lista.stream().filter(t -> t.getNombre().matches(".*" + nombre + ".*")).collect(Collectors.toList());
		return lista;
	}

	@Override
	public List<TerminalDto> findByNumeroPuertas(int puertasMin, int puertasMax) {
		List<TerminalDto> lista = Convertidor.listTerminalEntityToDto(terminalRepository.findAll());
		lista = lista.stream().filter(t -> t.getNumeroPuertas() > puertasMin && t.getNumeroPuertas() < puertasMax)
				.collect(Collectors.toList());
		return lista;
	}

}
