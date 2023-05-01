package com.amodio.lab4; //Pacote com.amodio.lab4

public class Veiculo {
	//Declaração dos atributos
	private String placa;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	
	// Construtor
	public Veiculo( String placa , String marca , String modelo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	// Getters e Setters
	public String getPlaca() {
		return placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}

	public int getAnoFabricacao(){
		return anoFabricacao;
	}
	public void setPlaca (String placa) {
		this.placa = placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModelo (String modelo) {
		this.modelo = modelo;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Veiculo [Placa:  " + placa + ", Marca:  " + marca + ", Modelo:  " + modelo + "]";
	}
}
