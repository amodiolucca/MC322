package com.amodio.lab2; //Pacote com.amodio.lab2

public class Cliente {
	//Declaração dos atributos
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Construtor
	public Cliente( String nome , String cpf , String dataNascimento, int idade, String endereco) {
		if(validarCPF(cpf)==true) { //verifica se o CPF é válido antes de criar o cliente
			this.nome = nome;
			this.cpf = cpf;
			this.dataNascimento = dataNascimento;
			this.idade = idade;
			this.endereco = endereco;
		}
	}
	
	// Getters e Setters
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
		
	public String getDataNascimento() {
		return dataNascimento;
	}

	public int getIdade() {
		return idade;
	}
	
	public String getEndereco( ) {
		return endereco;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}

	public void setCpf (String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento (String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setIdade (int idade) {
		this.idade = idade;
	}

	public void setEndereco (String endereco) {
		this.endereco = endereco;
	}

	//Métodos gerais
	
	/**
	 * Método que verifica se o Cadastro de Pessoa Física informado é válido de acordo com as restrições
	 * @param cpf (String)
	 * @return True ou False
	 */
	private boolean validarCPF(String cpf) {
		char primeiro_caractere, caractere; //Declaração das variáveis
		int digito_1, digito_2; //Declaração das variáveis
		primeiro_caractere = cpf.charAt(0); //Pega o primeiro caractere da string CPF
		cpf = cpf.replaceAll("[^0-9]", ""); //Deixa o CPF apenas com algarismos
		if (cpf.length() != 11){ //Se o tamanho do CPF for diferente de 11, é inválido
			return false;
		}
		for(int i=1;i<11;i++) { //Verifica se todos os algarismos são iguais. Se forem, o CPF é inválido
			caractere = cpf.charAt(i); //Pega 1 caractere por iteração
			if(caractere != primeiro_caractere) { //Compara esse caractere com o primeiro, e se forem diferentes, sai do laço
				break;
			}
			if(i==10) { //Se chegar no último algarismo e não tiver saído do laço, todos os algasrismos são iguais, e portanto, o CPF é inválido
				return false;
			}
		}
		
		digito_1 = calcula_digito1(cpf); //Obtém o primeiro dígito verificador do CPF a partir da função
		digito_2 = calcula_digito2(cpf, digito_1); //Obtém o segundo dígito verificador do CPF a partir da função
		
		if(digito_1 == Character.getNumericValue(cpf.charAt(9))&& digito_2 == 
				Character.getNumericValue(cpf.charAt(10))) { //Verifica se os 2 dígitos verificadores correspondem aos dígitos do CPF. Se forem, o CPF é válido
			return true;
		}
		return false; //Se a condição acima não for satisfeita, o CPF é inválido
	}

	/**
	 * Método que calcula o primeiro dígito que um Cadastro de Pessoa Física deveria conter com base nos 9 anteriores
	 * @param cpf (String)
	 * @return digito_1 (int)
	 */
	private int calcula_digito1(String cpf) {
		int algarismo, soma = 0; //Declaração das variáveis
		char caractere; //Declaração das variáveis
		for (int j=0;j<9;j++) { 
			caractere = cpf.charAt(j); //Pega 1 algarismo por iteração a partir do primeiro do CPF
			algarismo = Character.getNumericValue(caractere); //Converte para int para as operações matemáticas
			soma += algarismo*(10-j); //Multiplica o algarismo por 10 subtraído de sua posição no CPF e adiciona o valor na variável acumuladora
		}
		if(soma%11<2) { //Se o resto da divisão da acumuladora por 11 for menor que 2, o primeiro algarismo verificador é 0
			return 0;
		} else {
			return (11 - (soma%11)); //Caso contrário, é 11 subtraído do resto da divisão por 11
		}
	}
	
	/**
	 * Método que calcula o segundo dígito que um Cadastro de Pessoa Física deveria conter com base nos 10 anteriores
	 * @param cpf (String)
	 * @param digito1 (int)
	 * @return digito2 (int)
	 */
	private int calcula_digito2(String cpf, int digito1) {
		int algarismo, soma = 0; //Declaração das variáveis
		char caractere; //Declaração das variáveis
		for (int k=0;k<9;k++) { 
			caractere = cpf.charAt(k); //Pega 1 algarismo por iteração a partir do primeiro do CPF
			algarismo = Character.getNumericValue(caractere); //Converte para int para as operações matemáticas
			soma += algarismo*(11-k); //Multiplica o algarismo por 11 subtraído de sua posição no CPF e adiciona o valor na variável acumuladora
		}
		soma += 2*digito1; //Adiciona o dígito1 multiplicado por 2 na variável acumuladora
		
		if(soma%11<2) { //Se o resto da divisão da acumuladora por 11 for menor que 2, o segundo algarismo verificador é 0
			return 0;
		} else {
			return (11 - (soma%11)); //Caso contrário, é 11 subtraído do resto da divisão por 11
		}
	}
	
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Cliente [Nome = " + nome + ", CPF = " + cpf + ", Data de Nascimento = " + dataNascimento + ", Idade = " + idade
				+ ", Endereço = " + endereco + "]";
	}
		
}
