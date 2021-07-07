package es.bligor.mc.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.bligor.mc.entity.Pasajero;
import es.bligor.mc.entity.Terminal;
import es.bligor.mc.service.implem.ICrudService;

@Service
public class TerminalService implements ICrudService<Terminal> {

	@Autowired
	private RestTemplate restTemplate;

	private String url = "http://localhost:8082/terminal";

	@Override
	public Terminal add(Terminal terminal) {
		return restTemplate.postForObject(url, terminal, Terminal.class);
	}

	@Override
	public void update(Terminal terminal) {
		restTemplate.put(url, terminal);
	}

	@Override
	public void delete(String id) {
		restTemplate.delete(url + "/" + id);
	}

	@Override
	public List<Terminal> getAll() {
		return Arrays.asList(restTemplate.getForObject(url, Terminal[].class));
	}

	@Override
	public Terminal getById(String id) {
		return restTemplate.getForObject(url + "/" + id, Terminal.class);
	}

}
