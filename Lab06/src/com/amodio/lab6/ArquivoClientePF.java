package com.amodio.lab6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoClientePF {
	Seguradora seguradora;
	
	public ArquivoClientePF(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public ArrayList<Object> lerArquivo(String path) {
		String linha = "";
		String separador = ",";
		ArrayList<Object> lista = new ArrayList<>();
		Veiculo veiculo;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			in.readLine();
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				ClientePF cliente = new ClientePF(dados[1], dados[2], dados[3], dados[4], dados[6], dados[5], dados[0], dados[7]);
				veiculo = seguradora.buscarVeiculoRecemCadastrado(dados[8]);
				if(veiculo!=null) {
					cliente.cadastraVeiculo(veiculo, seguradora);
				}
				lista.add(cliente);
			}
			in.close();
			return lista;
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
