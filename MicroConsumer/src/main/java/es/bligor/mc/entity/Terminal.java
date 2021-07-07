package es.bligor.mc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {

	private Integer id;

	private String name;

	private Integer n_puertas;

	private ObjetosPerdidos objetosPerdidos;
}
