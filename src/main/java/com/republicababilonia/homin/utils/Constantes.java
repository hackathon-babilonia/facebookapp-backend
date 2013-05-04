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
	
	// Popula Listas e Hashes
	static {
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
		
	}
}
