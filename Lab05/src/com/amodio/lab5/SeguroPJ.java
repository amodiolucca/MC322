package com.amodio.lab5;

public class SeguroPJ extends Seguro {
	
	//Declaração dos atributos
	private Frota frota;
	private ClientePJ cliente;
	
	public SeguroPJ(String dataInicio, String dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
		super(dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.cliente = cliente;
	}
	
	//getters e setters
	public Frota getFrota() {
		return frota;
	}
	
	public ClientePJ getCliente() {
		return cliente;
	}
	
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	
	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
	/**
	 * Método que calcula o valor anual do seguro
	 */
	public double calcularValor() {
		int quantidadeFunc = super.getListaCondutores().size();
		int quantidadeVeiculos = frota.getListaVeiculos().size();
		int AnosPosFundacao = Validacao.anos_passados(cliente.getDataFundacao());
		int quantidadeSinistrosCondutor = super.getSinistrosCondutor();
		int quantidadeSinistrosCliente = super.getSeguradora().numeroSinistros(cliente);
		return (CalcSeguro.VALOR_BASE.getValor() * (10+(quantidadeFunc)/10) * (1+1/(quantidadeVeiculos+2))*
				(1+1/(AnosPosFundacao+2)) * (2+quantidadeSinistrosCliente/10) * (5 + quantidadeSinistrosCondutor/10));
	}
	
	@Override
	public String toString() {
		return "SeguroPJ [ID: " + this.getId() + ", Data de Início: " + this.getDataInicio() + ", Data de Fim: " + this.getDataFim() + ", Seguradora: " + this.getSeguradora()
				+ ", Valor Mensal: "+ this.getValorMensal() +"Frota: " + frota + ", Cliente: " + cliente + "]";
	}
	
}
