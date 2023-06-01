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
	
	public boolean autorizarCondutor(Condutor condutor) {
		if(!listaCondutores.contains(condutor)) {
			listaCondutores.add(condutor);
			return true;
		}
		return false;
	}
	
	public boolean desautorizarCondutor(Condutor condutor) {
		if(listaCondutores.contains(condutor)) {
			listaCondutores.remove(condutor);
			return true;
		}
		return false;
	}
	
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
			this.setValorMensal(this.calcularValor());
			return true;
		}
		return false;
	}
	
	public boolean removerSinistro(int Id) {
		for(Sinistro s:listaSinistros) {
			if(s.getId() == Id) {
				listaSinistros.remove(s);
				this.setValorMensal(this.calcularValor()); //atualiza o valor do seguro
				return true;
			}
		}
		return false;
	}
	
	public abstract Cliente getCliente();
	
	public abstract double calcularValor();
}
