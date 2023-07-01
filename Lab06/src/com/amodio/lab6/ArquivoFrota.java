package com.amodio.lab6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoFrota implements I_Arquivo {
	Seguradora seguradora;
	
	public ArquivoFrota(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public ArrayList<Object> lerArquivo(String path) {
		String linha = "";
		String separador = ",";
		Veiculo veiculo;
		Object veiculoO;
		ArrayList<Object> lista = new ArrayList<>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			in.readLine();
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				Frota frota = new Frota(dados[0]);
				for(int i=0;i<3;i++) {
					veiculoO = seguradora.buscarVeiculoRecemCadastrado(dados[i+1]);
					veiculo = (Veiculo) veiculoO;
					if(veiculo!=null) {
						frota.addVeiculo(veiculo);
					}
				}
				
				lista.add(frota);
			}
			in.close();
			System.out.println("Arquivo de frota lido com sucesso");
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
