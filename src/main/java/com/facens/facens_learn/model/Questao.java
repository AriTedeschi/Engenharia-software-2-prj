package com.facens.facens_learn.model;

public class Questao {
	private Long id;
	private String pergunta;
	private String resposta;
	private double peso;
	
	public Questao(String r,double peso) {
		this.resposta=r;
		this.peso=peso;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public void setId(Long id) {
		this.id=id;
	}
	public Long getId() {
		return this.id;
	}
	
	public void setPergunta(String pergunta) {
		this.pergunta=pergunta;
	}
	public String getPergunta() {
		return this.pergunta;
	}
	
	public void setResposta(String resposta) {
		this.resposta=resposta;
	}
	public String getResposta() {
		return this.resposta;
	}
}
