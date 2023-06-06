package com.amodio.lab5; //Pacote com.amodio.lab5

import java.util.*;

public class Seguradora {
	
	//Declaração dos atributos
	private final String cnpj;
	private String nome ;
	private String telefone ;
	private String endereco ;
	private String email ;
	private LinkedList <Cliente> listaClientes; //LinkedList, pois há a inserção mais rápida
	private ArrayList <Seguro> listaSeguros;
	private static ArrayList <Seguradora> listaSeguradoras = new ArrayList<>();
 // Construtor
	public Seguradora (String cnpj, String nome , String telefone, String endereco , String email  ) {
		this.cnpj = cnpj;
		this . nome = nome ;
		this . telefone = telefone ;
		this . email = email ;
		this . endereco = endereco ;
		this.listaClientes = new LinkedList<>();
		this.listaSeguros = new ArrayList<>();
		Seguradora.adicionaSeguradora(this);
		
	}

// Getters e setters
	public String getCnpj() {
		return cnpj;
	}
	
	public String getNome () {
		return nome ;
	}

	public void setNome ( String nome ) {
		this . nome = nome ;
	}

	public String getTelefone () {
		return telefone ;
	}

	public LinkedList<Cliente> getListaClientes () {
		return listaClientes ;
	}
	
	public ArrayList<Seguro> getListaSeguros () {
		return listaSeguros ;
	}
	
	public static ArrayList <Seguradora> getListaSeguradoras(){
		return listaSeguradoras;
	}
	public void setTelefone ( String telefone ) {
		this . telefone = telefone ;
	}

	public String getEmail () {
		return email ;
	}

	public void setEmail ( String email ) {
		this . email = email ;
	}

	public String getEndereco () {
		return endereco ;
	}

	public void setEndereco ( String endereco ) {
		this . endereco = endereco ;
	}
	public void setListaSeguros(ArrayList<Seguro> lista) {
		this.listaSeguros = lista;
	}
	
	//Métodos gerais
	
	/**
	 * Método que cadastra novos clientes na seguradora e retorna um boolean indicando se houve sucesso
	 * @param cliente (Cliente)
	 * @return boolean
	 */
	public boolean cadastrarCliente(Cliente cliente) {
		if (!this.contemCliente(cliente)) { //verifica se o cliente já está cadastrado pela função contém
			//o método contains faz a verificaçãoo por objeto, mas nesse caso, queremos comparar objetos diferentes mas equivalentes
				listaClientes.add(cliente); //adiciona o cliente
				return true;
		}
		return false;
	}
	
	/**
	 * Método que remove um cliente da seguradora, desde que esteja anteriormente cadastrado. Retorna um boolean indicando se foi possível remover
	 * Ao remover o cliente, deve remover os seguros do cliente também
	 * @param cliente (String)
	 * @return boolean
	 */
	public boolean removerCliente(String cliente) {
		ArrayList<Seguro> lista = new ArrayList<>();
		boolean variavel_indicadora = false;
		if(listaClientes == null || listaClientes.isEmpty()) {
			return false;
		}
		for(Cliente c:listaClientes) {
			//Os dígitos especiais de ambos os documentos são retirados para a comparação dizer respeito somente ao número
			if(c.getDocumento().replaceAll("[^0-9]", "").equals(cliente.replaceAll("[^0-9]", ""))) { 
				listaClientes.remove(c);
				variavel_indicadora = true;
			}
		}
		if(listaSeguros != null && !listaSeguros.isEmpty()) {
			for(Seguro s: listaSeguros) {
				if(!s.getCliente().getDocumento().replaceAll("[^0-9]", "").equals(cliente.replaceAll("[^0-9]", ""))) {
					lista.add(s);//adiciona na lista os seguros que não são do cliente
				}
			}
		}
		this.setListaSeguros(lista); //lista de seguros passa a ser essa lista auxiliar
		return variavel_indicadora;
	}

	
	/**
	 * Método que retorna os clientes do tipo solicitado, ou seja, PF ou PJ.
	 * @param cliente (String)
	 * @return lista (LinkedList<Cliente> ou null (digitação incorreta)
	 */
	public LinkedList<Cliente> listarClientes(String cliente){
		LinkedList<Cliente> lista= new LinkedList<>();
		if(cliente.equals("PJ")) { //se a String for PJ
			for(Cliente c:listaClientes) { //para cada cliente na lista
				if (c instanceof ClientePJ){ //se for PJ
					lista.add(c); //Adiciona na lista
				}
			}
		} else if(cliente.equals("PF")) { //se a String for PF
			for(Cliente c:listaClientes) { //para cada cliente na lista
				if (c instanceof ClientePF){ //se for PF
					lista.add(c); //Adiciona na lista
				}
			}
		} else {
			return null; //se retornar null, o usuário digitou incorretamente, ou seja, nem PF e nem PJ
		}
		
		return lista;
	}
	
	
	/**
	 * Método que visualiza se o cliente possui algum sinistro na seguradora e retorna a lista de sinistros
	 * @param cliente (String)
	 * @return lista
	 */
	
