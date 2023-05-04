package com.amodio.lab4; //Pacote com.amodio.lab4

import java.util.*;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private int qtdeFuncionarios;
	
	public ClientePJ ( String nome , String endereco , String cnpj , String dataFundacao, int qtdeFuncionarios ) {
			// chama o construtor da superclasse
			super (nome , endereco);
			if(validarCNPJ(cnpj)) {
				this . cnpj = cnpj ;
				this . dataFundacao = Auxiliar.parseDate(dataFundacao) ;
				this.qtdeFuncionarios = qtdeFuncionarios;
			} else {
				this.cnpj = null; //antes de adicionar o cliente nas listas, verificar se esse campo é null
			}
	}

	//Getters e Setters
	public String getCnpj() {
		return cnpj;
	}

	public Date getDataFundacao () {
		return dataFundacao;
	}
	
	public int getQntdeFuncionarios() {
		return qtdeFuncionarios;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataFundacao = Auxiliar.parseDate(dataNascimento);
	}
	
	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}
		
	//Métodos gerais
	
	public double calculaScore() {
		return CalcSeguro.VALOR_BASE.getValor()*(1+(qtdeFuncionarios)/100)*this.getListaVeiculos().size();
	}
	
	
	/**
	 * Método que verifica se determinado CNPJ é válido
	 * @param cnpj (String)
	 * @return boolean
	 */
	public static boolean validarCNPJ(String cnpj) { //public pois precisamos chamar na main
		char primeiro_caractere, caractere; // Declaração das variáveis
		int digito_1, digito_2; // Declaração das variáveis
		primeiro_caractere = cnpj.charAt(0); // Pega o primeiro caractere da string CNPJ
		cnpj = cnpj.replaceAll("[^0-9]", ""); // Deixa o CNPJ apenas com algarismos
		if (cnpj.length() != 14) { // Se o tamanho do CNPJ for diferente de 11, é inválido
			return false;
		}
		for (int i = 1; i < 14; i++) { // Verifica se todos os algarismos são iguais. Se forem, o CNPJ é inválido
			caractere = cnpj.charAt(i); // Pega 1 caractere por iteração
			if (caractere != primeiro_caractere) { // Compara esse caractere com o primeiro, e se forem diferentes, sai
													// do laço
				break;
			}
			if (i == 13) { // Se chegar no último algarismo e não tiver saído do laço, todos os algasrismos
							// são iguais, e portanto, o CNPJ é inválido
				return false;
			}
		}
		digito_1 = calcula_digito1(cnpj); // Obtém o primeiro dígito verificador do CNPJ a partir da função
		digito_2 = calcula_digito2(cnpj, digito_1); // Obtém o segundo dígito verificador do CNPJ a partir da função
		if (digito_1 == Character.getNumericValue(cnpj.charAt(12))
				&& digito_2 == Character.getNumericValue(cnpj.charAt(13))) { // Verifica se os 2 dígitos verificadores correspondem aos dígitos do CNPJ. Se forem, o CNPJ é válido
			return true;
		}
		return false; // Se a condição acima não for satisfeita, o CNPJ é inválido
	}

	/**
	 * Método que calcula o primeiro dígito verificador esperado para o CNPJ
	 * @param cnpj (String)
	 * @return digito1 (int)
	 */

	private static int calcula_digito1(String cnpj) {
		int algarismo, soma = 0; // Declaração das variáveis
		char caractere; // Declaração das variáveis
		for (int j = 0; j < 4; j++) {
			caractere = cnpj.charAt(j); // Pega 1 algarismo por iteração a partir do primeiro do CNPJ
			algarismo = Character.getNumericValue(caractere); // Converte para int para as operações matemáticas
			soma += algarismo * (5 - j); // Multiplica o algarismo por 5 subtraído de sua posição no CPF e adiciona o valor na variável acumuladora
		}

		for (int k = 0; k < 8; k++) {
			caractere = cnpj.charAt(k+4); // Pega 1 algarismo por iteração a partir do primeiro do CNPJ
			algarismo = Character.getNumericValue(caractere); // Converte para int para as operações matemáticas
			soma += algarismo * (9 - k); // Multiplica o algarismo por 9 subtraído de sua posição no CPF e adiciona o valor na variável acumuladora
		}

		if (soma % 11 < 2) { // Se o resto da divisão da acumuladora por 11 for menor que 2, o primeiro algarismo verificador é 0
			return 0;
		} else {
			return (11 - (soma % 11)); // Caso contrário, é 11 subtraído do resto da divisão por 11
		}
	}

	/**
	 * Método que calcula o segundo dígito verificador esperado para o CNPJ
	 * @param cpf (String)
	 * @param digito1 (int)
	 * @return digito2 (int)
	 */

	private static int calcula_digito2(String cpf, int digito1) {
		int algarismo, soma = 0; // Declaração das variáveis
		char caractere; // Declaração das variáveis
		for (int j = 0; j < 5; j++) {
			caractere = cpf.charAt(j);
			algarismo = Character.getNumericValue(caractere); // Converte para int para as operações matemáticas
			soma += algarismo * (6 - j);
		}
		for (int k = 0; k < 7; k++) {
			caractere = cpf.charAt(k+5);
			algarismo = Character.getNumericValue(caractere); // Converte para int para as operações matemáticas
			soma += algarismo * (9 - k);
		}

		soma += 2 * digito1; // Adiciona o dígito1 multiplicado por 2 na variável acumuladora

		if (soma % 11 < 2) { // Se o resto da divisão da acumuladora por 11 for menor que 2, o segundo algarismo verificador é 0
			return 0;
		} else {
			return (11 - (soma % 11)); // Caso contrário, é 11 subtraído do resto da divisão por 11
		}
	}

	@Override
	public String toString() {
		return "ClientePJ [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CNPJ: " + cnpj + ", Data de Fundação: " + dataFundacao 
				+ ", Quantidade de funcionários:  "+ qtdeFuncionarios +"]";
	}

		
		
}
