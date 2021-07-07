package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "terminal")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Integer idTerminal;

	private String nombre;

	private Integer numeroPuertas;

	private List<ObjetoPerdido> objetosPerdidos;

}
