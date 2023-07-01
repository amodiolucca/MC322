package com.amodio.lab6;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;

public class ArquivoSeguros implements I_Arquivo {
	
Seguradora seguradora;
	
	public ArquivoSeguros(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public boolean gravarDados(String path) {
		 try {
	            FileWriter fileWriter = new FileWriter(path);
	            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	            // Header
	            String header = "ID;Data Início;Data Fim ;Seguradora;Sinistros;Condutores;Valor Mensal";
	            bufferedWriter.write(header);
	            bufferedWriter.newLine(); //Próxima linha

	            // Write data to the CSV file
	            for(Seguro s: seguradora.getListaSeguros()) {
	            	String[] dados = {String.valueOf(s.getId()),Validacao.parseDateToString(s.getDataInicio()), Validacao.parseDateToString(s.getDataFim()),seguradora.getNome(),
	            	s.sinistrosDoSeguro(), s.condutoresDoSeguro(),String.format("%f", s.getValorMensal())};
	                String dataLine = String.join(";", dados);
	                bufferedWriter.write(dataLine);
	                bufferedWriter.newLine();
	                
	            }

	            bufferedWriter.flush();
	            bufferedWriter.close();

	            System.out.println("Arquivo de seguros criado com sucesso!");
	            return true;

	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("ERRO: Não foi possível criar arquivo de seguros!");
	            return false;
	        }
	}
	
	public ArrayList<Object> lerArquivo(String path){ //Apenas para poder implementar na interface, conforme orientado na monitoria
		return null;
	}
}
