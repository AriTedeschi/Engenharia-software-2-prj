package com.facens.facens_learn.model;

import com.facens.facens_learn.model.VO.Curso.Categoria;

import java.time.LocalDateTime;

public class Curso {
	private Long id;
	private String nome;
	private String descricao;
	private LocalDateTime dataLancamento;
	private Integer cargaHoraria;
	private Categoria categocia;
	private Questionario questionario;
	
	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Curso(String nome) {
		this.nome = nome;
	}	

	public void setId(Long id) {
		this.id=id;
	}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Categoria getCategocia() {
		return categocia;
	}

	public void adicionarCategoria(String nomeCategocia) {
		this.categocia = new Categoria(nomeCategocia);
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
}
