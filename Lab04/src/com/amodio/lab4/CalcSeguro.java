package com.amodio.lab4; //pacote com.amodio.lab4

public enum CalcSeguro {
	VALOR_BASE(100.0),
	FATOR_18_30(1.2),
	FATOR_30_60(1.0),
	FATOR_60_90(1.5);

	private double valor;
	
	CalcSeguro(Double valor){ //construtor
		this.valor = valor;
	}
	
	public Double getValor(){ //getter
		return valor;
	}

}


