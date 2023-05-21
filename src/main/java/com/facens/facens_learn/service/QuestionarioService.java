package com.facens.facens_learn.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.facens_learn.controller.DTO.QuestionarioDTO;
import com.facens.facens_learn.controller.forms.NovaQuestaoForm;
import com.facens.facens_learn.model.*;
import com.facens.facens_learn.repository.QuestionarioRepository;

@Service
public class QuestionarioService {

	@Autowired private QuestionarioRepository repository;
	@Autowired private CursoService cursoService;
	@Autowired private QuestaoService questaoService;
		
	public void setRepository(QuestionarioRepository repository) {
		this.repository = repository;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public void setQuestaoService(QuestaoService questaoService) {
		this.questaoService = questaoService;
	}
	
	
	public Questionario obter(Long id) throws Exception {
		Optional<Questionario> opt = repository.findById(id);
		
		if(!opt.isPresent())
			throw new Exception("Questionario com id :"+id+" não foi encontrado");
		
		return opt.get();
	}
	
	public Questionario obterPorCurso(Long idCurso) throws Exception {
		Questionario questionario = cursoService.obterCurso(idCurso).getQuestionario();
		
		if(questionario == null)
			throw new Exception("Questionario não foi encontrado");
		
		return questionario;
	}

	public QuestionarioDTO inserirQuestao(@Valid NovaQuestaoForm dto, Long idCurso) throws Exception {
		Questionario questionario = obterPorCurso(idCurso);
		Questao questao = questaoService.inserirQuestao(dto, questionario);
		
		questionario.adicionarQuestao(questao);
		
		questionario = repository.save(questionario);
		return new QuestionarioDTO(questionario);
	}
}
