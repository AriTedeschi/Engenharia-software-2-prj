package com.facens.facens_learn.service;
import com.facens.facens_learn.controller.DTO.QuestionarioRespostaDTO;
import com.facens.facens_learn.factory.AlunoFactory;
import com.facens.facens_learn.factory.CursoFactory;
import com.facens.facens_learn.factory.QuestionarioFactory;
import com.facens.facens_learn.model.*;
import com.facens.facens_learn.repository.CursoRepository;
import com.facens.facens_learn.repository.InscricaoRepository;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
public class CursoTest {
	
	@TestConfiguration
	static class CursoServiceTestConfiguration{
		@Bean
		public CursoService cursoService() {
			return new CursoService();
		}
	}
	
	@Autowired
	private CursoService servico;

    @MockBean
	private CursoRepository repository;
    
    @MockBean
    private InscricaoRepository inscricaoRepository;
	
	private Aluno aluno;
	private Curso curso;
	private Inscricao inscricao;
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
		
		this.servico.setInscricaoRepository(inscricaoRepository);
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
		
	    curso = new CursoFactory("Curso1")
	            .comDescricao("Descrição do Curso")
	            .comDataLancamento(LocalDate.now())
	            .comCargaHoraria(40)
	            .comCategoria("Categoria do Curso")
	            .comQuestionario(questionario)
	            .criar();
	    
	    inscricao = new Inscricao(aluno, curso);

	    when(repository.findById(any())).thenReturn(Optional.of(curso));
	}

	@Test()
    public void deveLiberarNovoCursoPorComprovarMediaAcimaDe7() throws Exception {
	    List<Curso> cursosAntes = new ArrayList<>();
	    cursosAntes.add(curso);
	    
	    List<Curso> cursosDepois = new ArrayList<>();
	    cursosDepois.add(curso);
	    
	    Curso curso2 = new CursoFactory("Curso2")
	            .comDescricao("Descrição do Curso")
	            .comDataLancamento(LocalDate.now())
	            .comCargaHoraria(50)
	            .comCategoria("Categoria do Curso")
	            .comQuestionario(questionario)
	            .criar();
	    cursosDepois.add(curso2);
	    
	    Curso curso3 = new CursoFactory("Curso3")
	            .comDescricao("Descrição do Curso")
	            .comDataLancamento(LocalDate.now())
	            .comCargaHoraria(50)
	            .comCategoria("Categoria do Curso")
	            .comQuestionario(questionario)
	            .criar();
	    cursosDepois.add(curso3);
	    
	    Curso curso4 = new CursoFactory("Curso4")
	            .comDescricao("Descrição do Curso")
	            .comDataLancamento(LocalDate.now())
	            .comCargaHoraria(50)
	            .comCategoria("Categoria do Curso")
	            .comQuestionario(questionario)
	            .criar();
	    cursosDepois.add(curso4);
	    
	    when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursosAntes);	    
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursosDepois);
	    
	    QuestionarioRespostaDTO resp = new QuestionarioRespostaDTO(null,"A","A","A","B");
	    double pontuacao = servico.finalizar(inscricao, resp);
	    
	    assertTrue(	pontuacao > 7 && 
	    			(qtdCursos + 3) == servico.obterCursosDisponiveis(aluno).size()
	    		);
    }
	
	@Test()
    public void naoDeveLiberarNovoCursoPorComprovarMediaAbaixoDe7() throws Exception {
		
		List<Curso> cursosAntes = new ArrayList<>();
		    cursosAntes.add(curso);

		when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursosAntes);
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    
	    QuestionarioRespostaDTO resp = new QuestionarioRespostaDTO(null,"A","A","B","B");
	    double pontuacao = servico.finalizar(inscricao, resp);
	    
	    assertTrue(	pontuacao < 7 && 
	    			qtdCursos == 1
	    		);
    }
	
	@Test()
    public void naoDeveLiberarNovoCursoEnquantoEstiverCursosPendentes() throws Exception {

		QuestionarioRespostaDTO resp = new QuestionarioRespostaDTO(null,"A","A","A","B");
	    double pontuacao = servico.finalizar(inscricao, resp);
		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso);

		when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursos); 
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    
	    assertTrue(	pontuacao > 7 && 
	    			qtdCursos == 1
	    		);
    }
	
	@Test()
    public void deveListarCursosPendentesDoAluno() throws Exception{

		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso);
	    
	    Curso curso2 = new CursoFactory("Curso2")
	            .comDescricao("Descrição do Curso")
	            .comDataLancamento(LocalDate.now())
	            .comCargaHoraria(50)
	            .comCategoria("Categoria do Curso")
	            .comQuestionario(questionario)
	            .criar();
	    cursos.add(curso2);

		when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursos); 
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    
	    assertTrue(qtdCursos == 2);
    }

}
