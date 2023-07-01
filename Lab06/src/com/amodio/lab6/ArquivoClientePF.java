package com.amodio.lab6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoClientePF implements I_Arquivo {
	Seguradora seguradora;
	
	public ArquivoClientePF(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public ArrayList<Object> lerArquivo(String path) {
		String linha = "";
		String separador = ","; //Separador CSV
		ArrayList<Object> lista = new ArrayList<>();
		Veiculo veiculo;
		Object veiculoO;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			in.readLine();
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				if(!Validacao.validarCPF(dados[0])) { //Verifica o CPF
					System.out.println("CPF inválido detectado durante a leitura do arquivo de clientes. Cliente inválido: " + dados[1]);
					continue;
				}
				ClientePF cliente = new ClientePF(dados[1], dados[2], dados[3], dados[4], dados[6], dados[5], dados[0], dados[7]);
				veiculoO = seguradora.buscarVeiculoRecemCadastrado(dados[8]); //Busca o veiculo na lista de veiculos recem cadastrados
				veiculo = (Veiculo) veiculoO;
				if(veiculo!=null) {
					cliente.cadastraVeiculo(veiculo, seguradora);
				}
				lista.add(cliente);
			}
			in.close();
			System.out.println("Arquivo de clientes PF lido com sucesso");
			return lista;
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean gravarDados(String path) { //Apenas para poder implementar na interface, conforme orientado na monitoria
		return true;
	}
}
