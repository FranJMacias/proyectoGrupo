package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Pasajero;
import es.bligor.mc.service.implem.ICrudService;

@Service
public class PasajeroService implements ICrudService<Pasajero> {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:8081/pasajero";

	@Override
	public Pasajero add(Pasajero pasajero) {
		return restTemplate.postForObject(url, pasajero, Pasajero.class);
	}

	@Override
	public void update(Pasajero pasajero) {
		restTemplate.put(url, pasajero);
	}

	@Override
	public void delete(String id) {
		restTemplate.delete(url + "/" + id);
	}

	@Override
	public List<Pasajero> getAll() {
		return Arrays.asList(restTemplate.getForObject(url, Pasajero[].class));
	}

	@Override
	public Pasajero getById(String id) {
		return restTemplate.getForObject(url + "/" + id, Pasajero.class);
	}

}
