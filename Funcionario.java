package com.lanchonete.model;

import java.time.LocalDate;

public class Funcionario {
	private String cpf;
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private LocalDate nascimento;
	private Setor setor;
	
	public Funcionario(String cpf, String nome, String email,String senha, String telefone, LocalDate nascimento, Setor setor) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.nascimento = nascimento;
		this.setor = setor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public String getSetor() {
		return setor.toString();
	}
	public void setSetor(Setor setor) {
		this.setor = setor;
	}
	@Override
	public String toString() {
		return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", nascimento=" + nascimento + ", setor=" + setor + "]";
	}
	
	
	
}
