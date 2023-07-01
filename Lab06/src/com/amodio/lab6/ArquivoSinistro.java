package com.amodio.lab6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class ArquivoSinistro implements I_Arquivo {
	
Seguradora seguradora;
	
	public ArquivoSinistro(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public boolean gravarDados(String path) {
		 try {
	            FileWriter fileWriter = new FileWriter(path);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            // Header
	            String header = "ID;Data;Endereço;Condutor;Seguro";
	            bufferedWriter.write(header);
	            bufferedWriter.newLine(); //Próxima linha

	            // Write data to the CSV file
	            for(Seguro s: seguradora.getListaSeguros()) {
	            	for(Sinistro sin:s.getListaSinistros()) {
	            		String[] dados = {String.valueOf(sin.getId()), Validacao.parseDateToString(sin.getData()),sin.getEndereco(), sin.getCondutor().getCpf(), String.valueOf(s.getId())};
		                String dataLine = String.join(";", dados);
		                bufferedWriter.write(dataLine);
		                bufferedWriter.newLine();
	            	}
	                
	            }

	            bufferedWriter.flush();
	            bufferedWriter.close();

	            System.out.println("Arquivo de sinistros criado com sucesso!");
	            return true;

	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("ERRO: Não foi possível criar arquivo de sinistros!");
	            return false;
	        }
	}
	
	public ArrayList<Object> lerArquivo(String path){ //Apenas para poder implementar na interface, conforme orientado na monitoria
		return null;
	}
}
