package com.facens.facens_learn.model;

import com.facens.facens_learn.model.VO.Aluno.Email;
import com.facens.facens_learn.model.VO.Aluno.RA;
import com.facens.facens_learn.model.VO.Aluno.Telefone;

public class Aluno {
	private Long id;
	private RA ra;
	private String nome;
	private Email email;
	private String senha;
	private Telefone telefone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Email getEmail() {
		return email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSenha() {
		return senha;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public RA getRA() {
		return ra;
	}
	public void adicionarEmail(String email) {
		this.email = new Email(email);
	}
	public void adicionarTelefone(String telefone) {
		this.telefone = new Telefone(telefone);
	}
	public void adicionarRA(String ra) {
		this.ra = new RA(ra);
	}
}
