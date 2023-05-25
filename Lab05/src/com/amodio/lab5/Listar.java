package com.amodio.lab5;


public enum Listar {
	
	LISTAR_CLIENTE_POR_SEGURADORA(21),
	LISTAR_SINISTROS_POR_SEGURADORA(22),
	LISTAR_SINISTRO_POR_CLIENTE(23),
	LISTAR_VEICULO_POR_CLIENTE(24),
	LISTAR_VEICULO_POR_SEGURADORA(25),
	VOLTAR(10);
	
	private final int operacao ;
	
	Listar(int operacao ) { //construtor
		this . operacao = operacao ;
	}

	public int getOperacao () { //getter
		return this . operacao ;
	}
	
	public static Listar busca(int valor) { //busca a operação correspondente ao valor
		for (Listar i : Listar.values()) {
			if (i.getOperacao() == valor) {
				return i;
			}
		}
		return null;
	}
}
