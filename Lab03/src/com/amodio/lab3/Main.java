package com.amodio.lab3; //Pacote com.amodio.lab3
 

import java.util.*;

public class Main { //Início da classe main
	
	public static void main(String[] args) { //Início do método main
		
		
		//Testando os clientes
		
		System.out.println("####### Teste dos clientes #######"); //Separador para o teste dos clientes
		
		Cliente samsung = new ClientePJ("Samsung", "Avenida do Estado 221", "2016-05-01","Fundamental Completo", "Feminino", "Classe A", "38.320.036/0001-25", "1975-08-06");
		System.out.println(samsung);
		Veiculo focus = new Veiculo("5632", "Ford", "Focus");
		
		samsung.cadastraVeiculo(focus);
		System.out.println(samsung.getListaVeiculos());
		Seguradora seguradora = new Seguradora ("Porto Seguro", "32569878", "portoseguro@gmail.com","Avenida Paulista 100");
		System.out.println(seguradora);
		seguradora.cadastrarCliente(samsung);
		System.out.println(seguradora.getListaClientes());
		LinkedList<Cliente> lista = seguradora.listarClientes("ClientePJ");
		System.out.println(lista);
		
		/*
		 Scanner scan = new Scanner(System.in);
         System.out.println("Digite um veículo: ");
         String veiculo = scan.next();
         System.out.println("O veiculo digitado foi " + veiculo);
         
         System.out.println("Digite uma idade: ");
         int idade = scan.nextInt();
         scan.close();
         System.out.println("A idade digitada foi " + idade);
	*/
	} //Fim do método main
} //Fim da classe main
