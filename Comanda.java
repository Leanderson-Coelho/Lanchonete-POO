package com.lanchonete.model;

import java.util.ArrayList;

public class Comanda {
	private ArrayList<Pedido> pedidos;
	private boolean aberta;//comanda esta aberta|fechada
	private int mesa;

	public Comanda(boolean aberta,int mesa){
		pedidos = new ArrayList<>();
		this.aberta = aberta;
		this.mesa = mesa;
	}
	
	public boolean addPedido(Pedido novoPedido) {
		return pedidos.add(novoPedido);
	}
	
	float calcularTotalComanda() {
		float total = 0;
		for(Pedido p : pedidos) {
			total += p.getSubTotal();
		}
		return total;
	}
	
	boolean editarPedidoAtendido(int idPedido) {
		for(Pedido p: pedidos) {
			if(p.getIdPedido() == idPedido) {
				p.setAtendido(true);
				return true;
			}
		}
		return false;
	}

	public float getTotal() {
		return calcularTotalComanda();
	}

	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public boolean isAberta() {
		return aberta;
	}

	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	@Override
	public String toString() {
		return "Comanda da mesa "+ getMesa()+" [pedidos=" + pedidos + ",\n total=" + getTotal() + ", aberta=" + aberta + ", mesa=" + mesa + "]\n\n";
	}
	

}
