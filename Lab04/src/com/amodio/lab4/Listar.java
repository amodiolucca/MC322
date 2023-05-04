package com.amodio.lab4;

public enum Listar {
	
	LISTAR_CLIENTE_POR_SEGURADORA(21),
	LISTAR_SINISTROS_POR_SEGURADORA(22),
	LISTAR_SINISTRO_POR_CLIENTE(23),
	LISTAR_VEICULO_POR_CLIENTE(24),
	LISTAR_VEICULO_POR_SEGURADORA(25),
	VOLTAR(10);
	
public final int operacao ;
	
	Listar(int operacao ) {
		this . operacao = operacao ;
	}

	public int getOperacao () {
		return this . operacao ;
	}
}
