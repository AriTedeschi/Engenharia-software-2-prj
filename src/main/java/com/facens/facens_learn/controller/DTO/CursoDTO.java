package com.facens.facens_learn.controller.DTO;

import java.time.LocalDate;

import com.facens.facens_learn.model.Curso;

public class CursoDTO {
	private Long id;
	private String nome;
	private String descricao;
	private LocalDate dataLancamento;
	private Integer cargaHoraria;
	private String categocia;
	
	public CursoDTO(Curso curso) {
		this.id = curso.getId();
		this.nome = curso.getNome();
		this.descricao = curso.getDescricao();
		this.cargaHoraria = curso.getCargaHoraria().getCargaHoraria();
		this.dataLancamento = curso.getDataLancamento();
		this.categocia = curso.getCategocia().getCategoria();
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getCategocia() {
		return categocia;
	}
	public void setCategocia(String categocia) {
		this.categocia = categocia;
	}
}
