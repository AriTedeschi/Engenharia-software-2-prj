package com.facens.facens_learn.model.VO.Curso;

import javax.persistence.Embeddable;

@Embeddable
public class CargaHoraria {

	private Integer cargaHoraria;
	
	public CargaHoraria() {}
	public CargaHoraria(Integer cargaHoraria) {
		if (cargaHoraria == null  || 
				cargaHoraria < 0) {
            throw new IllegalArgumentException("Carga Horária inválida!");
        }

        this.cargaHoraria = cargaHoraria;
		
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	
	
}
