package es.bligor.mc.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName("ObjetoPerdido")
public class ObjetoPerdido implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idObjeto;
	private Date fecha;
	private String nombre;
}
