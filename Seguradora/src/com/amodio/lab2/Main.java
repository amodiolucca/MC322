package com.amodio.lab2;

public class Main {
	
	public static void main(String[] args) {
		 
		//criando os clientes
		
		System.out.println("Teste dos clientes");
		
		Cliente joao = new Cliente("João","444.444.444-44","10/08/1993",25,"Avenida Paulista, 456");
		
		if(joao.getNome() == null) {
			System.out.println("CPF inválido");
		} else {
			System.out.println(joao);
		}
		
		Cliente vitinho = new Cliente ("Vítor","204.011.938-88","26/09/2002",19,"Avenida Heitor Penteado, 456");
		
		if(vitinho.getNome() == null) {
			System.out.println("CPF inválido");
		} else {
			System.out.println(vitinho);
		}
		vitinho.setIdade(22); //testando o set
		joao.setCpf("362.899.890-57"); //testando colocar um cpf válido para joão
		System.out.println("CPF de João: "+ joao.getCpf());
		System.out.println("Idade de Vítor: " + vitinho.getIdade()); //ver se muda a idade
		System.out.println(vitinho); //imprimir 
		
		
		Sinistro sinistro = new Sinistro("1", "rua");
		String endereco_joao = joao.getEndereco();
		int id_sinistro = sinistro.getId();
		String cpf_joao = joao.getCpf();
		System.out.println(id_sinistro);
	} //fim do método main
} //fim da classe main
