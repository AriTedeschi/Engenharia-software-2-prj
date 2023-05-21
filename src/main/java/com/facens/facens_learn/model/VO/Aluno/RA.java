package com.facens.facens_learn.model.VO.Aluno;

import javax.persistence.Embeddable;

@Embeddable
public class RA {
	private String ra;
	public RA() {}
    public RA(String ra) {
        if (ra == null  || 
				!ra.matches("^[0-9]{7}$")) {
            throw new IllegalArgumentException("Registro de aluno inválido!");
        }

        this.ra = ra;
    }

    public String getRA() {
        return ra;
    }
}
