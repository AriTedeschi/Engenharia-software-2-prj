package com.facens.facens_learn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codigoResposta;
	private String textoResposta;
	
	public Alternativa() {
		// TODO Auto-generated constructor stub
	}
	
	public Alternativa(String codigoResposta, String textoResposta) {
		this.codigoResposta = codigoResposta;
		this.textoResposta = textoResposta;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoResposta() {
		return codigoResposta;
	}
	public String getTextoResposta() {
		return textoResposta;
	}
	

}
