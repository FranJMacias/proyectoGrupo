package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.dto.TerminalDto;

public interface ITerminalService {

	public List<TerminalDto> findAll();

	public TerminalDto findById(Integer id);

	public String crearTerminal(TerminalDto t);

	public String editarTerminal(TerminalDto t);

	public String deleteById(int id);
}
