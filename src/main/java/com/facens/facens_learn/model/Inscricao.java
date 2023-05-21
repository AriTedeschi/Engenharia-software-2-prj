package com.facens.facens_learn.model;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "inscricao")
public class Inscricao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="aluno_id")
	private Aluno inscrito;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="curso_id")
	private Curso curso;	
	
	private BigDecimal pontuacao;
	
	private Boolean finalizado;	
	
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

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	
	
}
