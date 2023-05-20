package com.facens.facens_learn.factory;
import com.facens.facens_learn.model.Aluno;

public class AlunoFactory {
    private String ra;
    private String nome;
    private String email;
    private String senha;
    private String telefone;

    public AlunoFactory(String nome) {
        this.nome = nome;
    }

    public AlunoFactory comEmail(String email) {
        this.email = email;
        return this;
    }

    public AlunoFactory comSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public AlunoFactory comTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public AlunoFactory comRA(String ra) {
        this.ra = ra;
        return this;
    }

    public Aluno criar() {
        Aluno aluno = new Aluno();
        aluno.setNome(this.nome);
        aluno.adicionarEmail(this.email);
        aluno.setSenha(this.senha);
        aluno.adicionarTelefone(this.telefone);
        aluno.adicionarRA(this.ra);
        return aluno;
    }
}