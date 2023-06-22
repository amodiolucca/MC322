package com.amodio.lab6; //Pacote com.amodio.lab5


import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.TimeZone;


public class ClientePF extends Cliente {
	//Declaração dos atributos
	private final String cpf ;
	private Date dataNascimento ;
	private String genero;
	private String educacao;
	private LinkedList <Veiculo> listaVeiculos;
	
	//Construtor
	public ClientePF ( String nome , String telefone, String endereco, String email, String educacao , String genero,
			String cpf , String dataNascimento ) {
			// chama o construtor da superclasse
			super (nome , telefone, endereco, email);
				this.cpf= cpf;
				this . dataNascimento = Validacao.parseDate(dataNascimento) ;
				this.educacao = educacao;
				this.genero = genero;
				this.listaVeiculos = new LinkedList<>(); //LinkedList, pois faz a inserção de elementos de forma maia rápida
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

	public LinkedList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
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
	
	public void setListaVeiculos(LinkedList<Veiculo> lista) {
		this.listaVeiculos = lista;
	}
	
	
	//Métodos gerais
	/*
	 * Método que calcula o fator idade de determinado clientePF
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
	
	/**
	 * Método que cadastra os veículos do cliente e retorna false caso o veículo já esteja cadastrado
	 * Nesse caso, não precisa recalcular o valorSeguro, pois o veículo ainda não foi segurado
	 * @param veiculo (Veiculo)
	 * @return boolean
	 */
	public boolean cadastraVeiculo (Veiculo veiculo, Seguradora seguradora) {
		if(!this.contemVeiculo(veiculo)) { //verifica se o veículo já está cadastrado pela função contém
			//o método contains faz a verificação por objeto, mas nesse caso, queremos comparar objetos diferentes mas equivalentes
			listaVeiculos.add(veiculo); //adiciona na lista
			return true;
		}
		return false;
	}
	
	/**
	 * Método que remove veículos do cliente, desde que estejam na lista anteriormente
	 * @param veiculo (Veiculo)
	 * @return boolean
	 */
	public boolean removeVeiculo (String placa, Seguradora seguradora) { 
		for(Veiculo v:listaVeiculos) {
			if(v.getPlaca().equals(placa)) {
				listaVeiculos.remove(v);
				cancelaSeguro(v);
				super.recalculaValoresSeguro();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que imprime a lista de veículos de maneira organizada
	 * @param lista (LinkedList<Veiculo>)
	 */
	public void imprimeListaVeiculos(LinkedList<Veiculo> lista) {
		
		if(listaVeiculos == null|| listaVeiculos.isEmpty()) {
			System.out.println("Nenhum veículo encontrado");
			return;
		}
		for(Veiculo v:lista) {
			System.out.println(v);
		}
	}
	
	/*
	 * Método que busca um veículo em determinado cliente e o retorna se econtrar
	 */
	public Veiculo buscarVeiculo(String modelo) {
		if(listaVeiculos == null|| listaVeiculos.isEmpty()) {
			return null;
		}
		for(Veiculo v: listaVeiculos) { //itera na lista
			if(v.getPlaca().equals(modelo)) { //se as placas são iguais
				return v; //retorna o veículo
			}
		}
		return null;
	}
	
	/*
	 * Método que verifica se o cliente contém o veículo, por comparação de placas
	 */
	public boolean contemVeiculo(Veiculo veiculo) {
		if(listaVeiculos== null|| listaVeiculos.isEmpty()) {
			return false;
		}
		for(Veiculo v: listaVeiculos) {
			if(v.getPlaca().equals(veiculo.getPlaca())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que lista os veículos de um cliente
	 */
	public boolean listarVeiculos() {
		if(listaVeiculos == null || listaVeiculos.isEmpty()) {
			return false;
		}
		for(Veiculo v:listaVeiculos) {
			System.out.println(v);
		}
		return true;
	}
	/**
	 * Método que indica que determinado seguro de um veículo deve ser excluído caso exista
	 * @param veiculo(Veiculo)
	 */
	public void cancelaSeguro(Veiculo veiculo) {
		SeguroPF seguropf;
		if(super.getListaSeguros() == null || super.getListaSeguros().isEmpty()) {
			return;
		}
		for(Seguro s:super.getListaSeguros()) {
			if(s instanceof SeguroPF) {
				seguropf = (SeguroPF)s;
				if(seguropf.getVeiculo().equals(veiculo)) {
					s.getSeguradora().cancelarSeguro(seguropf);
				}
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "ClientePF [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CPF:  " + cpf + ", Data de Nascimento: " + dataNascimento + ", Gênero: " + genero +  ", Educação: " + educacao 
				+", Telefone: " + this.getTelefone() + ", E-mail: " + this.getEmail() +"]";
	}	
}