package com.amodio.lab4;

import java.util.LinkedList;
import java.util.Scanner;

public class AppMain{
	
	public static void main(String[] args) {
		ClientePJ samsung = null;
		ClientePJ apple= null;
		ClientePJ google= null;
		ClientePF joao= null;
		ClientePF maria= null;
		Scanner scan = new Scanner(System.in);
		LinkedList<Cliente> listaPJ; //vão guardar as listas dos retornos futuros
		LinkedList<Cliente> listaPF;
		boolean sinistros_joao; //vão guardar os booleans para verificar se há sinistro para cada cliente
		boolean sinistros_samsung;
		boolean sinistros_google;
		//Instanciação dos objetos
		
		Veiculo focus = new Veiculo("5632", "Ford", "Focus",2010);
		Veiculo civic = new Veiculo ("6974", "Honda", "Civic",2021);
		Seguradora seguradora = new Seguradora ("Porto Seguro", "32569878", "portoseguro@gmail.com","Avenida Paulista 100");
		//Teste dos CPFs e CNPJs
		if(Validacao.validarCNPJ("38.320.036/0001-25")) {
			System.out.println("O CNPJ da Samsung é válido");
			samsung = new ClientePJ("Samsung", "Avenida do Estado 221", "38.320.036/0001-25", "1975-08-06",100);
		} else {
			System.out.println("O CNPJ da Samsung é inválido");
		}
		
		if(Validacao.validarCNPJ("22.222.222/2222-22")) {
			System.out.println("O CNPJ da Apple é válido");
			apple = new ClientePJ("Apple", "Avenida Paulista 123", "22.222.222/2222-22", "1965-02-03",500); //CNPJ inválido, apenas para testar
		} else {
			System.out.println("O CNPJ da Apple é inválido");
		}
		
		if(Validacao.validarCNPJ("15.202.005/0001-74")) {
			System.out.println("O CNPJ da Google é válido");
			google = new ClientePJ ("Google", "Avenida Brasil 222", "15.202.005/0001-74", "1950-06-11", 700); //Cliente adicional que apenas será adicionado e removido da seguradora
		} else {
			System.out.println("O CNPJ da Google é inválido");
		}
		if(Validacao.validarCPF("427.638.700-07")) {
			System.out.println("O CPF do João é válido");
			joao = new ClientePF("João", "Avenida 9 de Julho 281", "2023-02-17", "Médio Completo", "Masculino", "Classe B","427.638.700-07", "2003-04-11");
			
		} else {
			System.out.println("O CPF do João é inválido");
		}
		
		if(Validacao.validarCPF("111.111.111-11")) { //passando a string do CPF, pois o campo CPF do objeto maria é null por ser inválido
			System.out.println("O CPF da Maria é válido");
			maria = new ClientePF ("Maria", "Avenida Norte Sul 111", "2023-01-15", "Superior completo", "Feminino", "Classe A", "111.111.111-11", "1985-02-13"); //CPF inválido, apenas para testar
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
		if(!samsung.cadastraVeiculo(focus, seguradora)) {
			System.out.println("Veículo já cadastrado");
		}
		if(!joao.cadastraVeiculo(civic, seguradora)){
			System.out.println("Veículo já cadastrado");
		}
		if(!seguradora.cadastrarCliente(samsung)){
			System.out.println("Cliente já cadastrado ou cliente inválido");
		}
		if(!seguradora.cadastrarCliente(joao)) {
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
		listaPJ = seguradora.listarClientes("PJ");
		seguradora.imprime_listaCliente(listaPJ);
		
		System.out.println("Clientes PF da Seguradora:");
		listaPF = seguradora.listarClientes("PF");
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
		sinistros_joao = seguradora.visualizarSinistro("427.638.700-07"); //A impressão dos sinistros ocorre no método
		if (!sinistros_joao) { //se retorna false, não há sinistros nesse nome
			System.out.println("João não possui sinistros");
		}
		System.out.println("Visualizando os sinistos de Samsung: ");
		sinistros_samsung = seguradora.visualizarSinistro("38.320.036/0001-25");
		if (!sinistros_samsung) {
			System.out.println("Samsung não possui sinistros");
		}
		System.out.println("Visualizando os sinistos da Google: ");
		sinistros_google = seguradora.visualizarSinistro("15.202.005/0001-74");
		if (!sinistros_google) {
			System.out.println("Google não possui sinistros"); //deve imprimir isso, pois não há sinistro cadastrado para a Google
		}
		//Removendo Google da seguradora
		if(seguradora.removerCliente("15.202.005/0001-74")) {
			System.out.println("Google removido com sucesso");
		}
		System.out.println("Todos os clientes da seguradora após remover Google:");
		seguradora.imprime_listaCliente(seguradora.getListaClientes()); //Google não aparece mais na lista de Clientes
		listaPJ = seguradora.listarClientes("PJ");
		System.out.println("Clientes PJ da seguradora:");
		seguradora.imprime_listaCliente(listaPJ);//Google não aparece mais na lista de Clientes PJ
		
		//Preço dos seguros e receita total da seguradora
		System.out.println("Preço do seguro de João:");
		System.out.println(seguradora.calcularPrecoSeguroCliente(joao));
		System.out.println("Preço do seguro de Samsumg:");
		System.out.println(seguradora.calcularPrecoSeguroCliente(samsung));
		System.out.println("Receita da seguradora:");
		System.out.println(seguradora.calcularReceita());
		
		menu(scan);
		scan.close();
	}
	
	/*
	 * Função para o menu principal, que organiza as funcionalidades da tela de entrada
	 */
	public static void menu(Scanner scan) {
		//declaração das variáveis
		String data, endereco;
		int escolhaOp;
		Seguradora seguradora;
		Cliente cliente, cliente_recebe;
		Veiculo veiculo;

		//rótulo para o laço, para podermos sair com o break externo
		menu_op:
			while (true) {
				//Impressão das opções 
				System.out.println("ESCOLHA UMA DAS OPÇÕES:");
				for (MenuOperacoes m : MenuOperacoes.values()) {
					System.out.println(m.getValor() + " - " + m);
				}
				//scan na escolha e busca da opção correspondente
				escolhaOp = scan.nextInt();
				scan.nextLine(); //consome o \n que sobra da entrada
				MenuOperacoes m = MenuOperacoes.busca(escolhaOp); //.busca(valor lido)
				
				if (m != null) {
					switch (m) {
					
					case CADASTRAR:
						cadastrar(scan); //chama a tela de cadastro
						break;
					
					case LISTAR:
						listar(scan); //chama a tela de listagem
						break;
					
					case EXCLUIR:
						excluir(scan); //chama a tela de exclusão
						break;
					
					case GERAR_SINISTRO:
						System.out.println("Escolha uma data para o sinistro na forma yyyy-mm-dd:");
						data = scan.nextLine(); //data do sinistro
						if(!Validacao.validaData(data)) { //verifica se a data é válida
							System.out.println("Insira uma data válida no formato indicado. Voltando ao menu");
							break;
						}
						System.out.println("Escolha um endereço para o sinistro:");
						endereco = scan.nextLine(); //endereço do sinistro
						seguradora = escolherSeguradora(scan); //seguradora do sinistro
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada. Voltando ao menu...");
							break;
						}
						cliente = escolherCliente(seguradora,scan); //cliente do sinistro
						if (cliente == null) {
							System.out.println("Cliente não encontrado. Voltando ao menu...");
							break;
						}
						veiculo = escolherVeiculo(cliente, scan);
						if (veiculo == null) {
							System.out.println("O cliente não possui esse veículo. Voltando ao menu...");
							break;
						}
						if (seguradora.gerarSinistro(data, endereco, seguradora, cliente, veiculo)) {
							System.out.println("Sinistro gerado com sucesso");
						} else {
							System.out.println("Erro ao gerar o sinistro");
						}
						break;
					//Para a transferencia, o cliente que receberá a lista de veículos já deve ter sido cadastrado na seguradora
					//Assume-se que a lista de veículos dele é null anteriormente, pois acabou de ser cadastrado para receber o seguro
					//transferido
					case TRANSFERIR_SEGURO:
						seguradora = escolherSeguradora(scan);
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu...");
							break;
						}
						System.out.println("Escolha primeiro o cliente que transferirá o seguro");
						cliente = escolherCliente(seguradora,scan);
						if (cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu...");
							break;
						}
						if((cliente.getListaVeiculos()==null) || (cliente.getListaVeiculos().isEmpty()) ) { //se o cliente escolhido não possui veículos
							System.out.println("O cliente não possui veículos, voltando ao menu...");
							break;
						}
						System.out.println("Escolha agora o cliente que receberá o seguro");
						cliente_recebe = escolherCliente(seguradora,scan); //cliente que vai receber a lista de veículos
						if (cliente_recebe == null) {
							System.out.println("Cliente não encontrado, voltando ao menu...");
							break;
						}
						if(cliente.equals(cliente_recebe)) {
							System.out.println("Você escolheu o mesmo cliente duas vezes. Voltando ao menu...");
							break;
						}
						if((cliente_recebe.getListaVeiculos()!=null) && (!cliente_recebe.getListaVeiculos().isEmpty()) ) { //se o cliente escolhido não possui veículos
							System.out.println("O cliente receptor possui veículos, escolha um cliente sem veículos para transferir seu seguro. Voltando ao menu...");
							break;
						}
			
						cliente_recebe.setListaVeiculos(cliente.getListaVeiculos());
						cliente.setListaVeiculos(null);
						cliente_recebe.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente_recebe)); //atualiza o valorSeguro
						cliente.setValorSeguro(seguradora.calcularPrecoSeguroCliente(cliente)); //atualiza o valorSeguro
						System.out.println("Transferência realizada com sucesso");
						break;
						
					case CALCULAR_RECEITA_SEGURADORA:
						seguradora = escolherSeguradora(scan);
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada");
							break;
						}
						System.out.println("A receita da seguradora é: " + seguradora.calcularReceita()); //imprime a receita na tela
						break;
					
					case SAIR:
						break menu_op; //sai do laço externo
					
					default:
						break;
					}
				} else {
					System.out.println("Escolha uma opção válida");
	
				} 
			}
	}
	
	/*
	 * Função para o menu de cadastrar, que organiza as funcionalidades da tela de cadastro
	 * Sempre instancia o objeto a ser cadastrado. Caso queira cadastrar um objeto instanciado na main em outra seguradora, basta
	 * passar seus dados na instanciação
	 */
	public static void cadastrar(Scanner scan) {
		int escolhaOp;
		Seguradora seguradora;
		Cliente cliente;
		Veiculo veiculo;
		
		//rótulo para o laço, para podermos sair com o break externo
		menu_cadastrar:
			while(true) {
				//Impressão das opções
				System.out.println("ESCOLHA UMA DAS OPÇÕES:");
				for(Cadastrar c: Cadastrar.values()) {
					System.out.println(c.getOperacao() + " - " + c);
				}
				//scan na escolha e busca da opção correspondente
				escolhaOp = scan.nextInt();
				scan.nextLine(); //consome o \n que sobra da entrada
				Cadastrar c= Cadastrar.busca(escolhaOp); //.busca(valor lido)
				if(c!= null) {
					
					switch(c) {
					
					case VOLTAR:
						break menu_cadastrar; //break externo
					
					case CADASTRAR_CLIENTE:
						seguradora = escolherSeguradora(scan); //seguradora escolhida
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu cadastrar...");
							break;
						}
						
						cliente = criarCliente(scan, seguradora); //cria um cliente para o cadastro
						if(cliente == null) {
							break;
						}
						if(seguradora.cadastrarCliente(cliente)){ //tenta cadastrar o cliente
							System.out.println("Cliente cadastrado com sucesso");
						} else {
							System.out.println("Erro ao cadastrar o veículo");
						}
						break menu_cadastrar;
					
					case CADASTRAR_VEICULO:
						seguradora = escolherSeguradora(scan); //seguradora escolhida
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu cadastrar...");
							break;
						}
						cliente = escolherCliente(seguradora,scan); //cliente escolhido
						if(cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu cadastrar...");
							break;
						}
						veiculo = criarVeiculo(scan, cliente); //cria um veículo
						if(veiculo ==null) {
							break;
						}
						if (cliente.cadastraVeiculo(veiculo, seguradora)) {
							System.out.println("Veículo cadastrado com sucesso"); //faz a busca pelo modelo
						}else {
							System.out.println("Erro ao cadastrar o veículo");
						}
						break menu_cadastrar;
						
					case CADASTRAR_SEGURADORA:
						if(!criarSeguradora(scan)) { //Instanciação de uma seguradora
							System.out.println("Seguradora cadastrada anteriormente, voltando ao menu cadastrar...");
							break;
						}
						System.out.println("Seguradora já cadastrada com sucesso. Voltando ao menu...");
						break menu_cadastrar;
					default:
						break;
					}
				} else {
					System.out.println("Escolha uma opção válida");
	
				} 
			}
		
	}
	/*
	 * Função para o menu listar, que organiza as funcionalidades da tela de listagem
	 */
	public static void listar(Scanner scan) {
		int escolhaOp;
		String tipoCliente;
		Seguradora seguradora;
		LinkedList<Cliente> listaCliente;
		Cliente cliente;

		//rótulo para o laço, para podermos sair com o break externo
		menu_listar:
			while(true) {
				//Lista as opções
				System.out.println("ESCOLHA UMA DAS OPÇÕES:");
				for(Listar l: Listar.values()) {
					System.out.println(l.getOperacao() + " - " + l);
				}
				
				escolhaOp = scan.nextInt();
				scan.nextLine(); //consome o \n que sobra da entrada
				Listar l = Listar.busca(escolhaOp); //.busca(valor lido)
				
				if(l!= null) {
					switch(l) {
					
					case VOLTAR:
						break menu_listar;
					
					case LISTAR_CLIENTE_POR_SEGURADORA:
						seguradora = escolherSeguradora(scan); //seguradora escolhida
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						System.out.println("Escolha entre PF ou PJ"); //escolhe se quer listar PF ou PJ
						tipoCliente = scan.nextLine();
						if(!(tipoCliente.equals("PF")||tipoCliente.equals("PJ"))) {
							System.out.println("Escolha uma entrada válida, voltando ao menu listar...");
							break;
						}
						listaCliente = seguradora.listarClientes(tipoCliente); //lista com os clientes
						seguradora.imprime_listaCliente(listaCliente); //imprime a lista
						break menu_listar;
					
					case LISTAR_SINISTROS_POR_SEGURADORA:
						seguradora = escolherSeguradora(scan); //escolhe a seguradora
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						seguradora.listarSinistros(); //lista os sinistros
						break menu_listar;
					
					case LISTAR_SINISTRO_POR_CLIENTE:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						cliente = escolherCliente(seguradora,scan);
						if(cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu listar...");
							break;
						}
						if(!seguradora.visualizarSinistro(cliente.getDocumento())) { //se retorna false, não tem sinistros
							System.out.println("O cliente não possui sinistros");
						}
						break menu_listar;
					
					case LISTAR_VEICULO_POR_CLIENTE:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						cliente = escolherCliente(seguradora,scan);
						if(cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu listar...");
							break;
						}
						cliente.imprimeListaVeiculos(cliente.getListaVeiculos()); //imprime veículos do cliente
						break menu_listar;
					
					case LISTAR_VEICULO_POR_SEGURADORA:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						if(!seguradora.listarVeiculos()) {
							System.out.println("A seguradora não possui veículos"); //se retorna falso, não possui veículos
						}
						break menu_listar;
					default:
						break;
					}
				} else {
					System.out.println("Escolha uma opção válida");
	
				} 
			}
	}
	/*
	 * Função para o menu excluir, que organiza as funcionalidades da tela de exclusão
	 */
	public static void excluir(Scanner scan) {
		String placa;
		int escolhaOp, id;
		Cliente cliente;
		Seguradora seguradora;

		//rótulo para o laço, para podermos sair com o break externo
		menu_excluir:
			while(true) {
				//Lista as opções
				System.out.println("ESCOLHA UMA DAS OPÇÕES:");
				for(Excluir e: Excluir.values()) {
					System.out.println(e.getOperacao() + " - " + e);
				}
				//scan da escolha e busca pelo valor correspondente
				escolhaOp = scan.nextInt();
				scan.nextLine(); //consome o \n que sobra da entrada
				Excluir e = Excluir.busca(escolhaOp); //.busca(valor lido)
				
				if(e!=null) {
					switch(e) {
					
					case VOLTAR:
						break menu_excluir;
					
					case EXCLUIR_CLIENTE:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu excluir...");
							break;
						}
						cliente = escolherCliente(seguradora,scan);
						if(cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu excluir...");
							break;
						}
						if(seguradora.removerCliente(cliente.getDocumento())) { //remove pelo documento
							System.out.println("Cliente removido com sucesso");
						} else {
							System.out.println("A seguradora não possui esse cliente, voltando ao menu..."); //não encontrou o cliente
						}
						break menu_excluir;
					
					case EXCLUIR_VEICULO:
						seguradora = escolherSeguradora(scan);
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu excluir...");
							break;
						}
						cliente = escolherCliente(seguradora, scan);
						if (cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu excluir...");
							break;
						}
						System.out.println("Escolha o veículo a ser removido pela placa.");
						if((cliente.getListaVeiculos()!= null) && (!cliente.getListaVeiculos().isEmpty())){
							System.out.println("Opções:");
							for(Veiculo v: cliente.getListaVeiculos()) {
								System.out.println(v.getPlaca());
							}
							
						} else {
							System.out.println("Não há veículos cadastrados nesse cliente");
						}
						System.out.println("Sua escolha:");
						placa = scan.nextLine();
						if(cliente.removeVeiculo(placa, seguradora)) { //tenta remover o veículo pela placa e retorna true ou false
							System.out.println("Veículo removido com sucesso");
						} else {
							System.out.println("O cliente não possui esse veículo, voltando ao menu excluir...");
							break;
						}
						break menu_excluir;
					
					case EXCLUIR_SINISTRO:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu excluir...");
							break;
						}
						System.out.println("Escolha o sinistro a ser removido pelo ID.");
						if((seguradora.getListaSinistros()!= null) && (!seguradora.getListaSinistros().isEmpty())){
							System.out.println("Opções:");
							for(Sinistro s: seguradora.getListaSinistros()) {
								System.out.println(s.getId());
							}
							
						} else {
							System.out.println("Não há sinistros");
						}
						System.out.println("Sua escolha:");
						id = scan.nextInt();
						scan.nextLine();
						if(seguradora.removerSinistro(id)) { //tenta remover o sinistro pelo id e retorna true ou false
							System.out.println("Sinistro removido com sucesso");
						} else {
							System.out.println("A seguradora não possui esse sinistro, voltando ao menu excluir...");
						}
						break menu_excluir;
					default:
						break;
					}
				} else {
					System.out.println("Escolha uma opção válida");
	
				} 
			}

	}
	
	/*
	 * Função que automzatiza a escolha de uma seguradora, utilizada em muitas outras funções
	 */
	public static Seguradora escolherSeguradora(Scanner scan) {
		String escolha;
		System.out.println("Escolha uma seguradora pelo nome correspondente.");
		if((Seguradora.getListaSeguradoras()!= null) && (!Seguradora.getListaSeguradoras().isEmpty())){
			System.out.println("Opções:");
			for(Seguradora s: Seguradora.getListaSeguradoras()) {
				System.out.println(s.getNome());
			}
			
		} else {
			System.out.println("Não há seguradoras cadastradas");
		}
		System.out.println("Sua escolha:");
		escolha = scan.nextLine();
		return Seguradora.buscarSeguradora(escolha); //busca a seguradora na lista de seguradoras

	}
	/*
	 * Função que automzatiza a escolha de um cliente, utilizada em muitas outras funções
	 */
	public static Cliente escolherCliente(Seguradora seguradora, Scanner scan) {
		String escolha;
		System.out.println("Escolha um cliente pelo CPF ou CNPJ correspondente.");
		if((seguradora.getListaClientes()!= null) && (!seguradora.getListaClientes().isEmpty())){
			System.out.println("Opções:");
			for(Cliente c: seguradora.getListaClientes()) {
				System.out.println(c.getDocumento());
			}
			
		} else {
			System.out.println("Não há clientes cadastrados nessa seguradora");
		}
		System.out.println("Sua escolha:");
		escolha = scan.nextLine();
		return seguradora.buscarCliente(escolha); //busca o cliente na lista de clientes

	}
	
	public static Veiculo escolherVeiculo(Cliente cliente, Scanner scan) {
		String escolha;
		System.out.println("Escolha um veículo pela placa correspondente:");
		if((cliente.getListaVeiculos()!= null) && (!cliente.getListaVeiculos().isEmpty())){
			System.out.println("Opções:");
			for(Veiculo v: cliente.getListaVeiculos()) {
				System.out.println(v.getPlaca());
			}
			
		} else {
			System.out.println("Não há veículos cadastrados nesse cliente");
		}
		System.out.println("Sua escolha:");
		escolha = scan.nextLine();
		return cliente.buscarVeiculo(escolha);
	}
	
	
	/*
	 * Função que instancia um cliente para ser cadastrado na seguradora
	 */
	public static Cliente criarCliente(Scanner scan, Seguradora seguradora) {
		String nome, documento,endereco, dataLicenca, educacao, genero,
		classeEconomica,dataNascimento,escolha, dataFundacao, cnpj;
		int qtdeFuncionarios;

		System.out.println("Escolha por cliente PF ou PJ(PF/PJ)"); //Escolha PF ou PJ
		escolha = scan.nextLine();
		if(escolha.equals("PF")) {
			System.out.println("Digite o nome do cliente:");
			nome = scan.nextLine();
			if(!Validacao.validaNome(nome)) { //Se o nome não possuir somente letras
				System.out.println("Insira um nome válido, apenas com letras");
				return null;
			}
			System.out.println("Digite o endereço do cliente:");
			endereco = scan.nextLine();
			System.out.println("Digite a data de licença do cliente na forma yyyy-mm-dd:");
			dataLicenca = scan.nextLine();
			if(!Validacao.validaData(dataLicenca)) { //Se não for uma data válida
				System.out.println("Insira uma data válida no formato indicado. Voltando ao menu cadastrar");
				return null;
			}
			System.out.println("Digite o nível de educação do cliente:");
			educacao = scan.nextLine();
			System.out.println("Digite o gênero do cliente:");
			genero = scan.nextLine();
			System.out.println("Digite a classe econômica do cliente:");
			classeEconomica = scan.nextLine();
			System.out.println("Digite o CPF do cliente do cliente:");
			documento = scan.nextLine();
			if(!Validacao.validarCPF(documento)) { //Se não for um CPF válido
				System.out.println("CPF inválido, voltando ao menu cadastrar...");
				return null;
			}
			if(seguradora.buscarCliente(documento)!= null) { //Se for o mesmo CPF de um cliente da seguradora
				System.out.println("Cliente já cadastrado anteriormente, voltando ao menu cadastrar...");
				return null;
			}
			System.out.println("Digite a data de nascimento do cliente na forma yyyy-mm-dd:");
			dataNascimento = scan.nextLine();
			if(!Validacao.validaData(dataNascimento)) { //verifica se a data de nascimento é válida
				System.out.println("Insira uma data válida no formato indicado. Voltando ao menu cadastrar");
				return null;
			}
			if(!Validacao.validaNascimento(dataNascimento)) { //verifica se a data de nascimento é válida
				System.out.println("O cliente deve possuir entre 18 e 90 anos");
				return null;
			}
			ClientePF clientePF = new ClientePF(nome, endereco, dataLicenca, educacao, genero, classeEconomica, documento, dataNascimento);
			return clientePF;
		
		} else if(escolha.equals("PJ")) {
			System.out.println("Digite o nome do cliente:");
			nome = scan.nextLine();
			if(!Validacao.validaNome(nome)) { //Se o nome não possuir somente letras
				System.out.println("Insira um nome válido, apenas com letras");
				return null;
			}
			System.out.println("Digite o endereço do cliente:");
			endereco = scan.nextLine();
			System.out.println("Digite o CNPJ do cliente:");
			cnpj = scan.nextLine();
			
			if(!Validacao.validarCNPJ(cnpj)) {
				System.out.println("CNPJ inválido, voltando ao menu cadastrar...");
				return null;
			}
			if(seguradora.buscarCliente(cnpj)!= null) { //Se for o mesmo CPF de um cliente da seguradora
				System.out.println("Cliente já cadastrado anteriormente, voltando ao menu cadastrar...");
				return null;
			}
			System.out.println("Digite a data de fundação do cliente:");
			dataFundacao = scan.nextLine(); //Verifica se a data é válida
			if(!Validacao.validaData(dataFundacao)) {
				System.out.println("Insira uma data válida no formato indicado. Voltando ao menu cadastrar");
				return null;
			}
			System.out.println("Digite a quantidade de funcionários do cliente:");
			qtdeFuncionarios = scan.nextInt();
			scan.nextLine();
			
			ClientePJ clientePJ = new ClientePJ(nome, endereco, cnpj,dataFundacao, qtdeFuncionarios);
			return clientePJ;
		}
		System.out.println("Escolha uma opção válida, PF ou PJ. Voltando ao menu cadastrar..."); //Se não escolher PF e nem PJ
		return null;
		
		}
	/*
	 * Função que instancia um veículo para ser cadastrado no cliente
	 */
	public static Veiculo criarVeiculo(Scanner scan, Cliente cliente) {
		String placa, marca, modelo;
		int anoFabricacao;
		System.out.println("Digite a placa do veículo:");
		placa = scan.nextLine();
		if(cliente.buscarVeiculo(placa)!= null) { //Se for a mesma placa de um veículo do cliente
			System.out.println("Veículo já cadastrado anteriormente, voltando ao menu cadastrar...");
			return null;
		}
		System.out.println("Digite a marca do veículo:");
		marca = scan.nextLine();
		System.out.println("Digite o modelo do veículo:");
		modelo = scan.nextLine();
		System.out.println("Digite o ano de fabricação do veículo:");
		anoFabricacao = scan.nextInt();
		scan.nextLine();
		
		Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao); //Instancia o veículo
		return veiculo;
	}
	/*
	 * Função que instancia uma nova seguradora
	 */
	public static boolean criarSeguradora(Scanner scan) {
		String nome, telefone, email, endereco;
		System.out.println("Digite o nome da seguradora:");
		nome = scan.nextLine();
		if(Seguradora.buscarSeguradora(nome)!=null) { //Se for o mesmo nome de uma seguradora na lista
			return false;
		}
		System.out.println("Digite o telefone da seguradora:");
		telefone = scan.nextLine();
		System.out.println("Digite o email da seguradora:");
		email = scan.nextLine();
		System.out.println("Digite o endereço da seguradora:");
		endereco = scan.nextLine();
		new Seguradora(nome, telefone, email, endereco); //no próprio construtor já é adicionada para a lista de seguradoras
		return true;
	}

}