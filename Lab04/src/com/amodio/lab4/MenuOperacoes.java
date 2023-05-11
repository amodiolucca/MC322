package com.amodio.lab4;

public enum MenuOperacoes {
	CADASTRAR(1), LISTAR(2), EXCLUIR(3), GERAR_SINISTRO(4), TRANSFERIR_SEGURO(5), CALCULAR_RECEITA_SEGURADORA(6), SAIR(0);

	final int valor;

	MenuOperacoes(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}


	public static MenuOperacoes busca(int valor) {
		for (MenuOperacoes i : MenuOperacoes.values()) {
			if (i.getValor() == valor) {
				return i;
			}
		}
		return null;
	}
}
