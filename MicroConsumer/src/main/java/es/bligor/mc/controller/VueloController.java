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
import org.springframework.web.bind.annotation.RestController;

import es.bligor.mc.entity.Vuelo;
import es.bligor.mc.service.VueloService;

@RestController
public class VueloController {

	@Autowired
	private VueloService vueloService;

	@PostMapping("/vuelo")
	public ResponseEntity<Vuelo> add(@RequestBody Vuelo vuelo) {
		return new ResponseEntity<Vuelo>(vueloService.add(vuelo), HttpStatus.OK);
	}

	@PutMapping("/vuelo")
	public ResponseEntity<String> update(@RequestBody Vuelo vuelo) {
		vueloService.update(vuelo);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@DeleteMapping("/vuelo/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id) {
		vueloService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@GetMapping("/vuelos")
	public ResponseEntity<List<Vuelo>> getAll() {
		return new ResponseEntity<List<Vuelo>>(vueloService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/vuelo/{id}")
	public ResponseEntity<Vuelo> getById(@PathVariable("id") int id) {
		return new ResponseEntity<Vuelo>(vueloService.getById(id), HttpStatus.OK);
	}
	
	@GetMapping("/vuelos/terminal/{id_terminal}")
	public ResponseEntity<List<Vuelo>> getVuelosByTerminal(@PathVariable("id_terminal") int id_terminal) {
		return new ResponseEntity<List<Vuelo>>(vueloService.getByTerminal(id_terminal), HttpStatus.OK);
	}
	
	@GetMapping("/vuelos/compania/{compania}")
	public ResponseEntity<List<Vuelo>> getVuelosByCompania(@PathVariable("compania") String compania) {
		return new ResponseEntity<List<Vuelo>>(vueloService.getByCompania(compania), HttpStatus.OK);
	}
	
	@GetMapping("/vuelos/origen/{origen}")
	public ResponseEntity<List<Vuelo>> getVuelosByOrigen(@PathVariable("origen") String origen) {
		return new ResponseEntity<List<Vuelo>>(vueloService.getByOrigen(origen), HttpStatus.OK);
	}
	
	@GetMapping("/vuelos/destino/{destino}")
	public ResponseEntity<List<Vuelo>> getVuelosByDestino(@PathVariable("destino") String destino) {
		return new ResponseEntity<List<Vuelo>>(vueloService.getByDestino(destino), HttpStatus.OK);
	}
	
}
