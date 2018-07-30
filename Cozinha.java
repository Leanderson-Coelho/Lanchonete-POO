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
	
	public boolean atenderPedido(Comanda comanda,int idPedido) {
		if(comanda.editarPedidoAtendido(idPedido)) {
			for(int i = 0;i<pedidos.size();i++) {
				if(pedidos.get(i).getIdPedido() == idPedido) {
					pedidos.remove(i);
					return true;
				}
			}
		}
		return false;
	}
	
//	adicionar metodo removerPedido
	
	public String verPedidosAbertos() {
		return pedidos.toString();
	}
	
	
	
	
}
