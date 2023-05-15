package com.amodio.lab4;

public enum Cadastrar {
	
	CADASTRAR_CLIENTE(11),
	CADASTRAR_VEICULO(12),
	CADASTRAR_SEGURADORA(13),
	VOLTAR(10);

	private final int operacao ;
	
	Cadastrar(int operacao ) {
		this . operacao = operacao ;
	}

	public int getOperacao () {
		return this . operacao ;
	}
	public static Cadastrar busca(int valor) {
		for (Cadastrar i : Cadastrar.values()) {
			if (i.getOperacao() == valor) {
				return i;
			}
		}
		return null;
	}
}
