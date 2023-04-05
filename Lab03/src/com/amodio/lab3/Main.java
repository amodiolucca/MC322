package com.amodio.lab3; //Pacote com.amodio.lab3
 
public class Main { //Início da classe main
	
	public static void main(String[] args) { //Início do método main
		 
		//Testando os veículos
		
		System.out.println("####### Teste dos veículos #######"); //Separador para o teste dos veículos
		
		//Criação de 2 veículos aleatórios
		Veiculo veiculo_1 = new Veiculo("HTF2T72", "Ford", "Ka");
		Veiculo veiculo_2 = new Veiculo ("GOP9D67", "Honda", "Civic");
		
		//Impressão dos seus atributos por meio do toString
		System.out.println(veiculo_1);
		System.out.println(veiculo_2);
		
		//Alterando alguns atributos por meio dos Setters
		veiculo_1.setMarca("Toyota");
		veiculo_1.setModelo("Corolla");
		veiculo_2.setPlaca("HJW8G90");
		
		//Impressão dos atributos alterados e do toString após as alterações utilizando os Setters
		System.out.println(veiculo_1);
		System.out.println(veiculo_2);
		System.out.println("O modelo do veículo 1 é " + veiculo_1.getModelo());
		System.out.println("A placa do veículo 2 é " + veiculo_2.getPlaca());
		
		//Testando os clientes
		
		System.out.println("####### Teste dos clientes #######"); //Separador para o teste dos clientes
		
		//Criação de 2 clientes aleatórios
		Cliente joao = new Cliente("João","444.444.444-44","10/08/1993",25,"Avenida Paulista 456"); //João tem CPF inválido
		Cliente vitor = new Cliente ("Vítor","204.011.938-88","26/09/2002",19,"Avenida Heitor Penteado 432");
		
		if(joao.getNome() == null) { //Se o CPF for inválido, todas os atributos do objeto ficam como null
			System.out.println("CPF inválido");
		} else {
			System.out.println(joao);
		}
		
		if(vitor.getNome() == null) {
			System.out.println("CPF inválido");
		} else {
			System.out.println(vitor);
		}
		
		//Alterando alguns atributos por meio dos Setters
		vitor.setEndereco("Avenida Norte Sul 100");
		
		//Impressão dos atributos alterados e do toString após as alterações utilizando os Setters
		System.out.println(vitor);
		System.out.println("Endereço de Vítor: " + vitor.getEndereco());
		
		//Testando as seguradoras
		
		System.out.println("####### Teste das seguradoras #######"); //Separador para o teste das seguradoras
		
		//Criação de 2 seguradoras aleatórias
		Seguradora porto_seguro = new Seguradora("Porto Seguro", "((019)3268-9536", "atendimento@portoseguro.com.br", "Avenida Dr. Moraes Sales 741");
		Seguradora bradesco = new Seguradora("Bradesco", "((019)3289-1273", "atendimento@bradesco.com.br", "Rua Oscar Freire 562");
		
		//Impressão dos seus atributos por meio do toString
		System.out.println(porto_seguro);
		System.out.println(bradesco);
		
		//Alterando alguns atributos por meio dos Setters
		porto_seguro.setTelefone("(019)3260-9332");
		bradesco.setEmail("contato@bradesco.com.br");
		
		//Impressão dos atributos alterados e do toString após as alterações utilizando os Setters
		System.out.println(porto_seguro);
		System.out.println(bradesco);
		System.out.println("O telefone da seguradora Porto Seguro é " + porto_seguro.getTelefone());
		System.out.println("O e-mail da seguradora Bradesco é  " + bradesco.getEmail());
		
		//Testando os sinistros
		
		System.out.println("####### Teste dos sinistros #######"); //Separador para o teste dos sinistros
		
		//Criação de 2 sinistros aleatórios
		Sinistro sinistro_1 = new Sinistro("15/12/2022", "Avenida Francisco Glicério 756");
		Sinistro sinistro_2 = new Sinistro("20/01/2023", "Avenida Oscar Niemyer 105");
		
		//Impressão dos seus atributos por meio do toString
		System.out.println(sinistro_1);
		System.out.println(sinistro_2);
		
		//Alterando alguns atributos por meio dos Setters
		sinistro_1.setData("16/12/2022");
		sinistro_2.setEndereco("Avenida 9 de Julho 555");
		
		//Impressão dos atributos alterados e do toString após as alterações utilizando os Setters
		System.out.println(sinistro_1);
		System.out.println(sinistro_2);
		System.out.println("A data do sinistro 1 é " + sinistro_1.getData());
		System.out.println("O endereço do sinistro 2 é " + sinistro_2.getEndereco());
		System.out.println("O ID do sinistro 2 é " + sinistro_2.getId());
		
	} //Fim do método main
} //Fim da classe main
