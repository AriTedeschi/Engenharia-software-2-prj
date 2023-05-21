package com.facens.facens_learn.model.VO.Curso;

import javax.persistence.Embeddable;

@Embeddable
public class Categoria {
	private String nomeCategoria;

	public Categoria() {}
	public Categoria(String nome) {
		this.nomeCategoria = nome;
	}
	
	public String getCategoria() {
		return nomeCategoria;
	}
}
