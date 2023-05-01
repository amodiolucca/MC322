package com.amodio.lab3; //Pacote com.amodio.lab3

import java.util.Date;

public class Sinistro {
	//Declaração dos atributos
	private int id;
	private Date data;
	private String endereco;
	private Seguradora seguradora;
	private Cliente cliente;
	private Veiculo veiculo;


//Construtor
	public Sinistro(String data, String endereco, Seguradora seguradora, Cliente cliente, Veiculo veiculo) {
		this.data = Auxiliar.parseDate(data);
		this.endereco = endereco;
		this.id = gera_id();
		this.seguradora = seguradora;
		this.cliente = cliente;
		this.veiculo = veiculo;
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
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	//Implementação de um Setter para o ID, para caso a seguradora queira dar destaque a um sinistro em específico, atribuindo-lhe um ID específico.
	//Esse sinistro espec estaria com um ID aleatório anteriormente
	//O novo ID deve ser um valor fora do range convencional e apenas temporário, para não causar conflito
	public void setId ( int id ) {
		this . id = id ;
	}
	public void setData ( String data ) {
		this . data = Auxiliar.parseDate(data) ;
	}
	public void setEndereco ( String endereco ) {
		this .endereco = endereco ;
	}
	
	public void setSeguradora ( Seguradora seguradora ) {
		this .seguradora = seguradora ;
	}
	
	public void setCliente ( Cliente cliente ) {
		this.cliente = cliente ;
	}

	public void setVeiculo ( Veiculo veiculo ) {
		this .veiculo = veiculo ;
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
		return "Sinistro [ID: " + id + ", Data:  " + data + ", Endereço: " + endereco + ", " + seguradora
				+ ", " + cliente + ", " + veiculo + "]";
	}
	
}
