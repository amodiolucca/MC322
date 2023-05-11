package com.amodio.lab4;

import java.util.LinkedList;
import java.util.Scanner;

public class AppMain{
	 
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		LinkedList<Cliente> listaPJ; //vão guardar as listas dos retornos futuros
		LinkedList<Cliente> listaPF;
		boolean sinistros_joao; //vão guardar os booleans para verificar se há sinistro para cada cliente
		boolean sinistros_samsung;
		boolean sinistros_google;
		//Instanciação dos objetos
		ClientePJ samsung = new ClientePJ("Samsung", "Avenida do Estado 221", "38.320.036/0001-25", "1975-08-06",100);
		ClientePJ apple = new ClientePJ("Apple", "Avenida Paulista 123", "22.222.222/2222-22", "1965-02-03",500); //CNPJ inválido, apenas para testar
		ClientePJ google = new ClientePJ ("Google", "Avenida Brasil 222", "15.202.005/0001-74", "1950-06-11", 700); //Cliente adicional que apenas será adicionado e removido da seguradora
		ClientePF joao = new ClientePF("João", "Avenida 9 de Julho 281", "2023-02-17", "Médio Completo", "Masculino", "Classe B","427.638.700-07", "2003-04-11");
		ClientePF maria = new ClientePF ("Maria", "Avenida Norte Sul 111", "2023-01-15", "Superior completo", "Feminino", "Classe A", "111.111.111-11", "1985-02-13"); //CPF inválido, apenas para testar
		Veiculo focus = new Veiculo("5632", "Ford", "Focus",2010);
		Veiculo civic = new Veiculo ("6974", "Honda", "Civic",2021);
		Seguradora seguradora = new Seguradora ("Porto Seguro", "32569878", "portoseguro@gmail.com","Avenida Paulista 100");
		Seguradora.adicionaSeguradora(seguradora);
		//Teste dos CPFs e CNPJs
		if(ClientePJ.validarCNPJ(samsung.getCnpj())) {
			System.out.println("O CNPJ da Samsung é válido");
		} else {
			System.out.println("O CNPJ da Samsung é inválido");
		}
		
		if(ClientePJ.validarCNPJ("22.222.222/2222-22")) { //passando a string do CNPJ, pois o campo CNPJ do objeto apple é null por ser inválido
			System.out.println("O CNPJ da Apple é válido");
		} else {
			System.out.println("O CNPJ da Apple é inválido");
		}
		if(ClientePJ.validarCNPJ(google.getCnpj())) {
			System.out.println("O CNPJ da Google é válido");
		} else {
			System.out.println("O CNPJ da Google é inválido");
		}
		if(ClientePF.validarCPF(joao.getCpf())) {
			System.out.println("O CPF do João é válido");
		} else {
			System.out.println("O CPF do João é inválido");
		}
		
		if(ClientePF.validarCPF("111.111.111-11")) { //passando a string do CPF, pois o campo CPF do objeto maria é null por ser inválido
			System.out.println("O CPF da Maria é válido");
		} else {
			System.out.println("O CPF da Maria é inválido");
		}
		
		//Impressão dos toString
		System.out.println("Samsung:");
		System.out.println(samsung);
		System.out.println("João:");
		System.out.println(joao);
		System.out.println("Apple:");
		System.out.println(apple); //CNPJ é null
		System.out.println("Maria:");
		System.out.println(maria); //CPF é null
		System.out.println("Focus:");
		System.out.println(focus);
		System.out.println("Civic:");
		System.out.println(civic);
		System.out.println("Seguradora:");
		System.out.println(seguradora);
		System.out.println("Google:");
		System.out.println(google);
		
