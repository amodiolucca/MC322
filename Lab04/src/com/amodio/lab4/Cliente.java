package com.amodio.lab4; //Pacote com.amodio.lab4
 
import java.util.*;

public class Cliente {
	// Declaração dos atributos
	private String nome;
	private String endereco;
	private LinkedList <Veiculo> listaVeiculos;
	double valorSeguro;
	
	// Construtor
	public Cliente(String nome, String endereco) {
		this.nome= nome;
		this.endereco = endereco;
		this.listaVeiculos = new LinkedList<>(); //LinkedList, pois faz a inserção de elementos de forma maia rápida
		this.valorSeguro = 0.0;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public String getDocumento() {
		return null;
	}

	public String getEndereco() {
		return endereco;
	}

	
	public LinkedList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}
	
	public Double getValorSeguro() {
		return valorSeguro;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	
	public void setListaVeiculos(LinkedList<Veiculo> lista) {
		this.listaVeiculos = lista;
	}

	// Métodos gerais
	
	/**
	 * Método que cadastra os veículos do cliente e retorna false caso o veículo já esteja cadastrado
	 * @param veiculo (Veiculo)
	 * @return boolean
	 */
	public boolean cadastraVeiculo (Veiculo veiculo, Seguradora seguradora) {
		if(!this.contemVeiculo(veiculo)) { //verifica se o veículo já está cadastrado pela função contém
			//o método contains faz a verificação por objeto, mas nesse caso, queremos comparar objetos diferentes mas equivalentes
			listaVeiculos.add(veiculo); //adiciona na lista
			this.setValorSeguro(seguradora.calcularPrecoSeguroCliente(this)); //atualiza o valor do seguro
			return true;
		}
		return false;
	}
	
	/**
	 * Método que remove veículos do cliente, desde que estejam na lista anteriormente
	 * @param veiculo (Veiculo)
	 * @return boolean
	 */
	public boolean removeVeiculo (String placa, Seguradora seguradora) { 
		for(Veiculo v:listaVeiculos) {
			if(v.getPlaca().equals(placa)) {
				listaVeiculos.remove(v);
				this.setValorSeguro(seguradora.calcularPrecoSeguroCliente(this)); //atualiza o valor do seguro
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que imprime a lista de veículos de maneira organizada
	 * @param lista (LinkedList<Veiculo>)
	 */
	public void imprimeListaVeiculos(LinkedList<Veiculo> lista) {
		
		if(listaVeiculos == null|| listaVeiculos.isEmpty()) {
			System.out.println("Nenhum veículo encontrado");
			return;
		}
		for(Veiculo v:lista) {
			System.out.println(v);
		}
	}
	/*
	 * Método que busca um veículo em determinado cliente e o retorna se econtrar
	 */
	public Veiculo buscarVeiculo(String modelo) {
		if(listaVeiculos == null|| listaVeiculos.isEmpty()) {
			return null;
		}
		for(Veiculo v: listaVeiculos) { //itera na lista
			if(v.getPlaca().equals(modelo)) { //se as placas são iguais
				return v; //retorna o veículo
			}
		}
		return null;
	}
	/*
	 * Método de calcular score para ser sobrescrito
	 */
	public double calculaScore() {
		return 0.0;
	}
	
	/*
	 * Método que verifica se o cliente contém o veículo, por comparação de placas
	 */
	public boolean contemVeiculo(Veiculo veiculo) {
		if(listaVeiculos== null|| listaVeiculos.isEmpty()) {
			return false;
		}
		for(Veiculo v: listaVeiculos) {
			if(v.getPlaca().equals(veiculo.getPlaca())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Cliente [Nome: " + nome + ", Endereço: " + endereco + "]";
	}


}
