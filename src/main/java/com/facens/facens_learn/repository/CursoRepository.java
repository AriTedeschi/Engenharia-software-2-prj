package com.facens.facens_learn.repository;

import java.util.ArrayList;
import java.util.List;

import com.facens.facens_learn.model.Aluno;
import com.facens.facens_learn.model.Curso;

public class CursoRepository {	
	public static Curso obterCurso(Long id) {
		return new Curso("");
	}
	public static List obterCursosDisponiveis(Aluno aluno) {
		return new ArrayList<>();
	}
	public static List obterCursosPendentes(Aluno aluno) {
		return new ArrayList<>();
	}
}
