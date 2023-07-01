package com.amodio.lab6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoClientePJ implements I_Arquivo {
	Seguradora seguradora;
	
	public ArquivoClientePJ(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public ArrayList<Object> lerArquivo(String path) {
		String linha = "";
		String separador = ",";
		ArrayList<Object> lista = new ArrayList<>();
		Frota frota;
		Object frotaO;
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			in.readLine();
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				if(!Validacao.validarCNPJ(dados[0])) { //Verifica o CNPJ
					System.out.println("CNPJ inválido detectado durante a leitura do arquivo de clientes. Cliente inválido: " + dados[1]);
					continue;
				}
				ClientePJ cliente = new ClientePJ(dados[1], dados[2], dados[3], dados[4], dados[0], dados[5]);
				frotaO = seguradora.buscarFrotaRecemCadastrada(dados[6]);
				frota = (Frota) frotaO;
				if(frota!=null) {
					cliente.cadastraFrota(frota);
				}
				lista.add(cliente);
			}
			in.close();
			System.out.println("Arquivo de clientes PJ lido com sucesso");
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
