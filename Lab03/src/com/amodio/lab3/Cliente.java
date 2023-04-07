package com.amodio.lab3; //Pacote com.amodio.lab3

import java.text.ParseException; //pode usar?
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Cliente {
	// Declaração dos atributos
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;

	// Construtor
	public Cliente(String nome, String endereco,String dataLicenca, String educacao,String genero, String classeEconomica) {
		this.nome= nome;
		this.endereco = endereco;
		this.dataLicenca = parseDate(dataLicenca);
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}


	public String getEndereco() {
		return endereco;
	}

	public Date getDataLicenca() {
		return dataLicenca;
	}
	
	public String getEducacao() {
		return educacao;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getclasseEconomica() {
		return classeEconomica;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setDataLincenca(String dataLicenca) {
		this.dataLicenca = parseDate(dataLicenca);
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}

	// Métodos gerais
	
	protected Date parseDate(String data) { //verificar se pode ser protected pra usar no PF
		try {
			Date data_modificada= new SimpleDateFormat("yyyy-MM-dd").parse(data);
			return data_modificada;
		} catch(ParseException e){
			return null;
		}
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", endereco=" + endereco + ", dataLicenca=" + dataLicenca + ", educacao="
				+ educacao + ", genero=" + genero + ", classeEconomica=" + classeEconomica + "]";
	}
	
	

}
