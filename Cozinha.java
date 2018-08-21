package com.lanchonete.model;

import java.util.ArrayList;

public class Cozinha{
	private ArrayList<Pedido> pedidos;
	
	public Cozinha() {
		pedidos = new ArrayList<>();
	}
	
	boolean addPedido(Pedido p) {
		return pedidos.add(p);
	}
	
	public boolean atenderPedido(GerenciarMesa gMesa,int idPedido) {
		if(gMesa.ComandaIdPedido(idPedido) != null) {
			gMesa.ComandaIdPedido(idPedido).editarPedidoAtendido(idPedido);
			for(int i = 0;i<pedidos.size();i++) {
				if(pedidos.get(i).getIdPedido() == idPedido) {
					pedidos.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	boolean removerPedido(int idPedido) {
		for(Pedido pedido : pedidos)
			if(pedido.getIdPedido() == idPedido) {
				pedidos.remove(pedido);
				return true;
			}
		return false;
	}
	
	//Mostrar os ids dos pedidos em aberto
	public void verIdPedidos() {
		System.out.print("id dos Pedidos abertos [ ");
		for(Pedido pedido : pedidos) {
			System.out.print(pedido.getIdPedido()+ ", ");
		}
		System.out.println("]");
	}
	boolean mudarPedido(int idPedido, Produto produto, int quantProduto) {
		for(Pedido pedido : pedidos) {
			if(pedido.getIdPedido() == idPedido) {
				pedido.setProduto(produto);
				pedido.setQuantProduto(quantProduto);
				return true;
			}
		}
		return false;
	}
	
//	adicionar metodo removerPedido
	
	public String verPedidosAbertos() {
		return pedidos.toString();
	}
	
	
	
	
}
