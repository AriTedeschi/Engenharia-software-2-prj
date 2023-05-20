package com.facens.facens_learn.model.VO.Aluno;

public class Telefone {
	private String numero;

	public Telefone(String numero) {
		if (numero == null || 
				!numero.matches("^\\([1-9]{2}\\) 9?[6-9]{1}[0-9]{3}-[0-9]{4}$")) {
			throw new IllegalArgumentException("Telefone invalido!");
		}

		this.numero = numero;
	}
	
	public String getTelefone() {
		return numero;
	}
}
