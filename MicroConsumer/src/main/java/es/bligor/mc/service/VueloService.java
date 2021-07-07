package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Vuelo;

@Service
public class VueloService {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://micro-vuelos";

	public Vuelo add(Vuelo vuelo) {
		return restTemplate.postForObject(url + "/vuelo", vuelo, Vuelo.class);
	}

	public void update(Vuelo vuelo) {
		restTemplate.put(url + "/vuelo", vuelo);
	}

	public void delete(int id) {
		restTemplate.delete(url + "/vuelo/" + id);
	}

	public List<Vuelo> getAll() {
		return Arrays.asList(restTemplate.getForObject(url + "/vuelos", Vuelo[].class));
	}

	public Vuelo getById(int id) {
		return restTemplate.getForObject(url + "/vuelo/" + id, Vuelo.class);
	}
	
	public List<Vuelo> getByTerminal(int id_terminal) {
		return Arrays.asList(restTemplate.getForObject(url + "/vuelos/terminal/" + id_terminal, Vuelo[].class));
	}
	
	public List<Vuelo> getByCompania(String compania) {
		return Arrays.asList(restTemplate.getForObject(url + "/vuelos/compania/" + compania, Vuelo[].class));
	}

}
