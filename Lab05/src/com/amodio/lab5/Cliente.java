package com.amodio.lab5; //Pacote com.amodio.lab5

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Cliente {
	// Declaração dos atributos
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Seguro> listaSeguros; //lista de seguros no cliente para que um seguro possa ser cancelado quando um
											//veículo ou frota são removidos, e para atualizar o valor mensal nesses casos	
	
	// Construtor
	public Cliente(String nome, String telefone, String endereco, String email) {
		this.nome= nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.listaSeguros = new ArrayList<>();
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}
	public abstract String getDocumento();

	public String getEndereco() {
		return endereco;
	}

	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ArrayList<Seguro> getListaSeguros () {
		return listaSeguros;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEmail(String email) {
		this.endereco = email;
	}
	
	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}
	
	/**
	 * Método para adicionar um Seguro na lista de seguros
	 * @param seguro (Seguro)
	 */
	public void adicionaSeguro(Seguro seguro) {
		listaSeguros.add(seguro);
	}
	/**
	 * Método que recalcula o valor de todos os seguros atrelados ao cliente
	 */
	public void recalculaValoresSeguro() {
		if(listaSeguros == null || listaSeguros.isEmpty()) {
			return;
		}
		for(Seguro s:listaSeguros) {
			s.setValorMensal(s.calcularValor()/12);
		}
	}
	
	public abstract boolean listarVeiculos();
	
	public abstract LinkedList<Veiculo> getListaVeiculos();
	
	public abstract Veiculo buscarVeiculo(String placa);

	@Override
	public String toString() {
		return "Cliente [Nome: " + nome + ", Telefone: " + telefone + ", Endereço: " + endereco + ", Email: " + email + "]";
	}
	
	
	


}
