package com.amodio.lab2;

public class Sinistro {
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
	public void setId ( int id ) {
		this . id = id ;
	}
	public void setData ( String data ) {
		this . data = data ;
	}
	public void setEndereco ( String endereco ) {
		this .endereco = endereco ;
	}
	
//funções
	public int gera_id() {
		return (int)Math.floor(Math.random() * (1001));
	}
}


