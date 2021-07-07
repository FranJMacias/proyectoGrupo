package es.bligor.mc.entity;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetosPerdidos {

	private Integer id;

	private Date fecha;

	private String nombre;
}
