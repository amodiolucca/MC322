package com.amodio.lab6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoClientePJ {
	Seguradora seguradora;
	
	public ArquivoClientePJ(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public ArrayList<Object> lerArquivo(String path) {
		String linha = "";
		String separador = ",";
		ArrayList<Object> lista = new ArrayList<>();
		Frota frota;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			in.readLine();
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				if(!Validacao.validarCNPJ(dados[0])) {
					continue;
				}
				ClientePJ cliente = new ClientePJ(dados[1], dados[2], dados[3], dados[4], dados[0], dados[5]);
				frota = seguradora.buscarFrotaRecemCadastrada(dados[6]);
				if(frota!=null) {
					cliente.cadastraFrota(frota);
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
