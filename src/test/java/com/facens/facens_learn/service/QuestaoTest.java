package com.facens.facens_learn.service;
import com.facens.facens_learn.controller.DTO.AlternativaDTO;
import com.facens.facens_learn.controller.forms.NovaQuestaoForm;
import com.facens.facens_learn.factory.QuestionarioFactory;
import com.facens.facens_learn.model.*;
import com.facens.facens_learn.repository.QuestaoRepository;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class QuestaoTest {
	
	@TestConfiguration
	static class QuestaoServiceTestConfiguration{
		@Bean
		public QuestaoService questaoService() {
			return new QuestaoService();
		}
	}
	
	@Autowired
	private QuestaoService servico;

    @MockBean
	private QuestaoRepository repository;
	
	private Questionario questionario ;
	private List<Alternativa> alternativas = new ArrayList<>();
	private NovaQuestaoForm dto;
	
	@Before
	public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
		
		this.servico.setRepository(repository);
		
		alternativas.add(new Alternativa("", "A"));
		alternativas.add(new Alternativa("", "B"));
		alternativas.add(new Alternativa("", "C"));
		alternativas.add(new Alternativa("", "D"));
	    
		questionario = new QuestionarioFactory()
	        .comQuestao("Pergunta 1", "A", 2.5,alternativas)
	        .comQuestao("Pergunta 2", "A", 2.5,alternativas)
	        .comQuestao("Pergunta 3", "A", 2.5,alternativas)
	        .comQuestao("Pergunta 4", "A", 2.5,alternativas)
	        .criar();

		 dto = new NovaQuestaoForm();
		    dto.setPergunta("Pergunta 5");
		    dto.setPeso(0);
		    dto.setResposta("C");
		    dto.setAlternativas(alternativas.stream().map(
		    		c -> new AlternativaDTO(c)).collect(Collectors.toList()));

	}

	@Test()
	public void deveRegistrar() {
		 Questao questao = new Questao();
		 questao.setPergunta(dto.getPergunta());
		 questao.setPeso(dto.getPeso());
		 questao.setResposta(dto.getResposta());
		 questao.setQuestionario(questionario);
		 
		 when(repository.save(any())).thenReturn(questao);
		 
		 Questao q = servico.inserirQuestao(dto, questionario);
		 assertTrue(q.getId() == questao.getId());
	}


}
