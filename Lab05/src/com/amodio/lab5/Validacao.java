package com.amodio.lab5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Validacao {
	/**
	 * Método que converte uma String de data para o tipo Date
	 * @param data
	 * @return Date com a data de interesse formatada
	 */
	public static Date parseDate(String data) { 
		try {
			Date data_modificada= new SimpleDateFormat("yyyy-MM-dd").parse(data);
			return data_modificada;
		} catch(ParseException e){
			return null;
		}
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
		digito_1 = calcula_digito1_CNPJ(cnpj); // Obtém o primeiro dígito verificador do CNPJ a partir da função
		digito_2 = calcula_digito2_CNPJ(cnpj, digito_1); // Obtém o segundo dígito verificador do CNPJ a partir da função
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

	private static int calcula_digito1_CNPJ(String cnpj) {
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

	private static int calcula_digito2_CNPJ(String cpf, int digito1) {
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
	
	
	/**
	 * Método que verifica se o Cadastro de Pessoa Física informado é válido de
	 * acordo com as restrições
	 * 
	 * @param cpf (String)
	 * @return boolean
	 */
	public static boolean validarCPF(String cpf) { //public pois precisamos chamar na main
		char primeiro_caractere, caractere; // Declaração das variáveis
		int digito_1, digito_2; // Declaração das variáveis
		primeiro_caractere = cpf.charAt(0); // Pega o primeiro caractere da string CPF
		cpf = cpf.replaceAll("[^0-9]", ""); // Deixa o CPF apenas com algarismos
		if (cpf.length() != 11) { // Se o tamanho do CPF for diferente de 11, é inválido
			return false;
		}
		for (int i = 1; i < 11; i++) { // Verifica se todos os algarismos são iguais. Se forem, o CPF é inválido
			caractere = cpf.charAt(i); // Pega 1 caractere por iteração
			if (caractere != primeiro_caractere) { // Compara esse caractere com o primeiro, e se forem diferentes, sai
													// do laço
				break;
			}
			if (i == 10) { // Se chegar no último algarismo e não tiver saído do laço, todos os algasrismos
							// são iguais, e portanto, o CPF é inválido
				return false;
			}
		}

		digito_1 = calcula_digito1_CPF(cpf); // Obtém o primeiro dígito verificador do CPF a partir da função
		digito_2 = calcula_digito2_CPF(cpf, digito_1); // Obtém o segundo dígito verificador do CPF a partir da função

		if (digito_1 == Character.getNumericValue(cpf.charAt(9))
				&& digito_2 == Character.getNumericValue(cpf.charAt(10))) { // Verifica se os 2 dígitos verificadores
																			// correspondem aos dígitos do CPF. Se
																			// forem, o CPF é válido
			return true;
		}
		return false; // Se a condição acima não for satisfeita, o CPF é inválido
	}

	/**
	 * Método que calcula o primeiro dígito que um Cadastro de Pessoa Física deveria
	 * conter com base nos 9 anteriores
	 * 
	 * @param cpf (String)
	 * @return digito_1 (int)
	 */
	private static int calcula_digito1_CPF(String cpf) {
		int algarismo, soma = 0; // Declaração das variáveis
		char caractere; // Declaração das variáveis
		for (int j = 0; j < 9; j++) {
			caractere = cpf.charAt(j); // Pega 1 algarismo por iteração a partir do primeiro do CPF
			algarismo = Character.getNumericValue(caractere); // Converte para int para as operações matemáticas
			soma += algarismo * (10 - j); // Multiplica o algarismo por 10 subtraído de sua posição no CPF e adiciona o
											// valor na variável acumuladora
		}
		if (soma % 11 < 2) { // Se o resto da divisão da acumuladora por 11 for menor que 2, o primeiro
								// algarismo verificador é 0
			return 0;
		} else {
			return (11 - (soma % 11)); // Caso contrário, é 11 subtraído do resto da divisão por 11
		}
	}

	/**
	 * Método que calcula o segundo dígito que um Cadastro de Pessoa Física deveria
	 * conter com base nos 10 anteriores
	 * 
	 * @param cpf     (String)
	 * @param digito1 (int)
	 * @return digito2 (int)
	 */
	private static int calcula_digito2_CPF(String cpf, int digito1) {
		int algarismo, soma = 0; // Declaração das variáveis
		char caractere; // Declaração das variáveis
		for (int k = 0; k < 9; k++) {
			caractere = cpf.charAt(k); // Pega 1 algarismo por iteração a partir do primeiro do CPF
			algarismo = Character.getNumericValue(caractere); // Converte para int para as operações matemáticas
			soma += algarismo * (11 - k); // Multiplica o algarismo por 11 subtraído de sua posição no CPF e adiciona o
											// valor na variável acumuladora
		}
		soma += 2 * digito1; // Adiciona o dígito1 multiplicado por 2 na variável acumuladora

		if (soma % 11 < 2) { // Se o resto da divisão da acumuladora por 11 for menor que 2, o segundo
								// algarismo verificador é 0
			return 0;
		} else {
			return (11 - (soma % 11)); // Caso contrário, é 11 subtraído do resto da divisão por 11
		}
	}
	/*
	 * Método que verifica se a data está no formato yyyy-mm-dd e se não é uma data futura
	 */
	public static boolean validaData(String data) {
		Date dataModificada = parseDate(data); //tenta converter para date
		if(dataModificada == null) {
			return false;
		}
		TimeZone localHorario = TimeZone.getTimeZone("America/Sao_Paulo");
		Calendar calendario = Calendar.getInstance(localHorario);
		Date data_atual = calendario.getTime();
		if(data_atual.getTime()<dataModificada.getTime()) { // se for data futura
			return false; //retorna false
		} 
		return true;
	}
	
	/*
	 * Método que verifica se o nome possui apenas letras
	 */
	public static boolean validaNome(String nome) {
		int tamanho = nome.length();
		if(nome == null || nome == "") {
			return false;
		}
		for(int i=0;i<tamanho;i++) { //pra cada caracter
			if(Character.isDigit(nome.charAt(i))) { //verifica se é letra
				return false;
			}
		}
		return true;
	}
	
/*
 * Método que verifica se a idade do cliente está entre 18 e 90 anos
 */
	@SuppressWarnings("deprecation")
	public static boolean validaNascimento(String data_Nascimento) {
		TimeZone localHorario = TimeZone.getTimeZone("America/Sao_Paulo");
		Calendar calendario = Calendar.getInstance(localHorario);
		Date data_atual = calendario.getTime();
		Date dataNascimento = parseDate(data_Nascimento);
		int diferenca_anos = data_atual.getYear() - dataNascimento.getYear(); //Diferença entre os anos
		if((dataNascimento.getMonth()>data_atual.getMonth() )|| (dataNascimento.getMonth() == data_atual.getMonth() && dataNascimento.getDate()> data_atual.getDate())) {
			diferenca_anos --;
		}
		if(diferenca_anos<18 || diferenca_anos>90) {
			return false;
		}
		return true;
	}
}
