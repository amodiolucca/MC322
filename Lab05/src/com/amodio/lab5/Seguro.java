package com.amodio.lab5;

import java.util.ArrayList;
import java.util.Date;

public abstract class Seguro {
	
	//declaração dos atributos
	private final int ID;
	private Date dataInicio;
	private Date dataFim;
	private Seguradora seguradora;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Condutor> listaCondutores;
	private double valorMensal;
	private static int numeroSeguros=0;
	
	//construtor
	public Seguro(String dataInicio, String dataFim, Seguradora seguradora) {
		this.ID = numeroSeguros;
		this.dataInicio = Validacao.parseDate(dataInicio);
		this.dataFim = Validacao.parseDate(dataFim);
		this.seguradora = seguradora;
		this.listaSinistros = new ArrayList<>();
		this.listaCondutores = new ArrayList<>();
		numeroSeguros++;
	}
	
	//getters e setters
	
	public int getId() {
		return ID;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public ArrayList<Sinistro> getListaSinistros () {
		return listaSinistros;
	}
	
	public ArrayList<Condutor> getListaCondutores () {
		return listaCondutores;
	}
	
	public double getValorMensal() {
		return valorMensal;
	}
	
	public void SetDataInicio(String DataInicio) {
		this.dataInicio = Validacao.parseDate(DataInicio);
	}
	
	public void SetDataFim(String DataFim) {
		this.dataFim = Validacao.parseDate(DataFim);
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
	public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}
	
	
	protected void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	/**
	 * Método que autoriza determinado condutor
	 * @param condutor
	 * @return
	 */
	public boolean autorizarCondutor(Condutor condutor) {
		if(!listaCondutores.contains(condutor)) {
			listaCondutores.add(condutor);
			return true;
		}
		return false;
	}
	/**
	 * Método que desautoriza determinado condutor
	 * @param condutor
	 * @return
	 */
	public boolean desautorizarCondutor(Condutor condutor) {
		if(listaCondutores.contains(condutor)) {
			listaCondutores.remove(condutor);
			return true;
		}
		return false;
	}
	/**
	 * Método que gera um sinistro no seguro
	 * O sinistro também é adicionado ao condutor
	 * @param data
	 * @param endereco
	 * @param condutor
	 * @return
	 */
	public boolean gerarSinistro(String data, String endereco, Condutor condutor) {
		int variavel_indicadora = 0; //variável que vai indicar se há repetição de ID
		if(listaCondutores.isEmpty() || listaCondutores ==null){
			return false;
		}
		if(listaCondutores.contains(condutor)) {
			Sinistro sinistro = new Sinistro(data, endereco, condutor, this); //gera o sinistro
			if((listaSinistros != null) && (!listaSinistros.isEmpty())) {
				do {
					for(Sinistro s:listaSinistros) {
						if(sinistro.getId()==s.getId()) { //verifica se o ID é o mesmo de algum sinistro da lista
							sinistro = new Sinistro(data, endereco, condutor, this); //se for, gera o sinistro novamente
							variavel_indicadora = 1; //variavel indicadora aponta 1
							break;
						}
					}
				} while (variavel_indicadora ==1); //Se a indicadora for 0, o ID não é repetido
			}
			listaSinistros.add(sinistro);
			condutor.adicionarSinistro(sinistro);
			valorMensal =calcularValor()/12;
			return true;
		}
		return false;
	}
	/**
	 * Método que remove determinado sinistro do sistema
	 * O sinistro também é removido do condutor
	 * @param Id
	 * @return
	 */
	public boolean removerSinistro(int Id) {
		for(Sinistro s:listaSinistros) {
			if(s.getId() == Id) {
				if(!s.getCondutor().removerSinistro(s)) {
					return false;
				}
				listaSinistros.remove(s);
				valorMensal =calcularValor()/12; //atualiza o valor do seguro
				return true;
			}
		}
		return false;
	}
	/**
	 * Método que retorna os sinistros de determinado condutor
	 * @return
	 */
	protected int getSinistrosCondutor() {
		int quantidadeSinistrosCondutor = 0;
		for (Condutor c: listaCondutores) {
			quantidadeSinistrosCondutor += c.getListaSinistros().size();
		}
		return quantidadeSinistrosCondutor;
	}
	/**
	 * Método que imprime os sinistros de um seguro
	 */
	public void listarSinistros() {
		if(listaSinistros == null || listaSinistros.isEmpty()) {
			System.out.println("Nenhum sinistro encontrado");
			return;
		}
		for(Sinistro s:listaSinistros) {
			System.out.println(s);
		}
	}
	/**
	 * Método que imprime os condutores de um seguro
	 */
	public void listarCondutores() {
		if(listaCondutores == null || listaCondutores.isEmpty()) {
			System.out.println("Nenhum condutor encontrado");
			return;
		}
		for(Condutor c:listaCondutores) {
			System.out.println(c);
		}
	}
	/**
	 * Método que busca um condutor no seguro
	 * @param cpf
	 * @return
	 */
	public Condutor buscarCondutor(String cpf) {
		if(listaCondutores == null|| listaCondutores.isEmpty()) {
			return null;
		}
		for(Condutor c: listaCondutores) {
			if(c.getCpf().replaceAll("[^0-9]", "").equals(cpf.replaceAll("[^0-9]", ""))) {
				return c;
			}
		}
		return null;
	}
	
	public abstract Cliente getCliente();
	
	public abstract double calcularValor();

	@Override
	public String toString() {
		return "Seguro [ID: " + ID + ", Data de Início: " + dataInicio + ", Data de Fim: " + dataFim + ", Seguradora: " + seguradora
				+ ", Valor Mensal: " + valorMensal + "]";
	}
	
	
}
