package com.facens.facens_learn.controller.DTO;

import java.util.ArrayList;
import java.util.List;

public class QuestionarioRespostaDTO {
	private Long idCurso;
	private List<String> respostas = new ArrayList<>();
		
	public QuestionarioRespostaDTO(Long idCurso, String... respostas) {
		this.idCurso = idCurso;
		for(String r : respostas)
			this.respostas.add(r);
	}
	
	public Long getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}
	public List<String> getRespostas() {
		return respostas;
	}
	public void setRespostas(List<String> respostas) {
		this.respostas = respostas;
	}
	
}
