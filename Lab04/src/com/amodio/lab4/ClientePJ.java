package com.amodio.lab4; //Pacote com.amodio.lab4

import java.util.*;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientePJ ( String nome , String endereco , String cnpj , String dataFundacao, int qtdeFuncionarios ) {
			// chama o construtor da superclasse
			super (nome , endereco);
				this . cnpj = cnpj ;
				this . dataFundacao = Validacao.parseDate(dataFundacao) ;
				this.qtdeFuncionarios = qtdeFuncionarios;
	}

	//Getters e Setters
	public String getDocumento() {
		return cnpj;
	}

	public Date getDataFundacao () {
		return dataFundacao;
	}
	
	public int getQntdeFuncionarios() {
		return qtdeFuncionarios;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataFundacao = Validacao.parseDate(dataNascimento);
	}
	
	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
		
	//Métodos gerais
	
	/*
	 * Método que calcula o score de determinado clientePJ
	 */
	public double calculaScore() {
		
		if (this.getListaVeiculos()==null) {
			return 0.0;
		}
		return CalcSeguro.VALOR_BASE.getValor()*(1+(qtdeFuncionarios)/100.0)*this.getListaVeiculos().size();
	}
	

	@Override
	public String toString() {
		return "ClientePJ [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CNPJ: " + cnpj + ", Data de Fundação: " + dataFundacao 
				+ ", Quantidade de funcionários:  "+ qtdeFuncionarios +"]";
	}

		
		
}
