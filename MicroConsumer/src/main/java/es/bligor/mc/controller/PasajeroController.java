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
import es.bligor.mc.entity.Pasajero;
import es.bligor.mc.service.PasajeroService;

@RestController
public class PasajeroController implements ICrudController<Pasajero> {

	@Autowired
	private PasajeroService pasajeroService;

	@Override
	@PostMapping("/pasajero")
	public ResponseEntity<Pasajero> add(@RequestBody Pasajero pasajero) {
		return new ResponseEntity<Pasajero>(pasajeroService.add(pasajero), HttpStatus.OK);
	}

	@Override
	@PutMapping("/pasajero")
	public ResponseEntity<String> update(@RequestBody Pasajero pasajero) {
		pasajeroService.update(pasajero);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	@DeleteMapping("/pasajero/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") String id) {
		pasajeroService.delete(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@Override
	@GetMapping("/pasajero")
	public ResponseEntity<List<Pasajero>> getAll() {
		return new ResponseEntity<List<Pasajero>>(pasajeroService.getAll(), HttpStatus.OK);
	}

	@Override
	@GetMapping("/pasajero/{id}")
	public ResponseEntity<Pasajero> getById(@PathVariable("id") String id) {
		return new ResponseEntity<Pasajero>(pasajeroService.getById(id), HttpStatus.OK);
	}

	@GetMapping("/pasajero/nif/{nif}")
	public ResponseEntity<Pasajero> getPasajeroByNif(@PathVariable("nif") String nif) {
		return new ResponseEntity<Pasajero>(pasajeroService.getByNif(nif), HttpStatus.OK);
	}
}
