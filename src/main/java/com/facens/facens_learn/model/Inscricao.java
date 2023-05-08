package com.facens.facens_learn.model;

import java.math.BigDecimal;

public class Inscricao {
	private Long id;
	private Aluno inscrito;
	private Curso curso;	
	private BigDecimal pontuacao;
	
	public Inscricao() {}
		
	public Inscricao(Aluno inscrito, Curso curso) {
		this.inscrito = inscrito;
		this.curso = curso;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Aluno getInscrito() {
		return inscrito;
	}
	public void setInscrito(Aluno inscrito) {
		this.inscrito = inscrito;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public BigDecimal getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(BigDecimal pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
