package es.bligor.mc.controller;

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

import es.bligor.mc.controller.implem.ICrudController;
import es.bligor.mc.entity.Terminal;
import es.bligor.mc.service.TerminalService;

public class TerminalController implements ICrudController<Terminal> {

	@Autowired
	private TerminalService terminalService;

	@Override
	@PostMapping("/terminal")
	public ResponseEntity<Terminal> add(@RequestBody Terminal terminal) {
		return new ResponseEntity<Terminal>(terminalService.add(terminal), HttpStatus.OK);
	}

	@Override
	@PutMapping("/terminal")
	public ResponseEntity<String> update(@RequestBody Terminal terminal) {
		terminalService.update(terminal);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/terminal/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		terminalService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	@GetMapping("/terminal")
	public ResponseEntity<List<Terminal>> getAll() {
		return new ResponseEntity<List<Terminal>>(terminalService.getAll(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/terminal/{id}")
	public ResponseEntity<Terminal> getById(@PathVariable("id") String id) {
		return new ResponseEntity<Terminal>(terminalService.getById(id), HttpStatus.OK);
	}
}
