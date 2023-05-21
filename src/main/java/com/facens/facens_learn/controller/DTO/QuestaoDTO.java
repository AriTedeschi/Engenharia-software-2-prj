package com.facens.facens_learn.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import com.facens.facens_learn.model.Alternativa;
import com.facens.facens_learn.model.Questao;

public class QuestaoDTO {
	private String pergunta;
	private double peso;
	private List<AlternativaDTO> alternativas = new ArrayList<>();
	
	public QuestaoDTO(Questao questao) {
		this.pergunta = questao.getPergunta();
		this.peso = questao.getPeso();
		for(Alternativa alt : questao.getAlternativas()) {
			alternativas.add(new AlternativaDTO(alt));
		}
	}
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public List<AlternativaDTO> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<AlternativaDTO> alternativas) {
		this.alternativas = alternativas;
	}
	
	
}
