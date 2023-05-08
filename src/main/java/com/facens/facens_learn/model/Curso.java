package com.facens.facens_learn.model;
import java.util.List;
import java.util.ArrayList;

public class Curso {
	private Long id;
	private String nome;
	private List<Questao> questoes = new ArrayList<>();
	

	public void setId(Long id) {
		this.id=id;
	}
	public Long getId() {
		return this.id;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return this.nome;
	}
	
	public List<Questao> getQuestoes(){
		return this.questoes;
	}
	
	public Curso addQuestao(Questao q) {
		questoes.add(q);
		return this;
	}	
	public void removerQuestao(Questao q) {
		questoes.remove(q);
	}
}
