package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Pasajero;

@Service
public class PasajeroService {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://micro-productor-pasajeros";
	private HttpHeaders headers = new HttpHeaders();

	public Pasajero add(Pasajero pasajero) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Pasajero> request = new HttpEntity<>(pasajero, headers);
		return restTemplate.postForObject(url + "/api/crear_pasajero", request, Pasajero.class);
	}

	public void update(Pasajero pasajero) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Pasajero> request = new HttpEntity<>(pasajero, headers);
		restTemplate.put(url + "/api/actualizar_pasajero", request);
	}

	public void delete(String id) {
		restTemplate.delete(url + "/api/delete_pasajero/" + id);
	}

	public List<Pasajero> getAll() {
		return Arrays.asList(restTemplate.getForObject(url + "/api/listar_pasajeros", Pasajero[].class));
	}

	public Pasajero getById(String id) {
		return restTemplate.getForObject(url + "/api/obtener_pasajero/" + id, Pasajero.class);
	}

	public Pasajero getByNif(String nif) {
		return restTemplate.getForObject(url + "/api/obtener_pasajero_nif/" + nif, Pasajero.class);
	}
}
