package com.amodio.lab5; //Pacote com.amodio.lab5


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class ClientePF extends Cliente {
	//Declaração dos atributos
	private final String cpf ;
	private Date dataNascimento ;
	private String genero;
	private String educacao;
	private ArrayList<Veiculo> listaVeiculosSegurados;
	
	//Construtor
	public ClientePF ( String nome , String telefone, String endereco, String email, String educacao , String genero,
			String cpf , String dataNascimento ) {
			// chama o construtor da superclasse
			super (nome , telefone, endereco, email);
				this.cpf= cpf;
				this . dataNascimento = Validacao.parseDate(dataNascimento) ;
				this.educacao = educacao;
				this.genero = genero;
				this.listaVeiculosSegurados = new ArrayList<>();
	}

	//Getters e Setters
	public String getDocumento() {
		return cpf;
	}
		
	public Date getDataNascimento () {
		return dataNascimento;
	}
		
	public String getEducacao() {
		return educacao;
	}
		
	public String getGenero() {
		return genero;
	}
		
	
	public ArrayList<Veiculo> getListaVeiculosSegurados() {
		return listaVeiculosSegurados;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
		
	public void setGenero(String genero) {
		this.genero = genero;
	}
		
		
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = Validacao.parseDate(dataNascimento);
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> lista) {
		this.listaVeiculosSegurados = lista;
	}
	
	public void adicionaVeiculoSegurado(Veiculo veiculo) {
		listaVeiculosSegurados.add(veiculo);
	}
	
	
	//Métodos gerais
	/*
	 * Método que calcula o score de determinado clientePF
	 */
	public double fator_idade() {
		
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
		return fator_idade;
	}

	/*
	 * Método que calcula a idade de um cliente PF
	 */
	@SuppressWarnings("deprecation")
	private int calcula_idade() {
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
		return "ClientePF [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CPF:  " + cpf + ", Data de Nascimento: " + dataNascimento + ", Gênero: " + genero +  ", Educação: " + educacao 
				+", Telefone: " + this.getTelefone() + ", E-mail: " + this.getEmail() +"]";
	}	
}