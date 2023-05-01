package com.amodio.lab4; //pacote com.amodio.lab4

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Auxiliar {
	
	/**
	 * Método que converte uma String de data para o tipo Date
	 * @param data
	 * @return Date com a data de interesse formatada
	 */
	public static Date parseDate(String data) { 
		try {
			Date data_modificada= new SimpleDateFormat("yyyy-MM-dd").parse(data);
			return data_modificada;
		} catch(ParseException e){
			return null;
		}
	}
}