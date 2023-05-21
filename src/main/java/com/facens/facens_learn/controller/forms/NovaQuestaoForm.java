package com.facens.facens_learn.controller.forms;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.facens.facens_learn.controller.DTO.AlternativaDTO;

import io.swagger.annotations.ApiModelProperty;

public class NovaQuestaoForm {
	@ApiModelProperty(value = "Pergunta da questão", example = "2 + 2?")
	@NotEmpty(message = "Informe a pergunta da questão")
	@Size(max = 150)
	private String pergunta;

	@ApiModelProperty(value = "Resposta da questão", example = "A")
	@NotEmpty(message = "Informe a resposta da questão")
	@Size(max = 150)
	private String resposta;
	
	@ApiModelProperty(value = "Peso da questão", example = "2.5")
	@NotNull(message = "Informe o peso da questão")
	private double peso;
	
	private List<AlternativaDTO> alternativas = new ArrayList<>();
	
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
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	public List<AlternativaDTO> getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(List<AlternativaDTO> alternativas) {
		this.alternativas = alternativas;
	}
}
