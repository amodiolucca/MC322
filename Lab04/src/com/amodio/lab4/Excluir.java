package com.amodio.lab4;

public enum Excluir {
	
	EXCLUIR_CLIENTE(31),
	EXCLUIR_VEICULO(32),
	EXCLUIR_SINISTRO(33),
	VOLTAR(10);
	
	private final int operacao ;
	
	Excluir(int operacao ) { //construtor
		this . operacao = operacao ;
	}

	public int getOperacao () { //getter
		return this . operacao ;
	}
	
	public static Excluir busca(int valor) { //busca a operação correspondente ao valor
		for (Excluir i : Excluir.values()) {
			if (i.getOperacao() == valor) {
				return i;
			}
		}
		return null;
	}
}
