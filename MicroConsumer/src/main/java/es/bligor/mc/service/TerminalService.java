package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Terminal;
import es.bligor.mc.service.implem.ICrudService;

@Service
public class TerminalService implements ICrudService<Terminal> {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://micro-terminal/terminal";

	private HttpHeaders headers = new HttpHeaders();

	@Override
	public Terminal add(Terminal terminal) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Terminal> request = new HttpEntity<>(terminal, headers);
		return restTemplate.postForObject(url + "/crearTerminal", request, Terminal.class);
	}

	@Override
	public void update(Terminal terminal) {
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Terminal> request = new HttpEntity<>(terminal, headers);
		restTemplate.put(url + "/editarTerminal", request);
	}

	@Override
	public void delete(String id) {
		int idInt = Integer.valueOf(id);
		restTemplate.delete(url + "/borrarTerminal/{id}", idInt);
	}

	@Override
	public List<Terminal> getAll() {
		return Arrays.asList(restTemplate.getForObject(url + "/findAll", Terminal[].class));
	}

	@Override
	public Terminal getById(String id) {
		return restTemplate.getForObject(url + "/findById/{id}", Terminal.class, id);
	}

	public List<Terminal> getByNombre(String nombre) {
		return Arrays.asList(restTemplate.getForObject(url + "/filtroNombre/{nombre}", Terminal[].class, nombre));
	}

	public List<Terminal> getByPuertas(int minPuertas, int maxPuertas) {
		String url2 = url + "/filtroPuertas/" + minPuertas + "/" + maxPuertas;
		return Arrays.asList(restTemplate.getForObject(url2, Terminal[].class));
	}

}
