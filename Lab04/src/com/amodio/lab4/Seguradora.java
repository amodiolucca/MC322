package com.amodio.lab4; //Pacote com.amodio.lab4

import java.util.*;

public class Seguradora {
	
	//Declaração dos atributos
	private String nome ;
	private String telefone ;
	private String email ;
	private String endereco ;
	private LinkedList <Cliente> listaClientes; //LinkedList, pois há a inserção mais rápida
	private ArrayList <Sinistro> listaSinistros; //ArrayList, pois há a busca mais rápida
	private static ArrayList <Seguradora> listaSeguradoras = new ArrayList<>();
 // Construtor
	public Seguradora ( String nome , String telefone , String email , String endereco ) {
		this . nome = nome ;
		this . telefone = telefone ;
		this . email = email ;
		this . endereco = endereco ;
		this.listaSinistros = new ArrayList<>();
		this.listaClientes = new LinkedList<>();
		Seguradora.adicionaSeguradora(this);
		
	}

// Getters e setters
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
	
	public ArrayList<Sinistro> getListaSinistros () {
		return listaSinistros ;
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
				cliente.setValorSeguro(calcularPrecoSeguroCliente(cliente)); //adiciona o valor do seguro ao cliente
				return true;
		}
		return false;
	}
	
	/**
	 * Método que remove um cliente da seguradora, desde que esteja anteriormente cadastrado. Retorna um boolean indicando se foi possível remover
	 * @param cliente (String)
	 * @return boolean
	 */
	public boolean removerCliente(String cliente) {
		for(Cliente c:listaClientes) {
			//Os dígitos especiais de ambos os documentos são retirados para a comparação dizer respeito somente ao número
			if(c.getDocumento().replaceAll("[^0-9]", "").equals(cliente.replaceAll("[^0-9]", ""))) { 
				listaClientes.remove(c);
				return true;
			}
		}
		return false;
	}
	
	public boolean removerSinistro(int Id) {
		for(Sinistro s:listaSinistros) {
			if(s.getId() == Id) {
				listaSinistros.remove(s);
				s.getCliente().setValorSeguro(calcularPrecoSeguroCliente(s.getCliente())); //atualiza o valor do seguro
				return true;
			}
		}
		return false;
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
	 * Método que gera um sinistro na seguradora conforme os parâmetros passados
	 * @param data (String)
	 * @param endereco (String)
	 * @param seguradora (Seguradora)
	 * @param cliente (Cliente)
	 * @param veiculo (Veiculo)
	 * @return boolean
	 */
	public boolean gerarSinistro(String data, String endereco, Seguradora seguradora, Cliente cliente, Veiculo veiculo) {
		int variavel_indicadora = 0; //variável que vai indicar se há repetição de ID
		if(listaClientes == null|| cliente.getListaVeiculos()==null|| listaClientes.isEmpty()|| cliente.getListaVeiculos().isEmpty()) {
			return false;
		}
		if(listaClientes.contains(cliente) && cliente.getListaVeiculos().contains(veiculo)) { //verifica se o cliente é da seguradora realmente
			Sinistro sinistro = new Sinistro(data, endereco, seguradora, cliente, veiculo); //gera o sinistro
			if((listaSinistros != null) && (!listaSinistros.isEmpty())) {
				do {
					for(Sinistro s:listaSinistros) {
						if(sinistro.getId()==s.getId()) { //verifica se o ID é o mesmo de algum sinistro da lista
							sinistro = new Sinistro(data, endereco, seguradora, cliente, veiculo); //se for, gera o sinistro novamente
							variavel_indicadora = 1; //variavel indicadora aponta 1
							break;
						}
					}
				} while (variavel_indicadora ==1); //Se a indicadora for 0, o ID não é repetido
			}
			
			
			listaSinistros.add(sinistro); //Adiciona o sinistro na lista
			cliente.setValorSeguro(calcularPrecoSeguroCliente(cliente));
			return true;
		}
		return false;
	}
	
	/**
	 * Método que visualiza se o cliente possui algum sinistro na seguradora
	 * @param cliente (String)
	 * @return boolean
	 */
	
	public boolean visualizarSinistro(String documento) {
		int variavel_indicadora = 0; //variável indicadora que representa se o cliente possui ou não sinistro
		//indicadora necessária, pois pode haver mais de um sinistro
		if(listaSinistros == null|| listaSinistros.isEmpty()) {
			return false;
		}
		for(Sinistro sinistro: listaSinistros) { //para cada sinistro
			if(sinistro.getCliente().getDocumento().replaceAll("[^0-9]", "").equals(documento.replaceAll("[^0-9]", ""))) { //se o cliente do sinistro for o cliente buscado
				System.out.println(sinistro); //imprime o sinistro
				variavel_indicadora = 1; //indicadora fica com o valor 1
			}
		}
		if(variavel_indicadora ==1) { //se indicadora for 1
			return true; //retorna true
		} else {
			return false;
		}
	}
	
	/**
	 * Método que imprime todos os sinistros da seguradora
	 */
	public void listarSinistros(){
		if(listaSinistros == null || listaSinistros.isEmpty()) {
			System.out.println("Nenhum sinistro encontrado");
			return;
		}
		for(Sinistro s:listaSinistros) {
			System.out.println(s);
		}
	}
	/**
	 * Método que imprime uma lista de sinistros de maneira organizada
	 * @param lista (ArrayList<Sinistro>)
	 */
	public void imprime_listaSinistro(ArrayList<Sinistro> lista) {
		if(lista == null|| lista.isEmpty()) {
			System.out.println("Nenhum sinistro encontrado");
			return;
		}
		for(Sinistro s:lista) {
			System.out.println(s);
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
	
	/*
	 * Método que calcula o preço do seguro de um cliente
	 */
	public double calcularPrecoSeguroCliente(Cliente cliente) {
		return cliente.calculaScore()*(1+numeroSinistros(cliente));
	}
	
	/*
	 * Método que calcula a receita da seguradora
	 */
	public double calcularReceita() {
		double receita = 0.0;
		if(listaClientes == null|| listaClientes.isEmpty()) {
			return 0.0;
		}
		for(Cliente c:listaClientes) { //itera na lista
			receita += c.getValorSeguro(); //soma na acumuladora
		}
		return receita;
	}
	
	/*
	 * método que obtém o número de sinistros de determinado cliente
	 */
	private int numeroSinistros(Cliente cliente) {
		int numero_sinistros = 0;
		if(listaSinistros == null|| listaSinistros.isEmpty()) {
			return 0;
		}
		for(Sinistro s:listaSinistros) { //itera na lista de sinistros
			if (s.getCliente().equals(cliente)){ //quando o cliente é o mesmo
				numero_sinistros ++; //soma na acumuladora
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
	public static Seguradora buscarSeguradora(String nome) {
		if(listaSeguradoras == null|| listaSeguradoras.isEmpty()) {
			return null; // se lista vazia, retorna null
		}
		for(Seguradora s: listaSeguradoras) { //itera na lista
			if(s.getNome().equals(nome)) { //quando nome coincide, retorna a seguradora
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
	
	/*
	 * Método que lista os veículos de uma seguradora
	 */
	public boolean listarVeiculos() {
		//indicadora necessária, pois pode haver mais de um veículo
		int variavel_indicadora = 0; //variável indicadora que representa se a seguradora possui ou não veículos
		if(listaClientes == null|| listaClientes.isEmpty()) {
			return false;
		}
		for(Cliente c: listaClientes) {
			if(c.getListaVeiculos()==null|| c.getListaVeiculos().isEmpty()) { //se certa lista é vazia
				continue; //vai para a próxima
			}
			for(Veiculo v: c.getListaVeiculos()) {
				variavel_indicadora = 1; //indica que tem ao menos 1 veículo
				System.out.println(v);
			}
		}
		if(variavel_indicadora ==1) { //se indicadora for 1
			return true; //retorna true
		} else {
			return false;
		}
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
	
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Seguradora [Nome:  " + nome + ", Telefone:  " + telefone + ", E-mail:  " 
		+ email + ", Endereço:  " + endereco+ "]";
	}

}