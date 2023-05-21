package com.facens.facens_learn.controller.forms;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class NovoCursoForm {
	@ApiModelProperty(value = "Nome do Curso", example = "Rodolfo")
	@NotEmpty(message = "Informe nome do curso")
	@Size(max = 150)
	private String nome;

	@ApiModelProperty(value = "Descrição do Curso", example = "Curso de Arduino")
	@NotEmpty(message = "Informe descrição do curso")
	@Size(max = 500)
	private String descricao;
	
	@ApiModelProperty(value = "Data de lançamento do Curso", example = "30/03/2024")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataLancamento;

	@ApiModelProperty(value = "Carga horária do Curso", example = "20")
	@NotNull(message = "Informe carga horária do curso")
    @Positive(message = "Informe uma carga horária positiva")
	private Integer cargaHoraria;
	
	@ApiModelProperty(value = "Categoria do Curso", example = "Programação de Microcontroladores")
	@NotEmpty(message = "Informe categoria do curso")	
	private String categoria;
	
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}	
}
