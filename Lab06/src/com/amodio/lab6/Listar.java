package com.amodio.lab6;


public enum Listar {
	
	LISTAR_CLIENTE_POR_SEGURADORA(21),
	LISTAR_SINISTROS_POR_SEGURADORA(22),
	LISTAR_SINISTRO_POR_CLIENTE(23),
	LISTAR_VEICULO_POR_CLIENTE(24),
	LISTAR_VEICULO_POR_SEGURADORA(25),
	LISTAR_SEGURO_POR_SEGURADORA(26),
	LISTAR_SINISTRO_POR_CONDUTOR(27),
	LISTAR_FROTA_POR_CLIENTE(28),
	LISTAR_VEICULO_POR_FROTA(29),
	LISTAR_SINISTRO_POR_SEGURO(30),
	LISTAR_CONDUTOR_POR_SEGURO(31),
	LISTAR_SEGURO_POR_CLIENTE(32),
	LISTAR_SINISTROS_POR_CLIENTE(33),
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
