package com.amodio.lab6; //Pacote com.amodio.lab5

import java.util.*;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private Date dataFundacao;
	private ArrayList<Frota> listaFrota;
	
	public ClientePJ ( String nome , String telefone, String endereco, String email, String cnpj , String dataFundacao) {
			// chama o construtor da superclasse
			super (nome, telefone, endereco, email);
				this . cnpj = cnpj ;
				this . dataFundacao = Validacao.parseDate(dataFundacao) ;
				this.listaFrota = new ArrayList<>();
	}

	//Getters e Setters
	public String getDocumento() {
		return cnpj;
	}

	public Date getDataFundacao () {
		return dataFundacao;
	}
	
	public ArrayList<Frota> getListaFrota(){
		return listaFrota;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataFundacao = Validacao.parseDate(dataNascimento);
	}
	
	public void setListaFrota(ArrayList<Frota> lista) {
		this.listaFrota = lista;
	}
	
	/**
	 *Método que cadastra uma frota vazia inicialmente 
	 * @return
	 */
	public boolean cadastraFrota() {
		boolean variavel_indicadora;
		variavel_indicadora = listaFrota.add(new Frota(this));
		super.recalculaValoresSeguro();
		return variavel_indicadora;
	}
	
	/**
	 * Método que lista todos os veículos de um clientePJ
	 */
	public boolean listarVeiculos() {
		boolean variavel_indicadora = false;
		if(listaFrota == null|| listaFrota.isEmpty()) { //se a lista de frotas é vazia
			return false; //retorna false
		}
		for(Frota f: listaFrota) {
			if(f.getListaVeiculos()==null || f.getListaVeiculos().isEmpty()) {
				continue;
			}
			for(Veiculo v: f.getListaVeiculos()) {
				System.out.println(v);
				variavel_indicadora = true;
			}
		}
		return variavel_indicadora;
	}
	
	/**
	 * Método que verifica se o cliente possui determinada frota
	 * @param frota
	 * @return
	 */
	public boolean contemFrota(Frota frota) {
		if(listaFrota== null|| listaFrota.isEmpty()) {
			return false;
		}
		for(Frota f: listaFrota) {
			if(f.getCode().equals(frota.getCode())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Método que retorna a frota com base no code passado
	 * @param code
	 * @return
	 */
	public Frota getFrota(String code) {
		if(listaFrota == null || listaFrota.isEmpty()) {
			return null;
		}
		for(Frota f: listaFrota) {
			if(f.getCode().equals(code)) {
				return f;
			}
		}
		return null;
	}
	
	/**
	 * Método que retorna a lista de veículos do cliente
	 */
	public LinkedList<Veiculo> getListaVeiculos(){
		LinkedList<Veiculo> lista = new LinkedList<>();
		if(listaFrota == null || listaFrota.isEmpty()) {
			return null;
		}
		for(Frota f:listaFrota) {
			if(f.getListaVeiculos()==null || f.getListaVeiculos().isEmpty()) {
				continue;
			}
			for(Veiculo v: f.getListaVeiculos()) {
				lista.add(v);
			}
		}
		return lista;
	}
	
	/**
	 * Método que busca determinado veículo nos veículos do cliente
	 */
	public Veiculo buscarVeiculo(String placa) {
		if(listaFrota == null || listaFrota.isEmpty()) {
			return null;
		}
		for(Frota f:listaFrota) {
			if(f.getListaVeiculos()==null || f.getListaVeiculos().isEmpty()) {
				continue;
			}
			for(Veiculo v: f.getListaVeiculos()) {
				if(v.getPlaca().equals(placa)) {
					return v;
				}
			}
		}
		return null;
	}
	
	/**
	 * Método que deleta todas as frotas do cliente
	 * @return
	 */
	public boolean atualizarFrota() {
		if(listaFrota != null && !listaFrota.isEmpty()) {
			for(Frota f: listaFrota) {
				cancelaSeguro(f);
			}
		}
		listaFrota.clear();
		 super.recalculaValoresSeguro();
		 return listaFrota.isEmpty();
	}
	
	/**
	 * Método que deleta determinada frota do cliente
	 * @param f (Frota)
	 * @return
	 */
	public boolean atualizarFrota(Frota f) {
		if(listaFrota != null && !listaFrota.isEmpty()) {
			listaFrota.remove(f);
			super.recalculaValoresSeguro();
			return true;
		}
		return false;
		}
	
	/**
	 * Método que adiciona ou remove veículo em determinada frota
	 * @param frota
	 * @param veiculo
	 * @param operacao
	 * @return
	 */
	public boolean atualizarFrota(Frota frota, Veiculo veiculo, String operacao) {
		if(operacao.equals("adicionar")) {
			super.recalculaValoresSeguro();
			return frota.addVeiculo(veiculo);
		} else if(operacao.equals("remover")) {
			super.recalculaValoresSeguro();
			return frota.removeVeiculo(veiculo);
		}
		return false;
	}
	
	/*
	 * Método que busca uma frota em determinado cliente e o retorna se encontrar
	 */
	public Frota buscarFrota(String code) {
		if(listaFrota == null|| listaFrota.isEmpty()) {
			return null;
		}
		for(Frota f: listaFrota) { //itera na lista
			if(f.getCode().equals(code)) { //se os code são iguais
				return f; //retorna o veículo
			}
		}
		return null;
	}
	/**
	 * Método que lista as frotas do cliente
	 * @return
	 */
	public boolean listarFrota() {
		if(listaFrota == null|| listaFrota.isEmpty()) { //se a lista de frotas é vazia
			return false; //retorna false
		}
		for(Frota f: listaFrota) {
			System.out.println(f);
		}
		return true;
	}
	/**
	 * Método que indica que determinado seguro deve ser cancelado após a frota ser removida do cliente
	 * @param frota
	 */
	public void cancelaSeguro(Frota frota) {
		SeguroPJ seguropj;
		if(super.getListaSeguros() == null || super.getListaSeguros().isEmpty()) {
			return;
		}
		for(Seguro s:super.getListaSeguros()) {
			if(s instanceof SeguroPJ) {
				seguropj = (SeguroPJ)s;
				if(seguropj.getFrota().equals(frota)) {
					s.getSeguradora().cancelarSeguro(seguropj);
				}
			}
		}
		
	}
	
	@Override
	public String toString() {
		return "ClientePJ [Nome: " + this.getNome() + ", Endereço: " + this.getEndereco() + ", CNPJ: " + cnpj + ", Data de Fundação: " + dataFundacao 
				+ ", Telefone: " + this.getTelefone() + ", E-mail: " + this.getEmail() +"]";
	}

		
		
}
