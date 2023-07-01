package com.amodio.lab6;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class AppMain{
	
	public static void main(String[] args) {
		ClientePJ samsung = null;
		ClientePJ apple= null;
		ClientePJ google= null;
		ClientePF joao= null;
		ClientePF maria= null;
		Condutor felipe = null;
		Condutor jose = null;
		Seguradora seguradora = null;
		Frota frotaSamsung;
		Frota frotaGoogle;
		Scanner scan = new Scanner(System.in);
		LinkedList<Cliente> listaPJ; //vão guardar as listas dos retornos futuros
		LinkedList<Cliente> listaPF;
		ArrayList<Seguro> segurosJoao;
		ArrayList<Seguro> segurosSamsung;
		
		//Instanciação dos objetos
		
		Veiculo focus = new Veiculo("5632", "Ford", "Focus",2010);
		Veiculo civic = new Veiculo ("6974", "Honda", "Civic",2021);
		Veiculo compass = new Veiculo ("9999", "Jeep", "Compass", 2016);
		Veiculo gol = new Veiculo("5555", "Volkswagen", "Gol", 2005);
		Veiculo palio = new Veiculo("2222", "Fiat", "Palio", 2010);
		
		if(Validacao.validarCNPJ("70.370.024/0001-18")) {
			seguradora = new Seguradora ("70.370.024/0001-18", "Porto Seguro", "32569878", "Avenida Paulista 100", "portoseguro@gmail.com");
		}
		
		//Teste dos CPFs e CNPJs
		if(Validacao.validarCNPJ("38.320.036/0001-25")) {
			System.out.println("O CNPJ da Samsung é válido");
			samsung = new ClientePJ("Samsung", "3294-3678", "Avenida do Estado 221","contato@samsung.com", "38.320.036/0001-25", "1975-08-06");
		} else {
			System.out.println("O CNPJ da Samsung é inválido");
		}
		
		if(Validacao.validarCNPJ("22.222.222/2222-22")) {
			System.out.println("O CNPJ da Apple é válido");
			apple = new ClientePJ("Apple","3394-5021", "Avenida Paulista 123","contato@apple.com", "22.222.222/2222-22", "1965-02-03"); //CNPJ inválido, apenas para testar
		} else {
			System.out.println("O CNPJ da Apple é inválido");
		}
		
		if(Validacao.validarCNPJ("15.202.005/0001-74")) {
			System.out.println("O CNPJ da Google é válido");
			google = new ClientePJ ("Google","3274-2020", "Avenida Brasil 222","contato@google.com", "15.202.005/0001-74", "1950-06-11"); 
		} else {
			System.out.println("O CNPJ da Google é inválido");
		}
		if(Validacao.validarCPF("427.638.700-07")) {
			System.out.println("O CPF do João é válido");
			joao = new ClientePF("João","19935906262", "Avenida 9 de Julho 281","joao.almeida@gmail.com", "Médio Completo", "Masculino","427.638.700-07", "2003-04-11");
			
		} else {
			System.out.println("O CPF do João é inválido");
		}
		
		if(Validacao.validarCPF("111.111.111-11")) { //passando a string do CPF, pois o campo CPF do objeto maria é null por ser inválido
			System.out.println("O CPF da Maria é válido");
			maria = new ClientePF ("Maria","11984653322", "Avenida Norte Sul 111","maria.gomes@gmail.com", "Superior completo", "Feminino", "111.111.111-11", "1985-02-13"); //CPF inválido, apenas para testar
		} else {
			System.out.println("O CPF da Maria é inválido");
		}
		
		if(Validacao.validarCPF("838.642.000-67")) {
			System.out.println("O CPF do Felipe é válido");
			felipe = new Condutor ("838.642.000-67", "Felipe", "15987456123", "Avenida Heitor Penteado 555", "felipe.oliveira@gmail.com", "2002-02-02");
			
		} else {
			System.out.println("O CPF de Felipe é inválido");
		}
		
		if(Validacao.validarCPF("024.452.460-24")) {
			System.out.println("O CPF de José é válido");
			jose = new Condutor("024.452.460-24", "José", "85952316565", "Avenida Paulista 116", "jose.henrique@gmail.com", "2000-09-09");
			
		} else {
			System.out.println("O CPF de José é inválido");
		}
		
		//cadastrando frotas
		System.out.println("Tentando cadastrar uma frota para Samsung:");
		if(samsung.cadastraFrota()) {
			System.out.println("Frota cadastrada com sucesso");
		} else {
			System.out.println("Erro ao cadastrar frota");
		}
		
		System.out.println("Tentando cadastrar uma frota para Google:");
		if(google.cadastraFrota()) {
			System.out.println("Frota cadastrada com sucesso");
		} else {
			System.out.println("Erro ao cadastrar frota");
		}
		
		//referência para as frotas
		frotaSamsung = samsung.getFrota("Samsung0");
		frotaGoogle = google.getFrota("Google1");
		
		if(frotaSamsung == null) {
			System.out.println("Frota não encontrada");
		}
		
		if(frotaGoogle == null) {
			System.out.println("Frota não encontrada");
		}
		
		if(!frotaSamsung.addVeiculo(focus)) {
			System.out.println("Veículo já cadastrado na frota");
		}
		
		if(!frotaSamsung.addVeiculo(gol)) {
			System.out.println("Veículo já cadastrado na frota");
		}
		if(!frotaGoogle.addVeiculo(compass)) {
			System.out.println("Veículo já cadastrado na frota");
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
		System.out.println("Frota Samsung:");
		System.out.println(frotaSamsung);
		System.out.println("Frota Google:");
		System.out.println(frotaGoogle);
		System.out.println("Felipe:");
		System.out.println(felipe);
		System.out.println("José:");
		System.out.println(jose);
		
		//Cadastros de veículos e clientes
		if(!joao.cadastraVeiculo(civic, seguradora)){
			System.out.println("Veículo já cadastrado");
		}
		
		if(!joao.cadastraVeiculo(palio, seguradora)){
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
		samsung.listarVeiculos();
		System.out.println("Veículos de João:");
		joao.listarVeiculos();
		
		//Testando o método de listar Clientes
		System.out.println("Clientes PJ da Seguradora:");
		listaPJ = seguradora.listarClientes("PJ");
		seguradora.imprime_listaCliente(listaPJ);
		
		System.out.println("Clientes PF da Seguradora:");
		listaPF = seguradora.listarClientes("PF");
		seguradora.imprime_listaCliente(listaPF);
		
		System.out.println("Todos os clientes da seguradora:");
		seguradora.imprime_listaCliente(seguradora.getListaClientes());
		
		//Gerando sinistros e seguros
		
		if(!seguradora.gerarSeguroPF("2020-03-03", "2024-02-02", seguradora, civic, joao)) {
			System.out.println("Erro ao gerar seguro");
		}
		
		if(!seguradora.gerarSeguroPF("2019-03-03", "2024-02-02", seguradora, palio, joao)) {
			System.out.println("Erro ao gerar seguro");
		}
		System.out.println("Tentando gerar seguro de João com Focus:");
		if(!seguradora.gerarSeguroPF("2020-07-03", "2024-02-02", seguradora, focus, joao)) { //Focus não é de João, apenas testando se a mensagem de erro funciona
			System.out.println("Erro ao gerar seguro");
		}
		
		if(!seguradora.gerarSeguroPJ("2020-03-03", "2024-02-02", seguradora, frotaSamsung, samsung)) {
			System.out.println("Erro ao gerar seguro");
		}
		
		segurosJoao = seguradora.getSegurosPorCliente("427.638.700-07");
		if (segurosJoao == null || segurosJoao.isEmpty()) {
			System.out.println("Nenhum seguro encontrado");
		}
		
		segurosSamsung = seguradora.getSegurosPorCliente("38.320.036/0001-25");
		if (segurosSamsung == null || segurosSamsung.isEmpty()) {
			System.out.println("Nenhum seguro encontrado");
		}
		
		System.out.println("Seguros de João:");
		seguradora.imprime_listaSeguro(seguradora.getSegurosPorCliente(joao.getDocumento()));
		
		System.out.println("Seguros de Samsung:");
		seguradora.imprime_listaSeguro(seguradora.getSegurosPorCliente(samsung.getDocumento()));
		
		System.out.println("Seguros da seguradora:");
		if(!seguradora.listarSeguros()) {
			System.out.println("A seguradora não possui seguros");
		}
		
		if(!segurosJoao.get(0).autorizarCondutor(felipe)) {
			System.out.println("Condutor não encontrado");
		}
		
		if(!segurosSamsung.get(0).autorizarCondutor(felipe)) {
			System.out.println("Condutor não encontrado");
		}
		
		if(!(segurosJoao.get(0)).gerarSinistro("2022-08-09", "Avenida Paulista 272", felipe)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o condutor está autorizado");
		}
		if(!segurosSamsung.get(0).gerarSinistro("2021-07-24", "Avenida Carlos Grimaldi 210", felipe)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o condutor está autorizado");
		}
		System.out.println("Tentando gerar Sinistro com condutor não autorizado:");
		if(!(segurosJoao.get(1)).gerarSinistro("2021-07-09", "Avenida do Estado 555", jose)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o condutor está autorizado");
		}
		
		if(!segurosJoao.get(1).autorizarCondutor(jose)) {
			System.out.println("Condutor não encontrado");
		}
		
		if(!(segurosJoao.get(1)).gerarSinistro("2021-07-09", "Avenida do Estado 555", jose)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o condutor está autorizado");
		}
		
		//visualização dos sinistros:
		System.out.println("Sinistros de Felipe:");
		if(!felipe.listarSinistros()) {
			System.out.println("Felipe não possui sinistros");
		}
		
		System.out.println("Sinistros de José:");
		if(!jose.listarSinistros()) {
			System.out.println("José não possui sinistros");
		}
		
		System.out.println("Sinistros da seguradora:");
		seguradora.listarSinistros();
		
		
		//Preço dos seguros e receita total da seguradora
		System.out.println("Preço mensal do seguro 1 de João:");
		System.out.println(segurosJoao.get(0).getValorMensal());
		System.out.println("Preço mensal do seguro 2 de João:");
		System.out.println(segurosJoao.get(1).getValorMensal());
		System.out.println("Preço mensal do seguro de Samsumg:");
		System.out.println(segurosSamsung.get(0).getValorMensal());
		System.out.println("Receita anual da seguradora:");
		System.out.println(seguradora.calcularReceita());
		
		//Teste dos métodos de cancelamento/remoção:
		if(seguradora.cancelarSeguro(segurosJoao.get(0))) {
			System.out.println("Seguro removido com sucesso");
		}
		
		if(frotaSamsung.removeVeiculo(focus)) {
			System.out.println("Focus removido com sucesso");
		}
		
		if(segurosJoao.get(0).desautorizarCondutor(felipe)) {
			System.out.println("Felipe desautorizado com sucesso");
		}
		
		if(google.atualizarFrota(frotaGoogle, compass, "remover")) {
			System.out.println("Compass removido com sucesso");
		}
		
		if(google.atualizarFrota(frotaGoogle)) {
			System.out.println("Frota removida com sucesso");
		}
		
		//receita da seguradora após todas as alterações
		System.out.println("Receita anual da seguradora:");
		System.out.println(seguradora.calcularReceita());
		
		//Removendo Google da seguradora
		if(seguradora.removerCliente("15.202.005/0001-74")) {
			System.out.println("Google removido com sucesso");
		}
		System.out.println("Todos os clientes da seguradora após remover Google:");
		seguradora.imprime_listaCliente(seguradora.getListaClientes()); //Google não aparece mais na lista de Clientes
		listaPJ = seguradora.listarClientes("PJ");
		System.out.println("Clientes PJ da seguradora:");
		seguradora.imprime_listaCliente(listaPJ);//Google não aparece mais na lista de Clientes PJ
		
		System.out.println("Leitura de dados:");
		seguradora.lerDados();
		System.out.println("Clientes PF lidos por arquivo:");
		seguradora.imprime_lista_Object(seguradora.getListaClientesPFrecemCadastrados());
		System.out.println("Clientes PJ lidos por arquivo:");
		seguradora.imprime_lista_Object(seguradora.getListaClientesPJrecemCadastrados());
		System.out.println("Condutores lidos por arquivo:");
		seguradora.imprime_lista_Object(seguradora.getListaCondutoresRecemCadastrados());
		System.out.println("Frotas lidas por arquivo:");
		seguradora.imprime_lista_Object(seguradora.getListaFrotasRecemCadastradas());
		System.out.println("Veículos lidos por arquivo:");
		seguradora.imprime_lista_Object(seguradora.getListaVeiculosRecemCadastrados());

		Condutor c = (Condutor) seguradora.getListaCondutoresRecemCadastrados().get(0);
		Condutor c2 = (Condutor) seguradora.getListaCondutoresRecemCadastrados().get(2);
		System.out.println("Gerando seguros e sinistros com alguns dados lidos...");
		if(!segurosJoao.get(1).autorizarCondutor(c)) {
			System.out.println("Condutor não encontrado");
		}
		if(!segurosSamsung.get(0).autorizarCondutor(c2)) {
			System.out.println("Condutor não encontrado");
		}
		if(!segurosJoao.get(1).gerarSinistro("2023-02-25", "Rua Sobral 124", c)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o condutor está autorizado");
		}
		if(!segurosSamsung.get(0).gerarSinistro("2023-02-25", "Rua Sobral 124", c2)) {
			System.out.println("Erro ao gerar o sinistro: Verifique se o condutor está autorizado");
		}
		
		seguradora.gravarDados();
		
		
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
		Seguro seguro;
		SeguroPF seguropf;
		SeguroPJ seguropj;
		Condutor condutor;
		Cliente cliente;
		ClientePF clientepf;
		ClientePJ clientepj;
		//rótulo para o laço, para podermos sair com o break externo
		menu_op:
			while (true) {
				//Impressão das opções 
				System.out.println("ESCOLHA UMA DAS OPÇÕES:");
				for (MenuOperacoes m : MenuOperacoes.values()) {
					System.out.println(m.getValor() + " - " + m);
				}
				//scan na escolha e busca da opção correspondente
				try {
					escolhaOp = scan.nextInt();
				} catch (InputMismatchException e) {
	                System.out.println("Digite um número válido.");
	                scan.nextLine(); //consome o \n que sobra da entrada
	                continue;
	            }
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
						seguro = escolherSeguro(seguradora,scan); //cliente do sinistro
						if (seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu...");
							break;
						}
						condutor = escolherCondutor(seguro, scan);
						if (condutor == null) {
							System.out.println("O seguro não possui esse condutor autorizado. Voltando ao menu...");
							break;
						}
						if (seguro.gerarSinistro(data, endereco, condutor)) {
							System.out.println("Sinistro gerado com sucesso");
						} else {
							System.out.println("Erro ao gerar o sinistro");
						}
						break;
						
					case TRANSFERIR_SEGURO:
						seguradora = escolherSeguradora(scan); //seguradora do sinistro
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada. Voltando ao menu...");
							break;
						}
						seguro = escolherSeguro(seguradora,scan); //cliente do sinistro
						if (seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu...");
							break;
						}
						
						cliente = escolherCliente(seguradora,scan); //cliente escolhido
						if(cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu cadastrar...");
							break;
						}
						if(cliente instanceof ClientePF && seguro instanceof SeguroPF) {
							clientepf = (ClientePF) cliente;
							seguropf = (SeguroPF) seguro;
							if(seguropf.getCliente().equals(clientepf)) {
								System.out.println("O seguro já é desse cliente");
								break;
							}
							seguropf.SetCliente(clientepf);
						}
						else if(cliente instanceof ClientePJ && seguro instanceof SeguroPJ) {
							clientepj = (ClientePJ) cliente;
							seguropj = (SeguroPJ) seguro;
							if(seguropj.getCliente().equals(clientepj)) {
								System.out.println("O seguro já é desse cliente");
								break;
							}
							seguropj.setCliente(clientepj);
						} else {
							System.out.println("Erro ao transferir, o cliente e o seguro devem ser do mesmo tipo (PF ou PJ)");
							break;
						}
						System.out.println("Seguro transferido com sucesso");
						seguro.setValorMensal(seguro.calcularValor()/12);
						break;
					
					case CALCULAR_RECEITA_SEGURADORA:
						seguradora = escolherSeguradora(scan);
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada");
							break;
						}
						System.out.println("A receita da seguradora é: " + seguradora.calcularReceita()); //imprime a receita na tela
						break;
						
					case GRAVAR_DADOS:
						seguradora = escolherSeguradora(scan);
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada");
							break;
						}
						seguradora.gravarDados();
						break;
					case LER_DADOS:
						seguradora = escolherSeguradora(scan);
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada");
							break;
						}
						seguradora.lerDados();
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
		ClientePF clientepf;
		ClientePJ clientepj;
		Frota frota;
		Seguro seguro;
		Condutor condutor;
		
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
						if(cliente instanceof ClientePF) {
							clientepf = (ClientePF)cliente;
							if (clientepf.cadastraVeiculo(veiculo, seguradora)) {
								System.out.println("Veículo cadastrado com sucesso");
							}else {
								System.out.println("Erro ao cadastrar o veículo");
							}
						} else {
							clientepj = (ClientePJ) cliente;
							frota = escolherFrota( clientepj,scan);
							if(clientepj.atualizarFrota(frota, veiculo, "adicionar")){
								System.out.println("Veículo cadastrado com sucesso");
							} else {
								System.out.println("Erro ao cadastrar o veículo");
							}
							
						}
						
						break menu_cadastrar;
					
					case CADASTRAR_CONDUTOR:
						seguradora = escolherSeguradora(scan); //seguradora do condutor
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada. Voltando ao menu...");
							break;
						}
						seguro = escolherSeguro(seguradora,scan); //cliente do sinistro
						if (seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu...");
							break;
						}
						condutor = criarCondutor(scan, seguro);
						if(condutor == null) {
							break;
						}
						
						if(seguro.autorizarCondutor(condutor)) {
							System.out.println("Condutor cadastrado com sucesso");
						} else {
							System.out.println("Erro ao cadastrar o condutor");
						}
						break menu_cadastrar;
						
					case CADASTRAR_SEGURO:
						seguradora = escolherSeguradora(scan); //seguradora do seguro
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada. Voltando ao menu...");
							break;
						}
						if(criarSeguro(scan, seguradora)) {
							System.out.println("Seguro cadastrado com sucesso");
						} else {
							System.out.println("Erro ao cadastrar seguro");
						}
						break menu_cadastrar;
					
					case CADASTRAR_FROTA:
						seguradora = escolherSeguradora(scan); //seguradora da frota
						if (seguradora == null) {
							System.out.println("Seguradora não encontrada. Voltando ao menu...");
							break;
						}
						
						cliente = escolherCliente(seguradora,scan); //cliente escolhido
						if(cliente == null) {
							System.out.println("Cliente não encontrado, voltando ao menu cadastrar...");
							break;
						}
						
						if(cliente instanceof ClientePJ) {
							if(((ClientePJ) cliente).cadastraFrota()){
								System.out.println("Frota cadastrada com suceso");
							} else {
								System.out.println("Erro ao cadastrar frota");
							}
						} else {
							System.out.println("Escolha um ClientePJ para essa operação, erro ao cadastrar");
						}
						break menu_cadastrar;
						
						
					case CADASTRAR_SEGURADORA:
						if(!criarSeguradora(scan)) { //Instanciação de uma seguradora
							break;
						}
						System.out.println("Seguradora cadastrada com sucesso. Voltando ao menu...");
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
		ClientePJ clientepj;
		Seguro seguro;
		Condutor condutor;
		Frota frota;

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
						if(!cliente.listarVeiculos()) { //imprime veículos do cliente
							System.out.println("O cliente não possui veículos");
						}
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
						
					case LISTAR_SEGURO_POR_SEGURADORA:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						if(!seguradora.listarSeguros()) {
							System.out.println("A seguradora não possui seguros"); //se retorna falso, não possui veículos
						}
						break menu_listar;
					
					case LISTAR_SINISTRO_POR_CONDUTOR:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						seguro = escolherSeguro(seguradora, scan);
						if(seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu listar...");
							break;
						}
						
						condutor = escolherCondutor(seguro,scan);
						if(condutor == null) {
							System.out.println("Condutor não encontrado, voltando ao menu listar...");
							break;
						}
						if(!condutor.listarSinistros()) {
							System.out.println("O condutor não possui sinistros");
						}
						break menu_listar;
						
					case LISTAR_FROTA_POR_CLIENTE:
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
						if(cliente instanceof ClientePJ) {
							clientepj = (ClientePJ) cliente;
							if(!clientepj.listarFrota()) {
								System.out.println("O cliente não possui frotas");
							}
						} else {
							System.out.println("Escolha um ClientePJ para essa operação");
						}
						break menu_listar;
						
					case LISTAR_VEICULO_POR_FROTA:
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
						if(cliente instanceof ClientePJ) {
							clientepj = (ClientePJ) cliente;
							frota = escolherFrota(clientepj, scan);
							if(frota == null) {
								System.out.println("Frota não encontrada, voltando ao menu listar...");
							}
							if(!frota.listarVeiculos()) {
								System.out.println("A frota não possui veículos");
							}
						} else {
							System.out.println("Escolha um ClientePJ para essa operação");
						}
						break menu_listar;
					
					case LISTAR_SINISTRO_POR_SEGURO:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						seguro = escolherSeguro(seguradora, scan);
						if(seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu listar...");
							break;
						}
						seguro.listarSinistros();
						break menu_listar;
					
					case LISTAR_CONDUTOR_POR_SEGURO:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						seguro = escolherSeguro(seguradora, scan);
						if(seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu listar...");
							break;
						}
						seguro.listarCondutores();
						break menu_listar;
						
					case LISTAR_SEGURO_POR_CLIENTE:
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
						seguradora.imprime_listaSeguro(seguradora.getSegurosPorCliente(cliente.getDocumento()));
						break menu_listar;
						
					case LISTAR_SINISTROS_POR_CLIENTE:
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
						seguradora.imprime_listaSinistro(seguradora.getSinistrosPorCliente(cliente.getDocumento()));
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
		int escolhaOp, id;
		Cliente cliente;
		Seguradora seguradora;
		Veiculo veiculo;
		ClientePF clientepf;
		ClientePJ clientepj;
		Seguro seguro;
		Condutor condutor;
		Frota frota;

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
						veiculo = escolherVeiculo(cliente, scan);
						if(veiculo == null) {
							System.out.println("Veículo não encontrado, voltando ao menu excluir...");
							break;
						}
						if(cliente instanceof ClientePF) {
							clientepf = (ClientePF) cliente;
							if(clientepf.removeVeiculo(veiculo.getPlaca(), seguradora)) { //tenta remover o veículo pela placa e retorna true ou false
								System.out.println("Veículo removido com sucesso");
							} else {
								System.out.println("O cliente não possui esse veículo, voltando ao menu excluir...");
								break;
							}
						} else {
							clientepj = (ClientePJ) cliente;
							frota = escolherFrota(clientepj,scan);
							if(frota == null) {
								System.out.println("Frota não encontrada");
								break;
							}
							if(!clientepj.atualizarFrota(frota, veiculo, "remover")) {
								System.out.println("Erro ao excluir o veículo, verifique se a frota possui o veículo");
							} else {
								System.out.println("Veículo removido com sucesso");
							}
						}
						
						break menu_excluir;
					
					case EXCLUIR_SINISTRO:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu excluir...");
							break;
						}
						seguro = escolherSeguro(seguradora, scan);
						if(seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu excluir...");
							break;
						}
						System.out.println("Escolha o sinistro a ser removido pelo ID.");
						if((seguro.getListaSinistros()!= null) && (!seguro.getListaSinistros().isEmpty())){
							System.out.println("Opções:");
							for(Sinistro s: seguro.getListaSinistros()) {
								System.out.println(s.getId());
							}
							
						} else {
							System.out.println("Não há sinistros");
						}
						System.out.println("Sua escolha:");
						id = scan.nextInt();
						scan.nextLine();
						if(seguro.removerSinistro(id)) { //tenta remover o sinistro pelo id e retorna true ou false
							System.out.println("Sinistro removido com sucesso");
						} else {
							System.out.println("O seguro não possui esse sinistro, voltando ao menu excluir...");
						}
						break menu_excluir;
					
					case EXCLUIR_CONDUTOR:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu excluir...");
							break;
						}
						seguro = escolherSeguro(seguradora, scan);
						if(seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu excluir...");
							break;
						}
						condutor = escolherCondutor(seguro, scan);
						if(condutor == null) {
							System.out.println("Condutor não encontrado, voltando ao menu excluir...");
							break;
						}
						if(seguro.desautorizarCondutor(condutor)) {
							System.out.println("Condutor removido com sucesso");
						} else {
							System.out.println("O condutor não estava habilitado anteriormente");
						}
						break menu_excluir;
						
					case EXCLUIR_TODAS_FROTAS:
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
						if(cliente instanceof ClientePJ) {
							clientepj = (ClientePJ) cliente;
							if(clientepj.atualizarFrota()) {
								System.out.println("Frotas excluídas com sucesso");
							} else {
								System.out.println("Erro ao excluir frotas");
							}
						} else {
							System.out.println("Escolha um ClientePJ para essa operação, erro ao excluir");
						}
						break menu_excluir;
					
					case EXCLUIR_FROTA:
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
						if(cliente instanceof ClientePJ) {
							clientepj = (ClientePJ) cliente;
							frota = escolherFrota(clientepj,scan);
							if(frota == null) {
								System.out.println("Frota não encontrada");
								break;
							}
							if(clientepj.atualizarFrota(frota)) {
								System.out.println("Frota excluída com sucesso");
							} else {
								System.out.println("Erro ao excluir frota");
							}
						} else {
							System.out.println("Escolha um ClientePJ para essa operação, erro ao excluir");
						}
						break menu_excluir;
						
					case EXCLUIR_SEGURO:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						seguro = escolherSeguro(seguradora, scan);
						if(seguro == null) {
							System.out.println("Seguro não encontrado, voltando ao menu excluir...");
							break;
						}
						if(seguradora.cancelarSeguro(seguro)) {
							System.out.println("Seguro removido com sucesso");
						} else {
							System.out.println("Não foi possível remover o seguro");
						}
						break menu_excluir;
						
					case EXCLUIR_SEGURADORA:
						seguradora = escolherSeguradora(scan);
						if(seguradora == null) {
							System.out.println("Seguradora não encontrada, voltando ao menu listar...");
							break;
						}
						if(Seguradora.removerSeguradora(seguradora)) {
							System.out.println("Seguradora removida com sucesso");
						} else {
							System.out.println("Não foi possível remover a seguradora");
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
		System.out.println("Escolha uma seguradora pelo CNPJ correspondente.");
		if((Seguradora.getListaSeguradoras()!= null) && (!Seguradora.getListaSeguradoras().isEmpty())){
			System.out.println("Opções:");
			for(Seguradora s: Seguradora.getListaSeguradoras()) {
				System.out.println(s.getCnpj());
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
		System.out.println("Escolha um cliente pelo documento correspondente.");
		if((seguradora.getListaClientes()!= null) && (!seguradora.getListaClientes().isEmpty())){
			System.out.println("Clientes da seguradora:");
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
	
	public static Frota escolherFrota(ClientePJ cliente, Scanner scan) {
		String escolha;
		System.out.println("Escolha uma frota pelo Code correspondente:");
		if((cliente.getListaFrota()!= null) && (!cliente.getListaFrota().isEmpty())){
			System.out.println("Opções:");
			for(Frota f: cliente.getListaFrota()) {
				System.out.println(f.getCode());
			}
			
		} else {
			System.out.println("Não há frotas cadastradas nesse cliente");
		}
		System.out.println("Sua escolha:");
		escolha = scan.nextLine();
		return cliente.buscarFrota(escolha);
	}
	
	public static Seguro escolherSeguro(Seguradora seguradora, Scanner scan) {
		int escolha;
		System.out.println("Escolha um seguro pelo ID correspondente:");
		if((seguradora.getListaSeguros()!= null) && (!seguradora.getListaSeguros().isEmpty())){
			System.out.println("Opções:");
			for(Seguro s: seguradora.getListaSeguros()) {
				System.out.println(s.getId());
			}
			
		} else {
			System.out.println("Não há seguros cadastrados nessa seguradora");
		}
		System.out.println("Sua escolha:");
		escolha = scan.nextInt();
		scan.nextLine();
		return seguradora.buscarSeguro(escolha);
	}
	
	public static Condutor escolherCondutor(Seguro seguro, Scanner scan) {
		String escolha;
		System.out.println("Escolha um condutor pelo CPF correspondente.");
		if((seguro.getListaCondutores()!= null) && (!seguro.getListaCondutores().isEmpty())){
			System.out.println("Opções:");
			for(Condutor c: seguro.getListaCondutores()) {
				System.out.println(c.getCpf());
			}
			
		} else {
			System.out.println("Não há condutores autorizados nesse seguro");
		}
		System.out.println("Sua escolha:");
		escolha = scan.nextLine();
		return seguro.buscarCondutor(escolha); //busca o cliente na lista de clientes
	}
	
	
	/*
	 * Função que instancia um cliente para ser cadastrado na seguradora
	 */
	public static Cliente criarCliente(Scanner scan, Seguradora seguradora) {
		String nome, documento,endereco, educacao, genero,
		dataNascimento,escolha, dataFundacao, cnpj, telefone, email;

		System.out.println("Escolha por cliente PF ou PJ(PF/PJ)"); //Escolha PF ou PJ
		escolha = scan.nextLine();
		System.out.println("Digite o nome do cliente:");
		nome = scan.nextLine();
		if(!Validacao.validaNome(nome)) { //Se o nome não possuir somente letras
			System.out.println("Insira um nome válido, apenas com letras. Voltando ao menu cadastrar...");
			return null;
		}
		System.out.println("Digite o telefone do cliente:");
		telefone = scan.nextLine();
		System.out.println("Digite o endereço do cliente:");
		endereco = scan.nextLine();
		System.out.println("Digite o email do cliente:");
		email = scan.nextLine();
		
		if(escolha.equals("PF")) {
			System.out.println("Digite o nível de educação do cliente:");
			educacao = scan.nextLine();
			System.out.println("Digite o gênero do cliente:");
			genero = scan.nextLine();
			System.out.println("Digite o CPF do cliente:");
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
				System.out.println("O cliente deve possuir entre 18 e 90 anos, erro ao cadastrar");
				return null;
			}
			ClientePF clientePF = new ClientePF(nome, telefone, endereco, email, educacao, genero, documento, dataNascimento);
			return clientePF;
		
		} else if(escolha.equals("PJ")) {
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
			
			ClientePJ clientePJ = new ClientePJ(nome, telefone, endereco, email, cnpj,dataFundacao);
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
	
	
	public static Condutor criarCondutor(Scanner scan, Seguro seguro) {
		String cpf, nome, telefone, endereco, email, dataNascimento;
		System.out.println("Digite o CPF do condutor:");
		cpf = scan.nextLine();
		if(!Validacao.validarCPF(cpf)) { //Se não for um CPF válido
			System.out.println("CPF inválido, voltando ao menu cadastrar...");
			return null;
		}
		if(seguro.buscarCondutor(cpf)!= null) { //Se for o mesmo CPF de um cliente da seguradora
			System.out.println("Condutor já cadastrado anteriormente, voltando ao menu cadastrar...");
			return null;
		}
		System.out.println("Digite o nome do condutor");
		nome = scan.nextLine();
		if(!Validacao.validaNome(nome)) { //Se o nome não possuir somente letras
			System.out.println("Insira um nome válido, apenas com letras. Voltando ao menu cadastrar...");
			return null;
		}
		System.out.println("Digite o telefone do condutor:");
		telefone = scan.nextLine();
		
		System.out.println("Digite o endereço do condutor:");
		endereco = scan.nextLine();
		
		System.out.println("Digite o email do condutor:");
		email = scan.nextLine();
		
		System.out.println("Digite a data de nascimento do condutor na forma yyyy-mm-dd:");
		dataNascimento = scan.nextLine();
		if(!Validacao.validaData(dataNascimento)) { //verifica se a data de nascimento é válida
			System.out.println("Insira uma data válida no formato indicado. Voltando ao menu cadastrar");
			return null;
		}
		if(!Validacao.validaNascimento(dataNascimento)) { //verifica se a data de nascimento é válida
			System.out.println("O cliente deve possuir entre 18 e 90 anos, erro ao cadastrar");
			return null;
		}
		
		Condutor condutor = new Condutor(cpf, nome, telefone, endereco, email, dataNascimento);
		return condutor;
		
	}
	
	public static boolean criarSeguro(Scanner scan, Seguradora seguradora) {
		String dataInicio, dataFim, escolha;
		Cliente cliente;
		Veiculo veiculo;
		ClientePF clientepf;
		ClientePJ clientepj;
		Frota frota;
		System.out.println("Digite a data de início do seguro na forma yyyy-mm-dd:");
		dataInicio = scan.nextLine();
		if(!Validacao.validaData(dataInicio)) { //verifica se a data de início é válida
			System.out.println("Insira uma data válida no formato indicado. Voltando ao menu cadastrar");
			return false;
		}
		
		System.out.println("Digite a data de fim do seguro na forma yyyy-mm-dd:");
		dataFim = scan.nextLine();
		if(!Validacao.validaData(dataFim)) { //verifica se a data de nascimento é válida
			System.out.println("Insira uma data válida no formato indicado. Voltando ao menu cadastrar");
			return false;
		}
		
		System.out.println("Escolha por seguro PF ou PJ(PF/PJ)"); //Escolha PF ou PJ
		escolha = scan.nextLine();
		cliente = escolherCliente(seguradora, scan);
		if(cliente == null) {
			System.out.println("Cliente não encontrado, voltando ao menu cadastrar...");
			return false;
		}
		
		if(escolha.equals("PF")) {
			
			if(cliente instanceof ClientePJ) {
				System.out.println("Escolha um clientePF, voltando ao menu cadastrar...");
				return false;
			}
			clientepf = (ClientePF) cliente;
			veiculo = escolherVeiculo(clientepf, scan);
			if(veiculo == null) {
				System.out.println("Veículo não encontrado, voltando ao menu cadastrar...");
				return false;
			}
			if(seguradora.ehSegurado(veiculo)) {
				System.out.println("Veículo já possui um seguro");
				return false;
			}
			return seguradora.gerarSeguroPF(dataInicio, dataFim, seguradora, veiculo, clientepf);
		
		} else if(escolha.equals("PJ")) {
			if(cliente instanceof ClientePF) {
				System.out.println("Escolha um clientePJ, voltando ao menu cadastrar...");
				return false;
			}
			clientepj = (ClientePJ) cliente;
			frota = escolherFrota(clientepj, scan);
			if(frota == null) {
				System.out.println("Frota não encontrada, voltando ao menu cadastrar...");
				return false;
			}
			if(seguradora.ehSegurado(frota)) {
				System.out.println("Frota já possui um seguro");
				return false;
			}
			return seguradora.gerarSeguroPJ(dataInicio, dataFim, seguradora, frota, clientepj);
		}
		System.out.println("Escolha uma opção válida");
		return false;
		
	}
	/*
	 * Função que instancia uma nova seguradora
	 */
	public static boolean criarSeguradora(Scanner scan) {
		String nome, telefone, email, endereco, cnpj;
		System.out.println("Digite o nome da seguradora:");
		nome = scan.nextLine();
		System.out.println("Digite o CNPJ da seguradora:");
		cnpj = scan.nextLine();
		
		if(!Validacao.validarCNPJ(cnpj)) {
			System.out.println("CNPJ inválido, voltando ao menu cadastrar...");
			return false;
		}
		if(Seguradora.buscarSeguradora(cnpj)!=null) { //Se for o mesmo nome de uma seguradora na lista
			System.out.println("Seguradora já cadastrada anteriormente, voltando ao menu cadastrar...");
			return false;
		}
		System.out.println("Digite o telefone da seguradora:");
		telefone = scan.nextLine();
		System.out.println("Digite o email da seguradora:");
		email = scan.nextLine();
		System.out.println("Digite o endereço da seguradora:");
		endereco = scan.nextLine();
		new Seguradora(cnpj, nome, telefone, endereco, email); //no próprio construtor já é adicionada para a lista de seguradoras
		return true;
	}
}