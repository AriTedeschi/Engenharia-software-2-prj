package com.facens.facens_learn.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "questao")
public class Questao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pergunta;
	private String resposta;
	private double peso;
	
	@ManyToOne
    @JoinColumn(name ="questionario_id")
    private Questionario questionario;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "questao_id")
	private List<Alternativa> alternativas = new ArrayList<>();
	public Questao() {}
	public Questao(String pergunta,String resposta,double peso) {
		this.pergunta=pergunta;
		this.resposta=resposta;
		this.peso=peso;
	}
	
	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public void setPergunta(String pergunta) {
		this.pergunta=pergunta;
	}
	public String getPergunta() {
		return this.pergunta;
	}
	
	public void setResposta(String resposta) {
		this.resposta=resposta;
	}
	public String getResposta() {
		return this.resposta;
	}
	public void adicionarAlternativa(String resposta, String corpo) {
		this.alternativas.add(new Alternativa(resposta, corpo));
	}
	public List<Alternativa> getAlternativas() {
		return alternativas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	
}
