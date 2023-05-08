package com.facens.facens_learn.service;

import java.util.List;

import com.facens.facens_learn.model.*;
import com.facens.facens_learn.repository.CursoRepository;
import com.facens.facens_learn.repository.InscricaoRepository;

public class CursoService {
	
	private CursoRepository repository;
	private InscricaoRepository inscricaoRepository;
	
	public double finalizar(Inscricao inscricao, Questionario questionario) {
		Curso curso = inscricao.getCurso();
		double pontuacao = 0;
		
		for(int i=0;i<curso.getQuestoes().size();i++) {
			Questao q = curso.getQuestoes().get(i);
			pontuacao += ( q.getResposta() == questionario.getRespostas().get(i))
					 ? q.getPeso()
					 : 0;
		}
		
		if(pontuacao > 7)
			liberarCursosNovos(inscricao.getInscrito());
		
		return pontuacao;
	}
	
	public void liberarCursosNovos(Aluno aluno) {
		List<Curso> cursos = obterCursosDisponiveis(aluno);
		for(Curso curso : cursos) {
			inscricaoRepository.save(new Inscricao(aluno, curso));
		}
	}
	
	public List<Curso> obterCursosDisponiveis(Aluno aluno) {
		return repository.obterCursosDisponiveis(aluno);
	}
	
	public List<Curso> obterCursosPendentes(Aluno aluno) {
		return repository.obterCursosPendentes(aluno);
	}
}
