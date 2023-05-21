package com.facens.facens_learn.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.facens.facens_learn.controller.forms.NovoCursoForm;
import com.facens.facens_learn.factory.CursoFactory;
import com.facens.facens_learn.factory.QuestionarioFactory;
import com.facens.facens_learn.model.Alternativa;
import com.facens.facens_learn.model.Aluno;
import com.facens.facens_learn.model.Curso;
import com.facens.facens_learn.model.Questionario;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CursoControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objMapper;
	
	@Test
	public void deveRetornarPorId() throws Exception {
		mockMvc.perform(get("/cursos/1")).andExpect(status().isOk());
	}
	
	@Test
	public void deveRegistrar() throws Exception {
		Aluno aluno;
		Curso curso;
		Questionario questionario ;
		List<Alternativa> alternativas = new ArrayList<>();
		
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
		
		NovoCursoForm dto = new NovoCursoForm();
		dto.setNome(curso.getNome());
		dto.setCategoria(curso.getCategocia().getCategoria());
		dto.setDescricao(curso.getDescricao());
		dto.setDataLancamento(curso.getDataLancamento());
		dto.setCargaHoraria(curso.getCargaHoraria().getCargaHoraria());
		
		
		mockMvc.perform(post("/cursos")
				.contentType("application/json")
				.content(objMapper.writeValueAsString(dto))).andExpect(status().isCreated());
	}
}
