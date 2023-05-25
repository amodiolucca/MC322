package com.amodio.lab5;

import java.util.ArrayList;
import java.util.Date;

public class Condutor {
	
	//Declaração dos atributos
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private Date dataNasc;
	private ArrayList<Sinistro> listaSinistros;
	
	//construtor
	public Condutor(String cpf, String nome, String telefone, String endereco, String email, String DataNasc) {
		this.cpf = cpf;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.dataNasc = Validacao.parseDate(DataNasc);
		this.listaSinistros = new ArrayList<>();
	}
	
	//getters e setters
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setDataNasc(String DataNasc) {
		this.dataNasc = Validacao.parseDate(DataNasc);
	}
	
	public void setListaSinistros(ArrayList<Sinistro> lista) {
		this.listaSinistros = lista;
	}
	
	public void adicionarSinistro(Sinistro sinistro) {
		listaSinistros.add(sinistro);
	}
}
