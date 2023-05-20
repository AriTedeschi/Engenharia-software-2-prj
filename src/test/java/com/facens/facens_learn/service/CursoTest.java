package com.facens.facens_learn.service;
import com.facens.facens_learn.model.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class CursoTest {
	
	private final CursoService servico = spy(CursoService.class);
	
	private Aluno aluno;
	private Curso curso;
	private Inscricao inscricao;
	private Questionario questionario ;
	
	@BeforeEach
	public void setup() {
		aluno = new Aluno();
		aluno.setNome("Rafael");
		
	    curso= new Curso();
	    curso.addQuestao(new Questao("A", 2.5))
		.addQuestao(new Questao("A", 2.5))
		.addQuestao(new Questao("A", 2.5))
		.addQuestao(new Questao("A", 2.5)); 
	    
	    inscricao = new Inscricao(aluno, curso);
	    questionario = new Questionario(curso, "A","A","A","B");
	}

	@Test()
    public void deveLiberarNovoCursoPorComprovarMediaAcimaDe7() {
	    List<Curso> cursosAntes = new ArrayList<>();
	    cursosAntes.add(curso);
	    
	    List<Curso> cursosDepois = new ArrayList<>();
	    cursosDepois.add(curso);
	    cursosDepois.add(new Curso()
	    		.addQuestao(new Questao("B", 2.5))
	    		.addQuestao(new Questao("B", 2.5))
	    		.addQuestao(new Questao("B", 2.5))
	    		.addQuestao(new Questao("B", 2.5)));
	    cursosDepois.add(new Curso()
	    		.addQuestao(new Questao("C", 2.5))
	    		.addQuestao(new Questao("C", 2.5))
	    		.addQuestao(new Questao("C", 2.5))
	    		.addQuestao(new Questao("C", 2.5)));
	    cursosDepois.add(new Curso()
	    		.addQuestao(new Questao("D", 2.5))
	    		.addQuestao(new Questao("D", 2.5))
	    		.addQuestao(new Questao("D", 2.5))
	    		.addQuestao(new Questao("D", 2.5)));
	    
	    when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursosAntes);
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursosDepois);
	    
	    double pontuacao = servico.finalizar(inscricao, questionario);
	    
	    assertTrue(	pontuacao > 7 && 
	    			(qtdCursos + 3) == servico.obterCursosDisponiveis(aluno).size()
	    		);
    }
	
	@Test()
    public void naoDeveLiberarNovoCursoPorComprovarMediaAbaixoDe7() {
		
		questionario = new Questionario(curso, "A","A","B","B");
		 List<Curso> cursosAntes = new ArrayList<>();
		    cursosAntes.add(curso);
		
		when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursosAntes); 
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    
	    double pontuacao = servico.finalizar(inscricao, questionario);
	    
	    assertTrue(	pontuacao < 7 && 
	    			qtdCursos == 1
	    		);
    }
	
	@Test()
    public void naoDeveLiberarNovoCursoEnquantoEstiverCursosPendentes() {
		    
	    double pontuacao = servico.finalizar(inscricao, questionario);
		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso);

		when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursos); 
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    
	    assertTrue(	pontuacao > 7 && 
	    			qtdCursos == 1
	    		);
    }
	
	@Test()
    public void deveListarCursosPendentesDoAluno() {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(curso);
		cursos.add(new Curso()
	    		.addQuestao(new Questao("B", 2.5))
	    		.addQuestao(new Questao("B", 2.5))
	    		.addQuestao(new Questao("B", 2.5))
	    		.addQuestao(new Questao("B", 2.5)));

		when(servico.obterCursosDisponiveis(aluno)).thenReturn(cursos); 
	    Integer qtdCursos = servico.obterCursosDisponiveis(aluno).size();
	    
	    assertTrue(qtdCursos == 2);
    }

}
