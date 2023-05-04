package com.amodio.lab4;

import java.util.Scanner;

public class AppMain{
	 
	static Scanner scan = new Scanner(System.in);
	
	public static void menu() {
		String escolha, data, endereco;
		Seguradora seguradora;
		Cliente cliente;
		Veiculo veiculo;
		System.out.println("ESCOLHA UMA DAS OPÇÕES:");
		for(MenuOperacoes m: MenuOperacoes.values()) {
			System.out.println(m);
		}
		
		escolha = scan.nextLine(); 
		MenuOperacoes m = MenuOperacoes.valueOf(escolha);
		switch(m.operacao) {
			case 1:
				cadastrar();
				break;
			case 2:
				listar();
				break;
			case 3:
				excluir();
				break;
			case 4:
				System.out.println("Escolha uma data para o sinistro na forma yyyy-mm-dd:");
				data = scan.nextLine();
				System.out.println("Escolha um endereço para o sinistro:");
				endereco = scan.nextLine();
				seguradora = escolherSeguradora();
				if(seguradora == null) {
					System.out.println("Seguradora não encontrada");
					break;
				}
				System.out.println("Escolha um cliente pelo nome correspondente:");
				escolha = scan.nextLine();
				cliente = seguradora.buscarCliente(escolha);
				if(cliente == null) {
					System.out.println("Cliente não encontrado");
					break;
				}
				System.out.println("Escolha um veículo pelo nome correspondente:");
				escolha = scan.nextLine();
				veiculo = cliente.buscarVeiculo(escolha);
				if(veiculo == null) {
					System.out.println("Veículo não encontrado");
					break;
				}
				if(seguradora.gerarSinistro(data, endereco, seguradora, cliente, veiculo)) {
					System.out.println("Sinistro gerado com sucesso");
				} else {
					System.out.println("Erro ao gerar o sinistro");
				}
				break;
			case 6:
				seguradora = escolherSeguradora();
				if(seguradora == null) {
					System.out.println("Seguradora não encontrada");
					break;
				}
				System.out.println(seguradora.calcularReceita());
				break;
			case 0:
				break;
		}
		
	}
	
	public static void cadastrar() {
		String escolha;
		Seguradora seguradora;
		System.out.println("ESCOLHA UMA DAS OPÇÕES:");
		for(Cadastrar c: Cadastrar.values()) {
			System.out.println(c);
		}
		
		escolha = scan.nextLine(); 
		Cadastrar c = Cadastrar.valueOf(escolha);
		switch(c.operacao) {
			case 10:
				menu();
				break;
			case 11:
				seguradora = escolherSeguradora();
				if(seguradora == null) {
					System.out.println("Seguradora não encontrada");
					break;
				}
				
		}
	}
	
	public static void listar() {
		String escolha;
		System.out.println("ESCOLHA UMA DAS OPÇÕES:");
		for(Listar l: Listar.values()) {
			System.out.println(l);
		}
		
		escolha = scan.nextLine(); 
		Listar l = Listar.valueOf(escolha);
		switch(l.operacao) {
			case 10:
				menu();
				break;
			
		}
	}
	
	public static void excluir() {
		String escolha;
		System.out.println("ESCOLHA UMA DAS OPÇÕES:");
		for(Excluir e: Excluir.values()) {
			System.out.println(e);
		}
		
		escolha = scan.nextLine(); 
		Excluir e = Excluir.valueOf(escolha);
		switch(e.operacao) {
			case 10:
				menu();
				break;
		}
	}
	
	public static Seguradora escolherSeguradora() {
		String escolha;
		Seguradora seguradora;
		System.out.println("Escolha uma seguradora pelo nome correspondente:");
		escolha = scan.nextLine();
		seguradora = Seguradora.buscarSeguradora(escolha);
		return seguradora;
	}
	
	public static Cliente escolherCliente(Seguradora seguradora) {
		String escolha;
		Cliente cliente;
		System.out.println("Escolha uma cliente pelo nome correspondente:");
		escolha = scan.nextLine();
		cliente = seguradora.buscarCliente(escolha);
		return cliente;
	}
/*
	public Cliente criarCliente() {
		String cpf,endereco, dataLicenca, educacao, genero,
		classeEconomica,dataNascimento;
		System.out.println("Escolha por cliente PF ou PJ(PF/PJ)");
		escolha = scan.nextLine();
		if(escolha == "PF") {
			System.out.println("Digite o nome do cliente:");
			nome = scan.nextLine();
			System.out.println("Digite o endereço do cliente:");
			endereco = scan.nextLine();
			System.out.println("Digite a data de licença do cliente na forma yyyy-mm-dd:");
			dataLicenca = scan.nextLine();
			System.out.println("Digite o nível de educação do cliente:");
			educacao = scan.nextLine();
			System.out.println("Digite o gênero do cliente:");
			genero = scan.nextLine();
			System.out.println("Digite a classe econômica do cliente:");
			classeEconomica = scan.nextLine();
			System.out.println("Digite o CPF do cliente do cliente:");
			cpf = scan.nextLine();
			System.out.println("Digite a data de nascimento do cliente na forma yyyy-mm-dd:");
			dataNascimento = scan.nextLine();
		}
		
	}
*/
}