package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Vuelo;
import es.bligor.mc.service.implem.ICrudService;

@Service
public class VueloService implements ICrudService<Vuelo> {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:8081/vuelo";

	@Override
	public Vuelo add(Vuelo vuelo) {
		return restTemplate.postForObject(url, vuelo, Vuelo.class);
	}

	@Override
	public void update(Vuelo vuelo) {
		restTemplate.put(url, vuelo);
	}

	@Override
	public void delete(String id) {
		restTemplate.delete(url + "/" + id);
	}

	@Override
	public List<Vuelo> getAll() {
		return Arrays.asList(restTemplate.getForObject(url, Vuelo[].class));
	}

	@Override
	public Vuelo getById(String id) {
		return restTemplate.getForObject(url + "/" + id, Vuelo.class);
	}

}
