package com.amodio.lab6;

import java.util.ArrayList;

public interface I_Arquivo {
	ArrayList<Object> lerArquivo(String path);
	boolean gravarDados(String path);
	
}
