package com.amodio.lab5;

public class SeguroPF extends Seguro {
	
	//Declaração dos atributos
	private Veiculo veiculo;
	private ClientePF cliente;
	
	public SeguroPF(String dataInicio, String dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.cliente = cliente;
		cliente.adicionaVeiculoSegurado(veiculo);
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
	
	public double calcularValor() {
		int quantidadeSinistrosCliente = super.getSeguradora().numeroSinistros(cliente);
		int quantidadeSinistrosCondutor = 0;
		int quantidadeVeiculosSegurados;
		double fator_idade = cliente.fator_idade();
		
		if (cliente.getListaVeiculosSegurados()==null || cliente.getListaVeiculosSegurados().isEmpty()) {
			return 0.0;
		}
		
		quantidadeVeiculosSegurados = cliente.getListaVeiculosSegurados().size();
		
		for (Condutor c: super.getListaCondutores()) {
			quantidadeSinistrosCondutor += c.getListaSinistros().size();
		}
		
		return CalcSeguro.VALOR_BASE.getValor()*fator_idade*(1+1/(quantidadeVeiculosSegurados+2))*(2+quantidadeSinistrosCliente/10)*(5+quantidadeSinistrosCondutor/10);
	}
}
