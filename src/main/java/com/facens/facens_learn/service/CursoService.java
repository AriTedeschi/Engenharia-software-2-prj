package com.facens.facens_learn.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facens.facens_learn.controller.DTO.CursoDTO;
import com.facens.facens_learn.controller.DTO.QuestionarioRespostaDTO;
import com.facens.facens_learn.controller.forms.NovoCursoForm;
import com.facens.facens_learn.model.*;
import com.facens.facens_learn.repository.CursoRepository;
import com.facens.facens_learn.repository.InscricaoRepository;

@Service
public class CursoService {
	
	@Autowired private CursoRepository repository;
	@Autowired private InscricaoRepository inscricaoRepository;
		
	public void setRepository(CursoRepository repository) {
		this.repository = repository;
	}

	public void setInscricaoRepository(InscricaoRepository inscricaoRepository) {
		this.inscricaoRepository = inscricaoRepository;
	}

	public double finalizar(Inscricao inscricao, QuestionarioRespostaDTO resposta) throws Exception {
		Curso curso = obterCurso(resposta.getIdCurso());
		double pontuacao = 0;
		Questionario questionario = curso.getQuestionario();
		for(int i=0;i<questionario.getQuestoes().size();i++) {
			Questao q = questionario.getQuestoes().get(i);
			pontuacao += ( q.getResposta() == resposta.getRespostas().get(i))
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
	
	public Curso obterCurso(Long id) throws Exception {
		Optional<Curso> opt = repository.findById(id);
		
		if(!opt.isPresent())
			throw new Exception("Curso com id :"+id+" não foi encontrado");
		
		return opt.get();
	}
	
	public List<Curso> obterCursosDisponiveis(Aluno aluno) {
		return inscricaoRepository.obterCursosDisponiveis(aluno.getId());
	}
	
	public List<Curso> obterCursosPendentes(Aluno aluno) {
		return inscricaoRepository.obterCursosPendentes(aluno.getId());
	}

	public CursoDTO inserir(@Valid NovoCursoForm dto) {
		Curso novoCurso = new Curso();
		novoCurso.setNome(dto.getNome());
		novoCurso.setDescricao(dto.getDescricao());
		novoCurso.setDataLancamento(dto.getDataLancamento());
		novoCurso.adicionarCategoria(dto.getCategoria());
		novoCurso.adicionarCargaHoraria(dto.getCargaHoraria());
		
		novoCurso = repository.save(novoCurso);
		return new CursoDTO(novoCurso);
	}

	public CursoDTO obterCursoPorId(Long id) throws Exception {
		return new CursoDTO(obterCurso(id));
	}

	public List<CursoDTO> obterTodos() {
		return repository.findAll().stream().map(c -> new CursoDTO(c)).collect(Collectors.toList());
	}
}
