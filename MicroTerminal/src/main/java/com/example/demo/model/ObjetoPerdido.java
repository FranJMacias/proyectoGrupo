package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ObjetoPerdido implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer idObjeto;
	private Date fecha;
	private String nombre;
}
