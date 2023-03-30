package com.amodio.lab3; //Pacote com.amodio.lab3

public class Seguradora {
	//Declaração dos atributos
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;

 // Construtor
	public Seguradora ( String nome , String telefone , String email , String endereco ) {
		this . nome = nome ;
		this . telefone = telefone ;
		this . email = email ;
		this . endereco = endereco ;
	}

// Getters e setters
	public String getNome () {
		return nome ;
	}

	public void setNome ( String nome ) {
		this . nome = nome ;
	}

	public String getTelefone () {
		return telefone ;
	}

	public void setTelefone ( String telefone ) {
		this . telefone = telefone ;
	}

	public String getEmail () {
		return email ;
	}

	public void setEmail ( String email ) {
		this . email = email ;
	}

	public String getEndereco () {
		return endereco ;
	}

	public void setEndereco ( String endereco ) {
		this . endereco = endereco ;
	}
	
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Seguradora [Nome = " + nome + ", Telefone = " + telefone + ", E-mail = " 
		+ email + ", Endereço = " + endereco+ "]";
	}

}