package com.lanchonete.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class GerenciarComanda {
	private ArrayList<Comanda> comandas;
	
	public GerenciarComanda() {
		comandas = new ArrayList<>();
	}
	
	public boolean novaComanda(Comanda novaComanda) {
		for(int i = 0;i<comandas.size();i++) {
			if(comandas.get(i).getMesa() == novaComanda.getMesa())
				return false;
		}
		return comandas.add(novaComanda);
	}
	//retorna o indice da comanda que é passada
	//usa o retorno no metodo verPedido
	int getIndexOfComanda(Comanda comanda) {
		for(int i = 0;i < comandas.size();i++) {
			if(comandas.get(i).getMesa() == comanda.getMesa())
				return i;
		}
		return -1;
	}
	
	public String verPedidos(Comanda comanda) {
		return comandas.get(getIndexOfComanda(comanda)).toString();
	}
	
	public boolean novoPedido(Comanda comanda, Pedido novoPedido,Cozinha cozinha) {
		if(comanda.addPedido(novoPedido)) {
			if(novoPedido.isAtendido()==false) {
				cozinha.addPedido(novoPedido);
			}
			return true;
		}
		return false;
	}
	
	
	public boolean encerrarComanda(Comanda comanda) {
		if(comanda.isAberta()) {
			comanda.setAberta(false);
			return true;
		}else {
			return false;
		}
	}
//	verificar as comandas de um determinado periodo
	public String gerenciarComandasIntervalo(LocalDate inicio, LocalDate fim) {
		ArrayList<Comanda> comandasPeriodo= new ArrayList<>();
		for(int i = 0;i<comandas.size();i++) {
			if(comandas.get(i).getPedidos().get(0).getData().compareTo(inicio.plusDays(-1))>0) {
				if(comandas.get(i).getPedidos().get(0).getData().compareTo(fim.plusDays(1))<0) {
					comandasPeriodo.add(comandas.get(i));
				}
			}
		}
		return comandasPeriodo.toString();
	}

	public ArrayList<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(ArrayList<Comanda> comandas) {
		this.comandas = comandas;
	}
	
}
