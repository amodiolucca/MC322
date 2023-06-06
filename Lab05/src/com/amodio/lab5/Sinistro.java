package com.amodio.lab5; //Pacote com.amodio.lab5

import java.util.Date;

public class Sinistro {
	//Declaração dos atributos
	private int id;
	private Date data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	


//Construtor
	public Sinistro(String data, String endereco, Condutor condutor, Seguro seguro) {
		this.data = Validacao.parseDate(data);
		this.endereco = endereco;
		this.id = gera_id();
		this.seguro = seguro;
		this.condutor = condutor;
	}
//Getters e Setters
	public int getId () {
		return id ;
	}
	public Date getData () {
		return data ;
	}
	public String getEndereco () {
		return endereco ;
	}
	
	public Seguro getSeguro() {
		return seguro;
	}
	
	
	public Condutor getCondutor() {
		return condutor;
	}
	//Implementação de um Setter para o ID, para caso a seguradora queira dar destaque a um sinistro em específico, atribuindo-lhe um ID específico.
	//Esse sinistro espec estaria com um ID aleatório anteriormente
	public void setId ( int id ) {
		this . id = id ;
	}
	public void setData ( String data ) {
		this . data = Validacao.parseDate(data) ;
	}
	public void setEndereco ( String endereco ) {
		this .endereco = endereco ;
	}
	
	public void setSeguro ( Seguro seguro ) {
		this .seguro = seguro ;
	}
	

	public void setCondutor ( Condutor condutor ) {
		this .condutor = condutor ;
	}
	
	//Métodos gerais
	
	/**
	 * Método que gera um ID aleatório para o Sinistro
	 * @return ID (int)
	 */
	public int gera_id() {
		return (int)Math.floor(Math.random() * (1001)); //Gera um ID aleatório de 0 a 1000
	}
	
	
	@Override
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Sinistro [ID: " + id + ", Data:  " + data + ", Endereço: " + endereco + ", Seguro: "+ "[" + seguro.getCliente() + ", " + seguro.getId() + "]"
				+ ", Condutor:  " + condutor.getNome() + "]";
	}
	
}
