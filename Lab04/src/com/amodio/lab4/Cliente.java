package com.amodio.lab4; //Pacote com.amodio.lab4
 
import java.util.*;

public class Cliente {
	// Declaração dos atributos
	private String nome;
	private String endereco;
	private LinkedList <Veiculo> listaVeiculos;
	
	// Construtor
	public Cliente(String nome, String endereco) {
		this.nome= nome;
		this.endereco = endereco;
		this.listaVeiculos = new LinkedList<>(); //LinkedList, pois faz a inserção de elementos de forma maia rápida
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}


	public String getEndereco() {
		return endereco;
	}

	
	public LinkedList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	// Métodos gerais
	
	/**
	 * Método que cadastra os veículos do cliente e retorna false caso o veículo já esteja cadastrado
	 * @param veiculo (Veiculo)
	 * @return boolean
	 */
	public boolean cadastraVeiculo (Veiculo veiculo) {
		if(!listaVeiculos.contains(veiculo)) { //se não estiver na lista
			listaVeiculos.add(veiculo); //adiciona na lista
			return true;
		}
		return false;
	}
	
	/**
	 * Método que remove veículos do cliente, desde que estejam na lista anteriormente
	 * @param veiculo (Veiculo)
	 * @return boolean
	 */
	public boolean removeVeiculo (Veiculo veiculo) { 
		if(listaVeiculos.contains(veiculo)) { //se estiver na lista
			listaVeiculos.remove(veiculo); //remove
			return true;
		}
		return false;
	}
	
	/**
	 * Método que imprime a lista de veículos de maneira organizada
	 * @param lista (LinkedList<Veiculo>)
	 */
	public void imprimeListaVeiculos(LinkedList<Veiculo> lista) {
		for(Veiculo v:lista) {
			System.out.println(v);
		}
	}
	
	@Override
	public String toString() {
		return "Cliente [Nome: " + nome + ", Endereço: " + endereco + "]";
	}


}
