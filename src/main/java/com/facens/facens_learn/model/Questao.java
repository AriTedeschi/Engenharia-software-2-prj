package com.facens.facens_learn.model;

import java.util.ArrayList;
import java.util.List;

import com.facens.facens_learn.model.VO.Questionario.Alternativa;

public class Questao {
	private String pergunta;
	private String resposta;
	private double peso;
	private List<Alternativa> alternativas = new ArrayList<>();
	
	public Questao(String pergunta,String resposta,double peso) {
		this.pergunta=pergunta;
		this.resposta=resposta;
		this.peso=peso;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
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
	public void adicionarAlternativa(String resposta, String corpo) {
		this.alternativas.add(new Alternativa(resposta, corpo));
	}
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
}
