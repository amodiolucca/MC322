package com.amodio.lab5;


public enum Excluir {
	
	EXCLUIR_CLIENTE(31),
	EXCLUIR_VEICULO(32),
	EXCLUIR_SINISTRO(33),
	EXCLUIR_CONDUTOR(34),
	EXCLUIR_TODAS_FROTAS(35),
	EXCLUIR_FROTA(36),
	EXCLUIR_SEGURO(37),
	EXCLUIR_SEGURADORA(38),
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
