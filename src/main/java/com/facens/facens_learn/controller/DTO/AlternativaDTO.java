package com.facens.facens_learn.controller.DTO;


import com.facens.facens_learn.model.Alternativa;

import io.swagger.annotations.ApiModelProperty;

public class AlternativaDTO {
	@ApiModelProperty(value = "Código da alternativa", example = "A")
	private String codigoResposta;
	@ApiModelProperty(value = "Texto da alternativa", example = "4")
	private String textoResposta;
	
	public AlternativaDTO(Alternativa alt) {
		this.codigoResposta=alt.getCodigoResposta();
		this.textoResposta= alt.getTextoResposta();
	}
	
	public String getCodigoResposta() {
		return codigoResposta;
	}
	public void setCodigoResposta(String codigoResposta) {
		this.codigoResposta = codigoResposta;
	}
	public String getTextoResposta() {
		return textoResposta;
	}
	public void setTextoResposta(String textoResposta) {
		this.textoResposta = textoResposta;
	}
	
	
}
