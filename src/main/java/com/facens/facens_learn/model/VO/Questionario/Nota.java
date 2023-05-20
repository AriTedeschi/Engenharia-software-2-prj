package com.facens.facens_learn.model.VO.Questionario;

import java.math.BigDecimal;

public class Nota {
	private BigDecimal nota;

    public Nota(String nota) {
        if ( nota != null || 
				!nota.matches("^(10(\\.0+)?|[0-9](\\.[0-9]+)?)$")) {
            throw new IllegalArgumentException("Nota inválida!");
        }

        this.nota = new BigDecimal(nota);
    }

    public Nota(BigDecimal nota) {
        if ( nota != null || 
				!nota.toString().matches("^(10(\\.0+)?|[0-9](\\.[0-9]+)?)$")) {
            throw new IllegalArgumentException("Nota inválida!");
        }

        this.nota = nota;
    }

    public BigDecimal getNota() {
        return nota;
    }
}
