package com.amodio.lab6;


public enum MenuOperacoes {
	CADASTRAR(1), LISTAR(2), EXCLUIR(3), GERAR_SINISTRO(4), TRANSFERIR_SEGURO(5), CALCULAR_RECEITA_SEGURADORA(6), GRAVAR_DADOS(7), LER_DADOS(8), SAIR(0);

	private final int valor;

	MenuOperacoes(int valor) { //construtor
		this.valor = valor;
	}

	public int getValor() { //getter
		return this.valor;
	}


	public static MenuOperacoes busca(int valor) { //busca a operação correspondente ao valor
		for (MenuOperacoes i : MenuOperacoes.values()) {
			if (i.getValor() == valor) {
				return i;
			}
		}
		return null;
	}
}
