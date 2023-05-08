package com.facens.facens_learn.model;

import java.util.ArrayList;
import java.util.List;

public class Questionario {
	private Long id;
	private Curso curso;
	private List<String> respostas;
	
	public Questionario() {}
	public Questionario(Curso curso, String... respostas) {
		List<String> entradas = new ArrayList<>();
		
		this.curso=curso;
		for(String res : respostas)
			entradas.add(res);
		this.respostas=entradas;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public List<String> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<String> respostas) {
		this.respostas = respostas;
	}
	
	
}
