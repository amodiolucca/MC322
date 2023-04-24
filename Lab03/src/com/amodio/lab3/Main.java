package com.amodio.lab3; //Pacote com.amodio.lab3
 

import java.util.*;

public class Main { //Início da classe main
	
	public static void main(String[] args) { //Início do método main
		LinkedList<Cliente> listaPJ; //vão guardar as listas dos retornos futuros
		LinkedList<Cliente> listaPF;
		boolean sinistros_joao; //vão guardar os booleans para verificar se há sinistro para cada cliente
		boolean sinistros_samsung;
		boolean sinistros_google;
		//Instanciação dos objetos
		ClientePJ samsung = new ClientePJ("Samsung", "Avenida do Estado 221", "38.320.036/0001-25", "1975-08-06");
		ClientePJ apple = new ClientePJ("Apple", "Avenida Paulista 123", "22.222.222/2222-22", "1965-02-03"); //CNPJ inválido, apenas para testar
		ClientePJ google = new ClientePJ ("Google", "Avenida Brasil 222", "15.202.005/0001-74", "1950-06-11"); //Cliente adicional que apenas será adicionado e removido da seguradora
		ClientePF joao = new ClientePF("João", "Avenida 9 de Julho 281", "2023-02-17", "Médio Completo", "Masculino", "Classe B","427.638.700-07", "2004-07-11");
		ClientePF maria = new ClientePF ("Maria", "Avenida Norte Sul 111", "2023-01-15", "Superior completo", "Feminino", "Classe A", "111.111.111-11", "1985-02-13"); //CPF inválido, apenas para testar
		Veiculo focus = new Veiculo("5632", "Ford", "Focus");
		Veiculo civic = new Veiculo ("6974", "Honda", "Civic");
		Seguradora seguradora = new Seguradora ("Porto Seguro", "32569878", "portoseguro@gmail.com","Avenida Paulista 100");
		
		//Teste dos CPFs e CNPJs
		if(ClientePJ.validarCNPJ(samsung.getCnpj()) == true) {
			System.out.println("O CNPJ da Samsung é válido");
		} else {
			System.out.println("O CNPJ da Samsung é inválido");
		}
		
		if(ClientePJ.validarCNPJ("22.222.222/2222-22") == true) { //passando a string do CNPJ, pois o campo CNPJ do objeto apple é null por ser inválido
			System.out.println("O CNPJ da Apple é válido");
		} else {
			System.out.println("O CNPJ da Apple é inválido");
		}
		if(ClientePJ.validarCNPJ(google.getCnpj()) == true) {
			System.out.println("O CNPJ da Google é válido");
		} else {
			System.out.println("O CNPJ da Google é inválido");
		}
		if(ClientePF.validarCPF(joao.getCpf()) == true) {
			System.out.println("O CPF do João é válido");
		} else {
			System.out.println("O CPF do João é inválido");
		}
		
		if(ClientePF.validarCPF("111.111.111-11") == true) { //passando a string do CPF, pois o campo CPF do objeto maria é null por ser inválido
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
		if(samsung.cadastraVeiculo(focus)==false) {
			System.out.println("Veículo já cadastrado");
		}
		if(joao.cadastraVeiculo(civic)==false){
			System.out.println("Veículo já cadastrado");
		}
		if(seguradora.cadastrarCliente(samsung)==false){
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		if(seguradora.cadastrarCliente(joao)==false) {
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		System.out.println("Tentando cadastrar Maria:");
		if(seguradora.cadastrarCliente(maria)==false) { //Tem que dar mensagem de erro ao cadastrar, pois CPF é null
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		if(seguradora.cadastrarCliente(google)==false) {
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
		
		if(seguradora.gerarSinistro("2022-08-09", "Avenida Paulista 272", seguradora, joao, civic)==false) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o cliente é da seguradora");
		}
		if(seguradora.gerarSinistro("2021-07-24", "Avenida Carlos Grimaldi 210", seguradora, samsung, focus)==false) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o cliente é da seguradora");
		}
		
		//visualização dos sinistros:
		System.out.println("Sinistros da seguradora:");
		seguradora.listarSinistros();
		System.out.println("Visualizando os sinistos de João: ");
		sinistros_joao = seguradora.visualizarSinistro("João"); //A impressão dos sinistros ocorre no método
		if (sinistros_joao == false) { //se retorna false, não há sinistros nesse nome
			System.out.println("João não possui sinistros");
		}
		System.out.println("Visualizando os sinistos de Samsung: ");
		sinistros_samsung = seguradora.visualizarSinistro("Samsung");
		if (sinistros_samsung == false) {
			System.out.println("Samsung não possui sinistros");
		}
		System.out.println("Visualizando os sinistos da Google: ");
		sinistros_google = seguradora.visualizarSinistro("Google");
		if (sinistros_google == false) {
			System.out.println("Google não possui sinistros"); //deve imprimir isso, pois não há sinistro cadastrado para a Google
		}
		
		//Removendo Google da seguradora
		
		seguradora.removerCliente("Google");
		System.out.println("Todos os clientes da seguradora após remover Google:");
		seguradora.imprime_listaCliente(seguradora.getListaClientes()); //Google não aparece mais na lista de Clientes
		listaPJ = seguradora.listarClientes("ClientePJ");
		System.out.println("Clientes PJ da seguradora:");
		seguradora.imprime_listaCliente(listaPJ);//Google não aparece mais na lista de Clientes PJ
		
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
     		if (sinistros_joao == false) {
     			System.out.println("João não possui sinistros");
     		}
        } else if(entrada.equals("5")) { //se entrada for 5
        	 sinistros_samsung = seguradora.visualizarSinistro("Samsung"); //visualiza sinistros de Samsung
     		if (sinistros_samsung == false) {
     			System.out.println("Samsung não possui sinistros");
     		}
        } else { //se não for nenhuma das opções, mensagem de erro
        	 System.out.println("Entrada inválida");
        }
      		
        scan.close(); //fecha o scan

	} //Fim do método main
} //Fim da classe main
