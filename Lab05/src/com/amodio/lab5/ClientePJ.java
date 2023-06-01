package com.amodio.lab5; //Pacote com.amodio.lab5

import java.util.*;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private ArrayList<Frota> listaFrota;
	
	public ClientePJ ( String nome , String telefone, String endereco, String email, String cnpj , String dataFundacao) {
			// chama o construtor da superclasse
			super (nome, telefone, endereco, email);
				this . cnpj = cnpj ;
				this . dataFundacao = Validacao.parseDate(dataFundacao) ;
				this.listaFrota = new ArrayList<>();
	}

	//Getters e Setters
	public String getDocumento() {
		return cnpj;
	}

	public Date getDataFundacao () {
		return dataFundacao;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataFundacao = Validacao.parseDate(dataNascimento);
	}
	
	public boolean cadastraFrota() {
		return listaFrota.add(new Frota(this));
	}
	
	@Override
	public String toString() {
		return "ClientePJ [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CNPJ: " + cnpj + ", Data de Fundação: " + dataFundacao 
				+ ", Telefone: " + this.getTelefone() + ", E-mail: " + this.getEmail() +"]";
	}

		
		
}
