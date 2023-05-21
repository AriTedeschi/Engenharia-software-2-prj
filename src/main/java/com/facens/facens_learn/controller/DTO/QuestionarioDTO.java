package com.facens.facens_learn.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import com.facens.facens_learn.model.Questao;
import com.facens.facens_learn.model.Questionario;

public class QuestionarioDTO {
	List<QuestaoDTO> questoes = new ArrayList<>();
	
	public QuestionarioDTO(Questionario questionario) {
		for(Questao q : questionario.getQuestoes()) {
			questoes.add(new QuestaoDTO(q));
		}
	}

	public List<QuestaoDTO> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<QuestaoDTO> questoes) {
		this.questoes = questoes;
	}
}
