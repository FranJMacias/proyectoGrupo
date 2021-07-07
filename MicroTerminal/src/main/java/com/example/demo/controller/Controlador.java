package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TerminalDto;
import com.example.demo.interfaces.ITerminalService;

@RestController
@RequestMapping("/terminal")
public class Controlador {

	@Autowired
	ITerminalService terminalService;

	@GetMapping("/findAll")
	public ResponseEntity<List<TerminalDto>> findAll() {
		return new ResponseEntity<List<TerminalDto>>(terminalService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<TerminalDto> findAll(@PathVariable("id") Integer id) {
		return new ResponseEntity<TerminalDto>(terminalService.findById(id), HttpStatus.OK);
	}

	@PostMapping("/crearTerminal")
	public ResponseEntity<TerminalDto> crearTerminal(@RequestBody TerminalDto terminal) {
		String resultado = terminalService.crearTerminal(terminal);
		if (resultado.equals("ok")) {
			return new ResponseEntity<TerminalDto>(terminal, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/editarTerminal")
	public ResponseEntity<TerminalDto> editarTerminal(@RequestBody TerminalDto terminal) {
		String resultado = terminalService.editarTerminal(terminal);
		if (resultado.equals("ok")) {
			return new ResponseEntity<TerminalDto>(terminal, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/borrarTerminal/{id}")
	public ResponseEntity<String> borrarTerminal(@PathVariable("id") int id) {
		String resultado = terminalService.deleteById(id);
		if (resultado.equals("ok")) {
			return new ResponseEntity<String>("Borrado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No existe", HttpStatus.BAD_REQUEST);
		}
	}
}
