package com.amodio.lab5;

import java.util.ArrayList;

public class SeguroPF extends Seguro {
	
	//Declaração dos atributos
	private Veiculo veiculo;
	private ClientePF cliente;
	
	public SeguroPF(String dataInicio, String dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.cliente = cliente;
		this.setValorMensal(this.calcularValor());
	}
	
	//getters e setters
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public ClientePF getCliente() {
		return cliente;
	}
	
	public void SetVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void SetCliente(ClientePF cliente) {
		this.cliente = cliente;
	}
	/**
	 * Método que calcula o valor anual do seguro
	 */
	public double calcularValor() {
		int quantidadeSinistrosCliente = super.getSeguradora().numeroSinistros(cliente);
		int quantidadeVeiculosSegurados;
		int quantidadeSinistrosCondutor;
		double fator_idade = cliente.fator_idade();
		ArrayList<Seguro> seguros = super.getSeguradora().getSegurosPorCliente(cliente.getDocumento());
		if(seguros == null) {
			return 0.0;
		}
		
		quantidadeVeiculosSegurados = seguros.size(); //quantidade de veículos segurados é igual a quantidade de seguros do cliente, pois cada seguro possui exatamente 1 cliente
		quantidadeSinistrosCondutor = super.getSinistrosCondutor();
		
		return CalcSeguro.VALOR_BASE.getValor()*fator_idade*(1+1/(quantidadeVeiculosSegurados+2))*(2+quantidadeSinistrosCliente/10)*(5+quantidadeSinistrosCondutor/10);
	}

	@Override
	public String toString() {
		return "SeguroPF [ID: " + this.getId() + ", Data de Início: " + this.getDataInicio() + ", Data de Fim: " + this.getDataFim() + ", Seguradora: " + this.getSeguradora()
				+ ", Valor Mensal: "+ this.getValorMensal() +"Veículo: " + veiculo + ", Cliente: " + cliente + "]";
	}
	
	
}
