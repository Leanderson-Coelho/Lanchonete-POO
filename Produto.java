package com.lanchonete.model;

public class Produto {
	private int codigo;
	private String nome;
	private String descricao;
	private float precoUni;

	public Produto(int codigo,String nome,String descricao,float precoUni){
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.precoUni = precoUni;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getPrecoUni() {
		return precoUni;
	}

	public void setPrecoUni(float precoUni) {
		this.precoUni = precoUni;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", precoUnitario=" + precoUni
				+ "]";
	}
	
}
