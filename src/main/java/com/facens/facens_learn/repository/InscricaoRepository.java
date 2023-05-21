package com.facens.facens_learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.facens.facens_learn.model.Curso;
import com.facens.facens_learn.model.Inscricao;
public interface InscricaoRepository extends JpaRepository<Inscricao, Long>{	
	@Query("SELECT c FROM Inscricao i JOIN i.curso c WHERE i.inscrito.id = id_aluno AND i.finalizado = false")
	List<Curso> obterCursosPendentes(Long id_aluno);
	
	@Query("SELECT c FROM Inscricao i JOIN i.curso c WHERE i.inscrito.id = id_aluno AND c.id not in ( SELECT c.id FROM Curso c)")
	List<Curso> obterCursosDisponiveis(Long id_aluno);
}
