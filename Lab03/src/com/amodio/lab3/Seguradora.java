package com.amodio.lab3; //Pacote com.amodio.lab3

import java.util.*;

public class Seguradora {
	//Declaração dos atributos
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;
	LinkedList <Cliente> listaClientes;
	ArrayList <Sinistro> listaSinistros;

 // Construtor
	public Seguradora ( String nome , String telefone , String email , String endereco ) {
		this . nome = nome ;
		this . telefone = telefone ;
		this . email = email ;
		this . endereco = endereco ;
		this.listaSinistros = new ArrayList<>();
		this.listaClientes = new LinkedList<>();
		
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

	public LinkedList<Cliente> getListaClientes () {
		return listaClientes ;
	}
	
	public ArrayList<Sinistro> getListaSinistros () {
		return listaSinistros ;
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
	
	public boolean cadastrarCliente(Cliente cliente) { //tem q usar o try?
		if (listaClientes.contains(cliente)==false) {
			if(cliente instanceof ClientePF && ((ClientePF) cliente).getCpf()!=null) {
				listaClientes.add(cliente);
				return true;
			}
			if(cliente instanceof ClientePJ && ((ClientePJ) cliente).getCnpj()!=null) {
				listaClientes.add(cliente);
				return true;
			}
		}
		return false;
	}
	
	public boolean removerCliente(Cliente cliente) {
		if(listaClientes.contains(cliente)) {
			listaClientes.remove(cliente);
			return true;
		}
		return false;
	}
	
	public LinkedList<Cliente> listarClientes(String cliente){
		LinkedList<Cliente> lista= new LinkedList<>();
		if(cliente == "ClientePJ") {
			for(Cliente c:listaClientes) {
				if (c instanceof ClientePJ){
					lista.add(c);
				}
			}
		} else if(cliente == "ClientePF") {
			for(Cliente c:listaClientes) {
				if (c instanceof ClientePF){
					lista.add(c);
				}
			}
		} else {
			return null; //se retornar null, o usuário digitou incorretamente, e na main deve ter uma impressão o alertando sobre
		}
		
		return lista;
	}
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Seguradora [Nome = " + nome + ", Telefone = " + telefone + ", E-mail = " 
		+ email + ", Endereço = " + endereco+ "]";
	}

}