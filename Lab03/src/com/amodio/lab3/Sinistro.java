package com.amodio.lab3; //Pacote com.amodio.lab3

public class Sinistro {
	//Declaração dos atributos
	private int id;
	private String data;
	private String endereco;


//Construtor
	public Sinistro(String data, String endereco) {
		this.data = data;
		this.endereco = endereco;
		this.id = gera_id();
	}
//Getters e Setters
	public int getId () {
		return id ;
	}
	public String getData () {
		return data ;
	}
	public String getEndereco () {
		return endereco ;
	}
	//Implementação de um Setter para o ID, para caso a seguradora queira dar destaque a um sinistro em específico, atribuindo-lhe um ID específico.
	//Esse sinistro espec estaria com um ID aleatório anteriormente
	public void setId ( int id ) {
		this . id = id ;
	}
	public void setData ( String data ) {
		this . data = data ;
	}
	public void setEndereco ( String endereco ) {
		this .endereco = endereco ;
	}
	
//Métodos gerais
	
	/**
	 * Método que gera um ID aleatório para o Sinistro
	 * @return ID (int)
	 */
	public int gera_id() {
		return (int)Math.floor(Math.random() * (1001)); //Gera um ID aleatório de 0 a 1000
	}
	
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Sinistro [ID = " + id + ", Data = " + data + ", Endereço = " + endereco + "]";
	}
}
