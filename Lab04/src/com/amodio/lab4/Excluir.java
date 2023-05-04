package com.amodio.lab4;

public enum Excluir {
	
	EXCLUIR_CLIENTE(31),
	EXCLUIR_VEICULO(32),
	EXCLUIR_SINISTRO(33),
	VOLTAR(10);
	
public final int operacao ;
	
	Excluir(int operacao ) {
		this . operacao = operacao ;
	}

	public int getOperacao () {
		return this . operacao ;
	}
}
