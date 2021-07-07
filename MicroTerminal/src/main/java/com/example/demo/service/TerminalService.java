package com.example.demo.service;

import java.util.List;

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
	public String deleteById(Integer id) {
		Terminal t = terminalRepository.findById(id).orElse(null);
		if (t == null) {
			return "error";
		} else {
			terminalRepository.delete(t);
			return "ok";
		}
	}

}
