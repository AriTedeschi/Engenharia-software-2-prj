package com.facens.facens_learn.factory;

import com.facens.facens_learn.model.Alternativa;
import com.facens.facens_learn.model.Questao;
import com.facens.facens_learn.model.Questionario;

import java.util.ArrayList;
import java.util.List;

public class QuestionarioFactory {
    private List<Questao> questoes;

    public QuestionarioFactory() {
        this.questoes = new ArrayList<>();
    }

    public QuestionarioFactory comQuestao(String pergunta, String resposta, double peso, List<Alternativa> alternativas) {
        Questao questao = new Questao(pergunta, resposta, peso);
        for(Alternativa a : alternativas)
        	questao.adicionarAlternativa(a.getCodigoResposta(), a.getTextoResposta());
        this.questoes.add(questao);
        return this;
    }

    public Questionario criar() {
        Questionario questionario = new Questionario();
        questionario.setQuestoes(this.questoes);
        return questionario;
    }
}