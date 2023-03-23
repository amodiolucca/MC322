package com.amodio.lab2;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	// Construtor
	public Cliente( String nome , String cpf , String dataNascimento, int idade, String endereco) {
		if(validarCPF(cpf)==true) {
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

//métodos gerais
		/**
		 * 
		 * @param cpf 
		 * @return 
		 */
		public boolean validarCPF(String cpf) {
			char primeiro_caractere, caractere;
			primeiro_caractere = cpf.charAt(0);
			cpf = cpf.replaceAll("[^0-9]", "");
			if (cpf.length() != 11){
				return false;
			}
			for(int i=1;i<11;i++) {
				caractere = cpf.charAt(i);
				if(caractere != primeiro_caractere) {
					break;
				}
				if(i==10) {
					return false;
				}
			}
			int algarismo, digito1,digito2, soma =0; //coloca no começo?
			for (int j=0;j<9;j++) {
				caractere = cpf.charAt(j);
				algarismo = Character.getNumericValue(caractere);
				soma += algarismo*(10-j);
			}
			if(soma%11<2) {
				digito1 = 0;
			} else {
				digito1 = 11 - (soma%11);
			}
			soma = 0;
			for (int k=0;k<9;k++) {
				caractere = cpf.charAt(k);
				algarismo = Character.getNumericValue(caractere);
				soma += algarismo*(11-k);
			}
			soma += 2*digito1;
			
			if(soma%11<2) {
				digito2 = 0;
			} else {
				digito2 = 11 - (soma%11);
			}
			if(digito1 == Character.getNumericValue(cpf.charAt(9))&& digito2 == 
					Character.getNumericValue(cpf.charAt(10))) {
				return true;
			}
			return false;
		}
		
		public String toString() {
			return "Nome: " + nome + "  CPF: " + cpf + "  Data de Nascimento: " + dataNascimento
					+ "  Idade: " + idade + " anos" + "  Endereço: " + endereco;
		}
		
}
