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

import es.bligor.mc.controller.implem.ICrudController;
import es.bligor.mc.entity.Vuelo;
import es.bligor.mc.service.VueloService;

@RestController
public class VueloController implements ICrudController<Vuelo> {

	@Autowired
	private VueloService vueloService;

	@Override
	@PostMapping("/vuelo")
	public ResponseEntity<Vuelo> add(@RequestBody Vuelo vuelo) {
		return new ResponseEntity<Vuelo>(vueloService.add(vuelo), HttpStatus.OK);
	}

	@Override
	@PutMapping("/vuelo")
	public ResponseEntity<String> update(@RequestBody Vuelo vuelo) {
		vueloService.update(vuelo);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/vuelo/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		vueloService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	@GetMapping("/vuelo")
	public ResponseEntity<List<Vuelo>> getAll() {
		return new ResponseEntity<List<Vuelo>>(vueloService.getAll(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/vuelo/{id}")
	public ResponseEntity<Vuelo> getById(@PathVariable("id") String id) {
		return new ResponseEntity<Vuelo>(vueloService.getById(id), HttpStatus.OK);
	}
}