	public ArrayList<Sinistro> getSinistrosPorCliente(String documento) {
		ArrayList<Sinistro> lista = new ArrayList<>();
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return null;
		}
		for(Seguro s:listaSeguros) { //itera na lista de seguros
			for(Sinistro sinistro: s.getListaSinistros()) {
				if(s.getListaSinistros() == null|| s.getListaSinistros().isEmpty()) {
					return null;
				}
				if(sinistro.getSeguro().getCliente().getDocumento().replaceAll("[^0-9]", "").equals(documento.replaceAll("[^0-9]", ""))) {
					lista.add(sinistro);
				}
			}
		}
		return lista;
	}
	/**
	 * Método que retorna os seguros de determinado cliente
	 * @param documento (String)
	 * @return lista
	 */
	public ArrayList<Seguro> getSegurosPorCliente(String documento){
		ArrayList<Seguro> lista = new ArrayList<>();
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return null;
		}
		for(Seguro s: listaSeguros) {
			if(s.getCliente().getDocumento().replaceAll("[^0-9]", "").equals(documento.replaceAll("[^0-9]", ""))) {
				lista.add(s);
			}
		}
		return lista;
	}
	/**
	 * Método que imprime todos os sinistros da seguradora
	 */
	public void listarSinistros(){
		if(listaSeguros == null || listaSeguros.isEmpty()) {
			System.out.println("Nenhum seguro cadastrado");
			return;
		}
		for(Seguro s:listaSeguros) {
			s.listarSinistros();
		}
	}
	
	/**
	 * Método que imprime uma lista de clientes de maneira organizada
	 * @param lista (LinkedList <Cliente>)
	 */
	public void imprime_listaCliente(LinkedList <Cliente> lista) {
		if(lista == null|| lista.isEmpty()) {
			System.out.println("Nenhum cliente encontrado");
			return;
		}
		for(Cliente c: lista) {
			System.out.println(c);
		}
	}
	/**
	 * Método que imprime uma lista de seguros de maneira organizada
	 * @param lista
	 */
	public void imprime_listaSeguro(ArrayList<Seguro> lista) {
		if(lista == null|| lista.isEmpty()) {
			System.out.println("Nenhum seguro encontrado");
			return;
		}
		for(Seguro s:lista) {
			System.out.println(s);
		}
	}
	/**
	 * Método que imprime uma lista de sinistros de maneira organizada
	 * @param lista
	 */
	public void imprime_listaSinistro(ArrayList <Sinistro> lista) {
		if(lista == null|| lista.isEmpty()) {
			System.out.println("Nenhum sinistro encontrado");
			return;
		}
		for(Sinistro s: lista) {
			System.out.println(s);
		}
	}
	
	/*
	 * Método que calcula a receita da seguradora
	 */
	public double calcularReceita() {
		double receita = 0.0;
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return 0.0;
		}
		for(Seguro s: listaSeguros) { //itera na lista
			receita += 12*s.getValorMensal(); //soma na acumuladora
		}
		return receita;
	}
	
	/*
	 * método que obtém o número de sinistros de determinado cliente
	 */
	public int numeroSinistros(Cliente cliente) {
		int numero_sinistros = 0;
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return 0;
		}
		for(Seguro s:listaSeguros) { //itera na lista de seguros
			for(Sinistro sinistro: s.getListaSinistros()) {
				if(sinistro.getSeguro().getCliente().equals(cliente)) {
					numero_sinistros++;
				}
			}
		}
		return numero_sinistros;
	}
	
	/*
	 * método que adiciona a seguradora recém cadastrada na lista de seguradoras
	 */
	private static void adicionaSeguradora(Seguradora seguradora) {
		listaSeguradoras.add(seguradora);
		}
	
	/*
	 * Método que busca uma seguradora na lista de seguradoras
	 */
	public static Seguradora buscarSeguradora(String cnpj) {
		if(listaSeguradoras == null|| listaSeguradoras.isEmpty()) {
			return null; // se lista vazia, retorna null
		}
		for(Seguradora s: listaSeguradoras) { //itera na lista
			if(s.getCnpj().equals(cnpj)) { //quando nome coincide, retorna a seguradora
				return s;
			}
		}
		return null;
	}
	
	/*
	 * Método que busca um cliente na lista de clientes
	 */
	public Cliente buscarCliente(String documento) {
		if(listaClientes == null|| listaClientes.isEmpty()) {
			return null;
		}
		for(Cliente c: listaClientes) {
			//Os dígitos especiais de ambos os documentos são retirados para a comparação dizer respeito somente ao número
			if(c.getDocumento().replaceAll("[^0-9]", "").equals(documento.replaceAll("[^0-9]", ""))) {//quando documento coincide, retorna o cliente
				return c;
			}
		}
		return null;
	}
	/**
	 * Método que busca determinado seguro com base no ID
	 * @param Id
	 * @return
	 */
	public Seguro buscarSeguro(int Id) {
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return null;
		}
		for(Seguro s: listaSeguros) {
			if(s.getId()==Id) {
				return s;
			}
		}
		return null;
	}
	
	/*
	 * Método que lista os veículos de uma seguradora
	 */
	public boolean listarVeiculos() {
		//indicadora necessária, pois pode haver mais de um veículo
		boolean variavel_indicadora = false; //variável indicadora que representa se a seguradora possui ou não veículos
		if(listaClientes == null|| listaClientes.isEmpty()) {
			return false;
		}
		for(Cliente c: listaClientes) {
			if(c.listarVeiculos()) {
				variavel_indicadora = true;
			}
		}
		return variavel_indicadora;
	}
	/**
	 * Método que lista os seguros de uma seguradora
	 * @return
	 */
	public boolean listarSeguros() {
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return false;
		}
		for(Seguro s:listaSeguros) {
			System.out.println(s);
		}
		return true;
	}
	
	/*
	 * Método que verifica se a seguradora contém um certo cliente, por comparação de documentos
	 */
	private boolean contemCliente(Cliente cliente) {
		if(listaClientes == null|| listaClientes.isEmpty()) {
			return false;
		}
		for(Cliente c: listaClientes) {
			//Os dígitos especiais de ambos os documentos são retirados para a comparação dizer respeito somente ao número
			if(c.getDocumento().replaceAll("[^0-9]", "").equals(cliente.getDocumento().replaceAll("[^0-9]", ""))) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Método que verifica se um veículo é segurado
	 * @param veiculo
	 * @return
	 */
	public boolean ehSegurado(Veiculo veiculo) {
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return false;
		}
		for(Seguro s:listaSeguros) {
			if(s instanceof SeguroPF) {
				if(((SeguroPF) s).getVeiculo().getPlaca().equals(veiculo.getPlaca())) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Método que verifica se uma frota é segurada
	 * @param frota
	 * @return
	 */
	public boolean ehSegurado(Frota frota) {
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return false;
		}
		for(Seguro s:listaSeguros) {
			if(s instanceof SeguroPJ) {
				if(((SeguroPJ) s).getFrota().getCode().equals(frota.getCode())) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Método que gera um seguroPF
	 * @param dataInicio
	 * @param dataFim
	 * @param seguradora
	 * @param veiculo
	 * @param cliente
	 * @return
	 */
	public boolean gerarSeguroPF(String dataInicio, String dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		SeguroPF seguro;
		if(!seguradora.contemCliente(cliente)) {
			System.out.println("O cliente não é da seguradora");
			return false;
		}
		if(!cliente.contemVeiculo(veiculo)) {
			System.out.println("O veículo não é do cliente");
			return false;
		}
		seguro = new SeguroPF(dataInicio, dataFim, seguradora, veiculo, cliente);
		listaSeguros.add(seguro);
		cliente.adicionaSeguro(seguro);
		cliente.recalculaValoresSeguro();
		return true;
	}
	/**
	 * Método que gera um seguroPJ
	 * @param dataInicio
	 * @param dataFim
	 * @param seguradora
	 * @param frota
	 * @param cliente
	 * @return
	 */
	public boolean gerarSeguroPJ(String dataInicio, String dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
		SeguroPJ seguro;
		if(!seguradora.contemCliente(cliente)) {
			System.out.println("O cliente não é da seguradora");
			return false;
		}
		if(!cliente.contemFrota(frota)) {
			System.out.println("A frota não é do cliente");
			return false;
		}
		seguro = new SeguroPJ(dataInicio, dataFim, seguradora, frota, cliente);
		cliente.adicionaSeguro(seguro);
		listaSeguros.add(seguro);
		cliente.recalculaValoresSeguro();
		return true;
	}
	/**
	 * Método que lista os sinistros de um cliente
	 * @param documento
	 * @return
	 */
	public boolean visualizarSinistro(String documento) {
		boolean variavel_indicadora = false;
		if(listaSeguros == null|| listaSeguros.isEmpty()) {
			return false;
		}
		for(Seguro s: listaSeguros) {
			if(s.getCliente().getDocumento().replaceAll("[^0-9]", "").equals(documento.replaceAll("[^0-9]", ""))) {
				s.listarSinistros();
				variavel_indicadora = true;
			}
		}
		return variavel_indicadora;
	}
	/**
	 * Método que cancela um seguro
	 * @param seguro
	 * @return
	 */
	public boolean cancelarSeguro(Seguro seguro) {
		if(listaSeguros == null || listaSeguros.isEmpty()) {
			return false;
		}
		for(Seguro s:listaSeguros) {
			if(s.getId()==seguro.getId()) {
				listaSeguros.remove(s);
				return true;
			}
		}
		return false;
	}
	/**
	 * Método que remove uma seguradora
	 * @param seguradora
	 * @return
	 */
	public static boolean removerSeguradora(Seguradora seguradora) {
		if(listaSeguradoras == null || listaSeguradoras.isEmpty()) {
			return false;
		}
		for(Seguradora s: listaSeguradoras) {
			if(s.getCnpj().replaceAll("[^0-9]", "").equals(seguradora.getCnpj().replaceAll("[^0-9]", ""))) {
				listaSeguradoras.remove(s);
				return true;
			}
		}
		return false;
	}
	
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Seguradora [Nome:  " + nome + ", Telefone:  " + telefone + ", E-mail:  " 
		+ email + ", Endereço:  " + endereco+ "]";
	}

}