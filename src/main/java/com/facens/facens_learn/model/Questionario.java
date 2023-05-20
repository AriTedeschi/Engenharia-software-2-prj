package com.facens.facens_learn.model;

import java.util.ArrayList;
import java.util.List;

public class Questionario {
	private Long id;
	private List<Questao> questoes;
	
	public Questionario() {}
	public Questionario(Curso curso, Questao... questoes) {
		List<Questao> _questoes = new ArrayList<>();
		
		for(Questao q : questoes) 
			_questoes.add(q);			
		
		this.questoes=_questoes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}	
}
