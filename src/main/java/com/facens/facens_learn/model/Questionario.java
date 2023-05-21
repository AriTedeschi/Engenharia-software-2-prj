package com.facens.facens_learn.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;

import com.facens.facens_learn.model.VO.Questionario.Nota;

@Entity
public class Questionario implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private Nota nota;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="questionario", cascade = CascadeType.PERSIST)
	private List<Questao> questoes = new ArrayList<>();
	
	public Questionario() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void adicionarNota(BigDecimal nota) {
		this.nota = new Nota(nota);
	}
	
	public Nota getNota() {
		return nota;
	}
	public List<Questao> getQuestoes() {
		return questoes;
	}
	public void adicionarQuestao(Questao questao) {
		this.questoes.add(questao);
	}	
}
