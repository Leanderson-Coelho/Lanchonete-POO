package com.lanchonete.model;

import java.util.ArrayList;

public class GerenciarMesa {
	private ArrayList<Comanda> comandas;
	
	public GerenciarMesa() {
		comandas = new ArrayList<>();
	}
//	adicionar uma nova comanda
	public boolean novaComanda(int mesa) {
		for(int i = 0;i<comandas.size();i++) {
			if(comandas.get(i).getMesa() == mesa)
				return false;
		}
		return comandas.add(new Comanda(mesa));
	}
	//retorna o indice da comanda da mesa que é passado
	//usa o retorno no metodo verPedido
	int getIndexOfComanda(int mesa) {
		for(int i = 0;i < comandas.size();i++) {
			if(comandas.get(i).getMesa() == mesa)
				return i;
		}
		return -1;
	}
//	retorna a comanda pela mesa
	Comanda getComanda(int mesa) {
		for(Comanda comanda : comandas) {
			if(comanda.getMesa() == mesa)
				return comanda;
		}
		return null;
	}
	public String verPedidos(int mesa) {
		if(getIndexOfComanda(mesa) != -1)
			return comandas.get(getIndexOfComanda(mesa)).toString();
		return "[Comanda inexistente]\n";
	}
	
	public boolean novoPedido(int mesa, Pedido novoPedido,Cozinha cozinha) {
		if(getComanda(mesa) != null){
			getComanda(mesa).addPedido(novoPedido);
			cozinha.addPedido(novoPedido);
			return true;
		}
		return false;
	}
//	encerra a comanda se todos os pedidos foram atendidos e adiciona a Gerencia
	public boolean encerrarComanda(int mesa) {
		for(Pedido pedido: getComanda(mesa).getPedidos()) {
			if(pedido.isAtendido() == false) {
				return false;
			}
		}
		getComanda(mesa).setAberta(false);
		Gerencia.addComanda(getComanda(mesa));	
		comandas.remove(getComanda(mesa));
		return true;
	}
//	Editar o pedido de uma comanda pela mesa
	public boolean mudarPedido(int mesa, int idPedido, Produto novoProduto, int quantProduto,Cozinha cozinha) {
		Comanda comanda = getComanda(mesa);
		if(comanda != null) {
			if(comanda.getPedidos().size() > 0) {
				for(Pedido pedido : comanda.getPedidos()) {
					if(pedido.getIdPedido() == idPedido) {
						if(pedido.isAtendido() == false) {
							pedido.setProduto(novoProduto);
							pedido.setQuantProduto(quantProduto);
							cozinha.mudarPedido(idPedido, novoProduto, quantProduto);
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	public boolean excluirPedido(int mesa, int idPedido, Cozinha cozinha) {
		int indice = 0;
		for(Pedido pedido : getComanda(mesa).getPedidos()) {
			indice++;
			if(pedido.getIdPedido() == idPedido) {
				if(pedido.isAtendido() == false) {
					getComanda(mesa).getPedidos().remove(indice-1);
					cozinha.removerPedido(idPedido);
					return true;
				}
			}
		}
		return false;
	}
//	retorna a comanda que tem o pedido com o idPedido passado
	Comanda ComandaIdPedido(int idPedido) {
		for(Comanda comanda : comandas) {
			for(Pedido pedido : comanda.getPedidos()) {
				if(pedido.getIdPedido() == idPedido) 
					return comanda;
			}
		}
		return null;
	}
	public ArrayList<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(ArrayList<Comanda> comandas) {
		this.comandas = comandas;
	}
	
}
