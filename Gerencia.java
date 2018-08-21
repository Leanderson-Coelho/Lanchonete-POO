package com.lanchonete.model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Gerencia {
	private static ArrayList<Comanda> comandas = new ArrayList<>();
	
	
	static boolean addComanda(Comanda comanda) {
		return comandas.add(comanda);
	}
//	verificar as comandas de um determinado periodo
	public static String gerenciarComandasIntervalo(LocalDate inicio, LocalDate fim) {
		ArrayList<Comanda> comandasPeriodo = new ArrayList<>();
		for(Comanda comanda : comandas) {
			if(comanda.getData().compareTo(inicio.plusDays(-1)) > 0 && comanda.getData().compareTo(fim.plusDays(1)) < 0) {
				comandasPeriodo.add(comanda);
			}
		}
		return comandasPeriodo.toString();
	}
	
	public static ArrayList<Comanda> getComandas() {
		return comandas;
	}

	public static void setComandas(ArrayList<Comanda> comandas) {
		Gerencia.comandas = comandas;
	}
	
	
}