		//Cadastros de veículos e clientes
		if(!samsung.cadastraVeiculo(focus)) {
			System.out.println("Veículo já cadastrado");
		}
		if(!joao.cadastraVeiculo(civic)){
			System.out.println("Veículo já cadastrado");
		}
		if(!seguradora.cadastrarCliente(samsung)){
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		if(!seguradora.cadastrarCliente(joao)) {
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		System.out.println("Tentando cadastrar Maria:");
		if(!seguradora.cadastrarCliente(maria)) { //Tem que dar mensagem de erro ao cadastrar, pois CPF é null
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		if(!seguradora.cadastrarCliente(google)) {
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		//Imprimindo a lista de veículos de Samsung e João
		System.out.println("Veículos de Samsung:");
		samsung.imprimeListaVeiculos(samsung.getListaVeiculos());
		System.out.println("Veículos de João:");
		samsung.imprimeListaVeiculos(joao.getListaVeiculos());
		
		//Testando o método de listar Clientes
		System.out.println("Clientes PJ da Seguradora:");
		listaPJ = seguradora.listarClientes("ClientePJ");
		seguradora.imprime_listaCliente(listaPJ);
		
		System.out.println("Clientes PF da Seguradora:");
		listaPF = seguradora.listarClientes("ClientePF");
		seguradora.imprime_listaCliente(listaPF);
		
		System.out.println("Todos os clientes da seguradora:");
		seguradora.imprime_listaCliente(seguradora.getListaClientes());
		
		//Gerando sinistros
		
		if(!seguradora.gerarSinistro("2022-08-09", "Avenida Paulista 272", seguradora, joao, civic)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o cliente é da seguradora");
		}
		if(!seguradora.gerarSinistro("2021-07-24", "Avenida Carlos Grimaldi 210", seguradora, samsung, focus)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o cliente é da seguradora");
		}
		
		//visualização dos sinistros:
		System.out.println("Sinistros da seguradora:");
		seguradora.listarSinistros();
		System.out.println("Visualizando os sinistos de João: ");
		sinistros_joao = seguradora.visualizarSinistro("João"); //A impressão dos sinistros ocorre no método
		if (!sinistros_joao) { //se retorna false, não há sinistros nesse nome
			System.out.println("João não possui sinistros");
		}
		System.out.println("Visualizando os sinistos de Samsung: ");
		sinistros_samsung = seguradora.visualizarSinistro("Samsung");
		if (!sinistros_samsung) {
			System.out.println("Samsung não possui sinistros");
		}
		System.out.println("Visualizando os sinistos da Google: ");
		sinistros_google = seguradora.visualizarSinistro("Google");
		if (!sinistros_google) {
			System.out.println("Google não possui sinistros"); //deve imprimir isso, pois não há sinistro cadastrado para a Google
		}
		//Removendo Google da seguradora
		seguradora.removerCliente("Google");
		System.out.println("Todos os clientes da seguradora após remover Google:");
		seguradora.imprime_listaCliente(seguradora.getListaClientes()); //Google não aparece mais na lista de Clientes
		listaPJ = seguradora.listarClientes("ClientePJ");
		System.out.println("Clientes PJ da seguradora:");
		seguradora.imprime_listaCliente(listaPJ);//Google não aparece mais na lista de Clientes PJ
		/*
		//Implementação do método de leitura de dados
		Scanner scan = new Scanner(System.in);
        	System.out.println("Escolha alguma das opções de visualização abaixo:");
		System.out.println("Para listar os sinistros da seguradora, digite 1.");
		System.out.println("Para listar os clientes PF da seguradora, digite 2.");
		System.out.println("Para listar os clientes PJ, digite 3.");
		System.out.println("Para listar os sinistros de João, digite 4.");
		System.out.println("Para listar os sinistros de Samsung, digite 5.");
		System.out.println("Digite sua entrada:");
		String entrada = scan.next(); //faz a leitura

		if(entrada.equals("1")) { //se entrada for 1
			seguradora.listarSinistros(); //lista os sinistros
		} else if(entrada.equals("2")) { //se entrada for 2
			listaPF = seguradora.listarClientes("ClientePF"); //lista os clientes PF
			seguradora.imprime_listaCliente(listaPF);
		}else if(entrada.equals("3")){ //se entrada for 3
			listaPJ = seguradora.listarClientes("ClientePJ"); //lista os clientes PJ
			seguradora.imprime_listaCliente(listaPJ);
		}else if(entrada.equals("4")) { //se entrada for 4
			 sinistros_joao = seguradora.visualizarSinistro("João"); //visualiza os sinistros de João
			if (!sinistros_joao) {
				System.out.println("João não possui sinistros");
			}
		} else if(entrada.equals("5")) { //se entrada for 5
			 sinistros_samsung = seguradora.visualizarSinistro("Samsung"); //visualiza sinistros de Samsung
			if (!sinistros_samsung) {
				System.out.println("Samsung não possui sinistros");
			}
		} else { //se não for nenhuma das opções, mensagem de erro
			 System.out.println("Entrada inválida");
		}

		scan.close(); //fecha o scan
		System.out.println(joao.calcula_idade());
		System.out.println(seguradora.calcularReceita());
		System.out.println(samsung.getValorSeguro());
		System.out.println(joao.getValorSeguro());
		*/
		
		menu();
	}
	public static void menu() {
		String escolha, data, endereco;
		int escolha2;
		Seguradora seguradora;
		Cliente cliente;
		Veiculo veiculo;
		System.out.println("ESCOLHA UMA DAS OPÇÕES:");
		for(MenuOperacoes m: MenuOperacoes.values()) {
			System.out.println(m.valor + " - " + m);
		}
		escolha2 = scan.nextInt();
		scan.nextLine();
		MenuOperacoes m = MenuOperacoes.busca(escolha2); //.busca(valor lido)
		switch(m) {
			case CADASTRAR:
				cadastrar();
				break;
			case LISTAR:
				listar();
				break;
			case EXCLUIR:
				excluir();
				break;
			case GERAR_SINISTRO:
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
			case CALCULAR_RECEITA_SEGURADORA:
				seguradora = escolherSeguradora();
				if(seguradora == null) {
					System.out.println("Seguradora não encontrada");
					break;
				}
				System.out.println(seguradora.calcularReceita());
				break;
			case SAIR:
				break;
			default:
				System.out.println("Escolha uma opção válida");
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
		System.out.println("Escolha uma cliente pelo CPF correspondente:");
		escolha = scan.nextLine();
		cliente = seguradora.buscarCliente(escolha);
		return cliente;
	}
/*
	public Cliente criarCliente() {
		String nome, cpf,endereco, dataLicenca, educacao, genero,
		classeEconomica,dataNascimento,escolha;
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