package com.amodio.lab5;


public enum Cadastrar {
	
	CADASTRAR_CLIENTE(11),
	CADASTRAR_VEICULO(12),
	CADASTRAR_CONDUTOR(13),
	CADASTRAR_SEGURO(14),
	CADASTRAR_FROTA(15),
	CADASTRAR_SEGURADORA(16),
	VOLTAR(10);

	private final int operacao ;
	
	Cadastrar(int operacao ) { //construtor
		this . operacao = operacao ;
	}

	public int getOperacao () { //getter
		return this . operacao ;
	}
	public static Cadastrar busca(int valor) { //busca o valor correspondente
		for (Cadastrar i : Cadastrar.values()) {
			if (i.getOperacao() == valor) {
				return i;
			}
		}
		return null;
	}
}
