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
	/**
	 * Método que gera o Code da frota
	 * @param cliente
	 * @return
	 */
	private String gerarCode(ClientePJ cliente) {
		return cliente.getNome() + String.valueOf(numeroFrotas);
	}
	
	/**
	 * Método que adiciona um veículo na frota
	 * @param veiculo
	 * @return
	 */
	public boolean addVeiculo(Veiculo veiculo) {
		if (!listaVeiculos.contains(veiculo)) {
			listaVeiculos.add(veiculo);
			return true;
		}
		return false;
	}
	/**
	 * Método que remove um veículo da frota
	 * @param veiculo
	 * @return
	 */
	public boolean removeVeiculo(Veiculo veiculo) {
		if (listaVeiculos.contains(veiculo)) {
			listaVeiculos.remove(veiculo);
			return true;
		}
		return false;
	}
	/**
	 * Método que lista os veículos de uma frota
	 * @return
	 */
	public boolean listarVeiculos() {
		if(listaVeiculos == null || listaVeiculos.isEmpty()) {
			return false;
		}
		for(Veiculo v: listaVeiculos) {
			System.out.println(v);
		}
		return true;
	}

	@Override
	public String toString() {
		return "Frota [Code: " + code + "]";
	}
	
	
}
