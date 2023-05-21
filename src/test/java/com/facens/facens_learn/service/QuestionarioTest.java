package com.facens.facens_learn.service;
import com.facens.facens_learn.controller.DTO.AlternativaDTO;
import com.facens.facens_learn.controller.DTO.CursoDTO;
import com.facens.facens_learn.controller.DTO.QuestionarioDTO;
import com.facens.facens_learn.controller.DTO.QuestionarioRespostaDTO;
import com.facens.facens_learn.controller.forms.NovaQuestaoForm;
import com.facens.facens_learn.factory.AlunoFactory;
import com.facens.facens_learn.factory.CursoFactory;
import com.facens.facens_learn.factory.QuestionarioFactory;
import com.facens.facens_learn.model.*;
import com.facens.facens_learn.repository.CursoRepository;
import com.facens.facens_learn.repository.InscricaoRepository;
import com.facens.facens_learn.repository.QuestionarioRepository;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class QuestionarioTest {
	
	@TestConfiguration
	static class QuestionarioServiceTestConfiguration{
		@Bean
		public QuestionarioService questionarioService() {
			return new QuestionarioService();
		}
	}
	
	@Autowired
	private QuestionarioService servico;

    @MockBean
	private QuestionarioRepository repository;
    
    @MockBean
    private CursoService cursoService;
    @MockBean
    private QuestaoService questaoService;
	
	private Aluno aluno;
	private Curso curso;
	private Questionario questionario ;
	private List<Alternativa> alternativas = new ArrayList<>();
	
	@Before
	public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
		aluno = new AlunoFactory("Rafael")
		        .comEmail("rafa@gmail.com")
		        .comSenha("senha123")
		        .comTelefone("(15) 99999-3333")
		        .comRA("1244000")
		        .criar();
		aluno.setNome("Rafael");
		
		this.servico.setCursoService(cursoService);
		this.servico.setRepository(repository);
		this.servico.setQuestaoService(questaoService);
		
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
		
	    curso = new CursoFactory("Curso1")
	            .comDescricao("Descrição do Curso")
	            .comDataLancamento(LocalDate.now())
	            .comCargaHoraria(40)
	            .comCategoria("Categoria do Curso")
	            .comQuestionario(questionario)
	            .criar();

	}

	@Test()
    public void deveRegistrarQuestao() throws Exception {
	    when(cursoService.obterCurso(any())).thenReturn(curso);
	    
	    Questionario questionario2 = new QuestionarioFactory()
		        .comQuestao("Pergunta 1", "A", 2.5,alternativas)
		        .comQuestao("Pergunta 2", "A", 2.5,alternativas)
		        .comQuestao("Pergunta 3", "A", 2.5,alternativas)
		        .comQuestao("Pergunta 4", "A", 2.5,alternativas)
		        .comQuestao("Pergunta 5", "C", 2.5,alternativas)
		        .criar();
	    
	    when(repository.save(any())).thenReturn(questionario2);	
	    
	    NovaQuestaoForm dto = new NovaQuestaoForm();
	    dto.setPergunta("Pergunta 5");
	    dto.setPeso(0);
	    dto.setResposta("C");
	    dto.setAlternativas(alternativas.stream().map(
	    		c -> new AlternativaDTO(c)).collect(Collectors.toList()));
	    
	    QuestionarioDTO q = servico.inserirQuestao(dto, curso.getId());
	    
	    assertTrue(q.getQuestoes().size() == questionario2.getQuestoes().size());
    }
	
	@Test(expected = Exception.class)
    public void naoDeveRegistrarQuestao() throws Exception {
		Curso curso2 = new CursoFactory("Curso1")
	            .comDescricao("Descrição do Curso")
	            .comDataLancamento(LocalDate.now())
	            .comCargaHoraria(40)
	            .comCategoria("Categoria do Curso")
	            .comQuestionario(null)
	            .criar();
	    when(cursoService.obterCurso(any())).thenReturn(curso2);
	    servico.obterPorCurso(curso2.getId());
    }
	
	@Test()
    public void deveRetornarQuestionario() throws Exception {
	    when(repository.findById(any())).thenReturn(Optional.of(questionario));
	    
	    Questionario q = servico.obter(questionario.getId());
	    
	    assertTrue(q.getId() == questionario.getId());
    }
	
	@Test(expected = Exception.class)
    public void naodeveRetornarQuestionario() throws Exception {
		when(repository.findById(any())).thenReturn(Optional.empty());
	    servico.obter(questionario.getId());
    }
	

}
