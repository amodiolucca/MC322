package com.amodio.lab4; //Pacote com.amodio.lab4


import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class ClientePF extends Cliente {
	//Declaração dos atributos
	private final String cpf ;
	private Date dataNascimento ;
	private String genero;
	private Date dataLicenca;
	private String educacao;
	private String classeEconomica;
	
	//Construtor
	public ClientePF ( String nome , String endereco , String dataLicenca ,
			String educacao , String genero , String classeEconomica ,
			String cpf , String dataNascimento ) {
			// chama o construtor da superclasse
			super (nome , endereco);
			if(validarCPF(cpf)) {
				this . cpf = cpf ;
				this . dataNascimento = Auxiliar.parseDate(dataNascimento) ;
				this.dataLicenca = Auxiliar.parseDate(dataLicenca);
				this.educacao = educacao;
				this.genero = genero;
				this.classeEconomica = classeEconomica;
			} else {
				this.cpf = null; //antes de adicionar o cliente nas listas, verificar se esse campo é null
			}
	}

	//Getters e Setters
	public String getCpf() {
		return cpf;
	}
		
	public Date getDataNascimento () {
		return dataNascimento;
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
		
	public void setDataLincenca(String dataLicenca) {
		this.dataLicenca = Auxiliar.parseDate(dataLicenca);
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
		
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = Auxiliar.parseDate(dataNascimento);
	}
		
	//Métodos gerais
	
	public double calculaScore() {
		
		int idade = calcula_idade();
		double fator_idade;
		
		if(idade>=18 && idade < 30) {
			fator_idade = CalcSeguro.FATOR_18_30.getValor();
		} else if(idade>=30 && idade <60) {
			fator_idade = CalcSeguro.FATOR_30_60.getValor();
		} else {
			fator_idade = CalcSeguro.FATOR_60_90.getValor();
		}
		return(CalcSeguro.VALOR_BASE.getValor()*fator_idade*getListaVeiculos().size());
	}

	@SuppressWarnings("deprecation")
	public int calcula_idade() {
		TimeZone localHorario = TimeZone.getTimeZone("America/Sao_Paulo");
		Calendar calendario = Calendar.getInstance(localHorario);
		Date data_atual = calendario.getTime();
		int diferenca_anos = data_atual.getYear() - dataNascimento.getYear();
		if((dataNascimento.getMonth()>data_atual.getMonth() )|| (dataNascimento.getMonth() == data_atual.getMonth() && dataNascimento.getDate()> data_atual.getDate())) {
			diferenca_anos --;
		}
		return diferenca_anos;
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

		digito_1 = calcula_digito1(cpf); // Obtém o primeiro dígito verificador do CPF a partir da função
		digito_2 = calcula_digito2(cpf, digito_1); // Obtém o segundo dígito verificador do CPF a partir da função

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
	private static int calcula_digito1(String cpf) {
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
	private static int calcula_digito2(String cpf, int digito1) {
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
	
	@Override
	public String toString() {
		return "ClientePF [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CPF:  " + cpf + ", Data de Nascimento: " + dataNascimento + ", Gênero: " + genero + ", Data de Licença: "
	+ dataLicenca + ", Educação: " + educacao + ", Classe Econômica: " + classeEconomica + "]";
	}	
}