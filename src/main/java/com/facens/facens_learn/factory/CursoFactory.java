package com.facens.facens_learn.factory;

import com.facens.facens_learn.model.Curso;
import com.facens.facens_learn.model.Questionario;

import java.time.LocalDateTime;

public class CursoFactory {
    private String nome;
    private String descricao;
    private LocalDateTime dataLancamento;
    private Integer cargaHoraria;
    private String categoria;
    private Questionario questionario;

    public CursoFactory(String nome) {
        this.nome = nome;
    }
    
    public CursoFactory comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public CursoFactory comDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
        return this;
    }

    public CursoFactory comCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
        return this;
    }

    public CursoFactory comCategoria(String nomeCategoria) {
        this.categoria = nomeCategoria;
        return this;
    }

    public CursoFactory comQuestionario(Questionario questionario) {
        this.questionario = questionario;
        return this;
    }

    public Curso criar() {
        Curso curso = new Curso(this.nome);
        curso.setDescricao(this.descricao);
        curso.setDataLancamento(this.dataLancamento);
        curso.setCargaHoraria(this.cargaHoraria);
        curso.adicionarCategoria(this.categoria);
        curso.setQuestionario(this.questionario);
        return curso;
    }
}

