package com.facens.facens_learn.model.VO.Questionario;

public class Alternativa {
	private String codigoResposta;
	private String textoResposta;
		
	public Alternativa(String codigoResposta, String textoResposta) {
		this.codigoResposta = codigoResposta;
		this.textoResposta = textoResposta;
	}
	public String getCodigoResposta() {
		return codigoResposta;
	}
	public String getTextoResposta() {
		return textoResposta;
	}
	

}
