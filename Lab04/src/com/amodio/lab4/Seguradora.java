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
		if (!listaClientes.contains(cliente)) { //se não contém o cliente
			if(cliente instanceof ClientePF && ((ClientePF) cliente).getCpf()!=null) { //verifica se o cliente é válido
				listaClientes.add(cliente); //adiciona o cliente
				cliente.setValorSeguro(calcularPrecoSeguroCliente(cliente)); //adiciona o valor do seguro ao cliente
				return true;
			}
			if(cliente instanceof ClientePJ && ((ClientePJ) cliente).getCnpj()!=null) { //verifica se o cliente é válido
				listaClientes.add(cliente); //adiciona o cliente
				cliente.setValorSeguro(calcularPrecoSeguroCliente(cliente)); //adiciona o valor do seguro ao cliente
				return true;
			}
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
			if(c.getNome().equals(cliente)) {
				listaClientes.remove(c);
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
		if(cliente.equals("ClientePJ")) { //se a String for PJ
			for(Cliente c:listaClientes) { //para cada cliente na lista
				if (c instanceof ClientePJ){ //se for PJ
					lista.add(c); //Adiciona na lista
				}
			}
		} else if(cliente.equals("ClientePF")) { //se a String for PF
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
		if(listaClientes.contains(cliente)) { //verifica se o cliente é da seguradora realmente
			Sinistro sinistro = new Sinistro(data, endereco, seguradora, cliente, veiculo); //gera o sinistro
			
			do {
				for(Sinistro s:listaSinistros) {
					if(sinistro.getId()==s.getId()) { //verifica se o ID é o mesmo de algum sinistro da lista
						sinistro = new Sinistro(data, endereco, seguradora, cliente, veiculo); //se for, gera o sinistro novamente
						variavel_indicadora = 1; //variavel indicadora aponta 1
						break;
					}
				}
			} while (variavel_indicadora ==1); //Se a indicadora for 0, o ID não é repetido
			listaSinistros.add(sinistro); //Adiciona o sinistro na lista
			return true;
		}
		return false;
	}
	
	/**
	 * Método que visualiza se o cliente possui algum sinistro na seguradora
	 * @param cliente (String)
	 * @return boolean
	 */
	
	public boolean visualizarSinistro(String cliente) {
		int variavel_indicadora = 0; //variável indicadora que representa se o cliente possui ou não sinistro
		for(Sinistro sinistro: listaSinistros) { //para cada sinistro
			if(sinistro.getCliente().getNome().equals(cliente)) { //se o cliente do sinistro for o cliente buscado
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
		for(Sinistro s:listaSinistros) {
			System.out.println(s);
		}
	}
	/**
	 * Método que imprime uma lista de sinistros de maneira organizada
	 * @param lista (ArrayList<Sinistro>)
	 */
	public void imprime_listaSinistro(ArrayList<Sinistro> lista) {
		for(Sinistro s:lista) {
			System.out.println(s);
		}
	}
	/**
	 * Método que imprime uma lista de clientes de maneira organizada
	 * @param lista (LinkedList <Cliente>)
	 */
	public void imprime_listaCliente(LinkedList <Cliente> lista) {
		for(Cliente c: lista) {
			System.out.println(c);
		}
	}
	
	public double calcularPrecoSeguroCliente(Cliente cliente) {
		return cliente.calculaScore()*(1+numeroSinistros(cliente));
	}
	
	public double calcularReceita() {
		double receita = 0.0;
		for(Cliente c:listaClientes) {
			receita += c.getValorSeguro();
		}
		return receita;
	}
	
	public int numeroSinistros(Cliente cliente) {
		int numero_sinistros = 0;
		for(Sinistro s:listaSinistros) {
			if (s.getCliente().equals(cliente)){
				numero_sinistros ++;
			}
		}
		return numero_sinistros;
	}
	
	public static void adicionaSeguradora(Seguradora seguradora) {
		listaSeguradoras.add(seguradora);
		}
	
	public static Seguradora buscarSeguradora(String nome) {
		for(Seguradora s: listaSeguradoras) {
			if(s.getNome().equals(nome)) {
				return s;
			}
		}
		return null;
	}
	
	public Cliente buscarCliente(String nome) {
		for(Cliente c: listaClientes) {
			if(c.getNome().equals(nome)) {
				return c;
			}
		}
		return null;
	}
	
	
	//Método toString, que faz a impressão de todos os atributos dos objetos de maneira organizada
	public String toString() {
		return "Seguradora [Nome:  " + nome + ", Telefone:  " + telefone + ", E-mail:  " 
		+ email + ", Endereço:  " + endereco+ "]";
	}

}