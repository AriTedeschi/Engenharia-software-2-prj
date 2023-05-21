package com.facens.facens_learn.model;

import com.facens.facens_learn.model.VO.Curso.CargaHoraria;
import com.facens.facens_learn.model.VO.Curso.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;

	@Embedded
	private CargaHoraria cargaHoraria;
	
	public Curso() {}
	
	@Embedded
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

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}

	public void adicionarCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = new CargaHoraria(cargaHoraria);
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
