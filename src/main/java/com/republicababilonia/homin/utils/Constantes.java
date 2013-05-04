package com.republicababilonia.homin.utils;

import java.util.HashMap;

public class Constantes {
	
	// Universidades
	public static final Integer UNICAMP	= 0;
	public static final Integer USP		= 1;
	public static final Integer ITA		= 2;
	
	// Palavras reservadas de Latitude e Longitude
	public static final String LATITUDE = "latitude";
	public static final String LONGITUDE = "longitude";
	
	// Coordenadas das universidades
	public static final HashMap<Integer, HashMap<String, Double>> UNIVERSIDADE_COORDS;
	
	// Tipos de pontos de interesse
	public static final Integer TIPO_INDEFINIDO		= -1;
	public static final Integer AEROPORTO			= 0;
	public static final Integer TERMINAL_RODOVIARIO	= 1;
	public static final Integer	HOSPITAL			= 2;
	public static final Integer RESTAURANTE			= 3;
	public static final Integer SUPERMERCADO		= 4;
	public static final Integer UNIVERSIDADE		= 5;
	
	// Descricao tipos de ponto de interesse
	public static final HashMap<Integer, String> TIPO_DESCRICAO;
	
	// Popula Listas e Hashes
	static {
		// Lista de universidades (latitudes e longitudes)
		HashMap<String, Double> coords;
		
		UNIVERSIDADE_COORDS = new HashMap<Integer, HashMap<String, Double>>();
		
		coords = new HashMap<String, Double>();
		coords.put(LATITUDE, -22.816575);
		coords.put(LONGITUDE, -47.068563);
		UNIVERSIDADE_COORDS.put(UNICAMP, coords);
		
		coords = new HashMap<String, Double>();
		coords.put(LATITUDE, -23.55612);
		coords.put(LONGITUDE, -46.74099);
		UNIVERSIDADE_COORDS.put(USP, coords);
		
		coords = new HashMap<String, Double>();
		coords.put(LATITUDE, -23.207508);
		coords.put(LONGITUDE, -45.876589);
		UNIVERSIDADE_COORDS.put(ITA, coords);
		
		// Descricao dos tipos de pontos de interesse
		TIPO_DESCRICAO = new HashMap<Integer, String>();
		TIPO_DESCRICAO.put(AEROPORTO, "Aeroporto");
		TIPO_DESCRICAO.put(TERMINAL_RODOVIARIO, "Terminal rodoviário");
		TIPO_DESCRICAO.put(HOSPITAL, "Hospital");
		TIPO_DESCRICAO.put(RESTAURANTE, "Restaurante");
		TIPO_DESCRICAO.put(SUPERMERCADO, "Supermercado");
		TIPO_DESCRICAO.put(UNIVERSIDADE, "Universidade");
		
		
	}
}
