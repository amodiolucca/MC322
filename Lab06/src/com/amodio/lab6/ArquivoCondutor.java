package com.amodio.lab6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoCondutor implements I_Arquivo {
	Seguradora seguradora;
	
	public ArquivoCondutor(Seguradora seguradora) {
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
				if(!Validacao.validarCPF(dados[0])) { //verifica o cpf
					System.out.println("CPF inválido detectado durante a leitura do arquivo de condutores. Condutor inválido: " + dados[1]);
					continue;
				}
				Condutor condutor = new Condutor(dados[0], dados[1], dados[2], dados[3], dados[4], dados[5]);
				lista.add(condutor);
			}
			in.close();
			System.out.println("Arquivo de condutor lido com sucesso");
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
