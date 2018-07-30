package com.lanchonete.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Pedido {
	private Produto produto;
	private static int id;//contador de pedidos
	private int idPedido; 
	private int quantProduto;
	private LocalTime hora;
	private LocalDate data;
	private boolean atendido;//pedido atendido|nao atendido
	
	
	public Pedido(Produto produto, int quantProduto) {
		this.produto = produto;
		idPedido = ++id;
		this.quantProduto = quantProduto;
		this.hora = LocalTime.now();
		this.data = LocalDate.now();
		atendido = false;
	}
	public void setIdPedido(int novoId) {
		idPedido = novoId;
	}
	public int getIdPedido() {
		return idPedido;
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantProduto() {
		return quantProduto;
	}
	public void setQuantProduto(int quantProduto) {
		this.quantProduto = quantProduto;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public float getSubTotal() {
		return produto.getPrecoUni() * quantProduto;
	}
	public boolean isAtendido() {
		return atendido;
	}
	public void setAtendido(boolean atendido) {
		this.atendido = atendido;
	}
	@Override
	public String toString() {
		return "Pedido [produto=" + produto + ", idPedido=" + idPedido + ", quantProduto=" + quantProduto + ", hora="
				+ hora + ", data=" + data + ", subTotal=" + getSubTotal() + ", atendido=" + atendido + "]";
	}

	
}
