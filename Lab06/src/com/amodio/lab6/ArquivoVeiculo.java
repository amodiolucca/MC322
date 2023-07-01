package com.amodio.lab6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoVeiculo {
	Seguradora seguradora;
	
	public ArquivoVeiculo(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public ArrayList<Object> lerArquivo(String path) {
		String linha = "";
		String separador = ",";
		ArrayList<Object> lista = new ArrayList<>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			in.readLine();
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				Veiculo veiculo = new Veiculo(dados[0], dados[1], dados[2], Integer.valueOf(dados[3]));
				
				lista.add(veiculo);
			}
			in.close();
			System.out.println("Arquivo de veículo lido com sucesso");
			return lista;
		} catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
