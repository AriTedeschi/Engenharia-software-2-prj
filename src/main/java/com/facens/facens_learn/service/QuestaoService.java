package com.facens.facens_learn.service;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.facens_learn.controller.forms.NovaQuestaoForm;
import com.facens.facens_learn.model.*;
import com.facens.facens_learn.repository.QuestaoRepository;

@Service
public class QuestaoService {

	@Autowired private QuestaoRepository repository;
		
	public void setRepository(QuestaoRepository repository) {
		this.repository = repository;
	}

	public Questao inserirQuestao(@Valid NovaQuestaoForm dto, Questionario questionario) {
		Questao questao = new Questao();
		
		questao.setPergunta(dto.getPergunta());
		questao.setResposta(dto.getResposta());
		questao.setPeso(dto.getPeso());
		questao.setQuestionario(questionario);
		questao = repository.save(questao);
		return questao;
	}
}
