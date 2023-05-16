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
				this.cpf= cpf;
				this . dataNascimento = Validacao.parseDate(dataNascimento) ;
				this.dataLicenca = Validacao.parseDate(dataLicenca);
				this.educacao = educacao;
				this.genero = genero;
				this.classeEconomica = classeEconomica;
	}

	//Getters e Setters
	public String getDocumento() {
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
		this.dataLicenca = Validacao.parseDate(dataLicenca);
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
		this.dataNascimento = Validacao.parseDate(dataNascimento);
	}
		
	//Métodos gerais
	/*
	 * Método que calcula o score de determinado clientePF
	 */
	public double calculaScore() {
		
		if (this.getListaVeiculos()==null) {
			return 0.0;
		}
		int idade = calcula_idade(); //calcula a idade
		double fator_idade;
		
		//pega o valor correspondente à idade do enum
		if(idade>=18 && idade < 30) {
			fator_idade = CalcSeguro.FATOR_18_30.getValor();
		} else if(idade>=30 && idade <60) {
			fator_idade = CalcSeguro.FATOR_30_60.getValor();
		} else {
			fator_idade = CalcSeguro.FATOR_60_90.getValor();
		}
		return(CalcSeguro.VALOR_BASE.getValor()*fator_idade*getListaVeiculos().size());
	}

	/*
	 * Método que calcula a idade de um cliente PF
	 */
	@SuppressWarnings("deprecation")
	public int calcula_idade() {
		TimeZone localHorario = TimeZone.getTimeZone("America/Sao_Paulo");
		Calendar calendario = Calendar.getInstance(localHorario);
		Date data_atual = calendario.getTime();
		int diferenca_anos = data_atual.getYear() - dataNascimento.getYear(); //Diferença entre os anos
		if((dataNascimento.getMonth()>data_atual.getMonth() )|| (dataNascimento.getMonth() == data_atual.getMonth() && dataNascimento.getDate()> data_atual.getDate())) {
			diferenca_anos --;
		}
		return diferenca_anos;
	}
	
	
	@Override
	public String toString() {
		return "ClientePF [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CPF:  " + cpf + ", Data de Nascimento: " + dataNascimento + ", Gênero: " + genero + ", Data de Licença: "
	+ dataLicenca + ", Educação: " + educacao + ", Classe Econômica: " + classeEconomica + "]";
	}	
}