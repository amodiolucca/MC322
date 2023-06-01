package com.amodio.lab5;

import java.util.ArrayList;

public class Frota {
	//Decclaração dos atributos
	private String code;
	private ArrayList<Veiculo> listaVeiculos;
	private static int numeroFrotas;
	
	//Construtor
	public Frota(ClientePJ cliente) {
		this.listaVeiculos = new ArrayList<>();
		this.code = gerarCode(cliente);
		numeroFrotas ++;
	}
	
	//getters e setters
	public String getCode() {
		return code;
	}
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setListaVeiculos(ArrayList<Veiculo> lista) {
		this.listaVeiculos = lista;
	}
	
	private String gerarCode(ClientePJ cliente) {
		return cliente.getNome() + String.valueOf(numeroFrotas);
	}
	
	public boolean addVeiculo(Veiculo veiculo) {
		if (!listaVeiculos.contains(veiculo)) {
			listaVeiculos.add(veiculo);
			return true;
		}
		return false;
	}
	
	public boolean removeVeiculo(Veiculo veiculo) {
		if (listaVeiculos.contains(veiculo)) {
			listaVeiculos.remove(veiculo);
			return true;
		}
		return false;
	}
	
}
