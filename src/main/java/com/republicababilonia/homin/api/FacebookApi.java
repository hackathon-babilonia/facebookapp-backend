package com.republicababilonia.homin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.republicababilonia.homin.to.PlaceTO;
import com.republicababilonia.homin.to.UsuarioTO;
import com.republicababilonia.homin.utils.Constantes;

public class FacebookApi {

	private static String GENERIC_ACCESS_TOKEN = "BAACEdEose0cBAIUGjDsCYDfX2LhRW7Dl5t5JYZCerB8kNtwFZAjdcANPCGcowa7DXwlHRij10ZCr49hwYhYCwK6ZC8SGMJSbC3p5sAxeViPVW3z08RhLjRwuFtCY5CUhXk8mlQWpHl3kCjoQCxETBnefl99xTUZCzQEfZCxjQkQdFmUkx5tugHw6zmqRTbTXFvAWODZCc4gI0ASmBZB2b7l7BvIicqTl0QIlVnFcon688QZDZD";

	private static String FQL = "https://graph.facebook.com/fql?q=";
	private static String SELECT_NOME = "select%20first_name,last_name,pic_with_logo,uid%20from%20user%20where%20uid=me()";
	private static String SELECT_PLACES = "select name, description, page_id, latitude, longitude, pic, pic_small from place where distance(latitude, longitude, \"-22.816694\", \"-47.068348\") < 5000";

	public static UsuarioTO getUsuario(String accessToken) {

		HttpClient client = new DefaultHttpClient();
		StringBuffer sb = new StringBuffer();
		try {
			HttpGet get = new HttpGet(FQL+SELECT_NOME+"&access_token="+accessToken);
			HttpResponse response = client.execute(get);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}

			JsonObject obj = new JsonParser().parse(sb.toString()).getAsJsonObject();

			JsonObject data = obj.getAsJsonArray("data").get(0).getAsJsonObject();

			String nome = data.get("first_name").getAsString();
			String sobrenome = data.get("last_name").getAsString();
			Long uid = data.get("uid").getAsLong();
			String pic = data.get("pic_with_logo").getAsString();

			UsuarioTO usuario = new UsuarioTO();

			usuario.setNome(nome);
			usuario.setSobrenome(sobrenome);
			usuario.setUid(uid);
			usuario.setAccessToken(accessToken);
			usuario.setUrlFoto(pic);
			return usuario;

		} catch (Exception e) {
			e.printStackTrace();
		}



		return null;

	}

	/*
	 * Places
	 */

	public static List<PlaceTO> getPlaces(Integer universidade, String accessToken) {
		HttpClient client = new DefaultHttpClient();
		StringBuffer sb = new StringBuffer();
		
		List<PlaceTO> places = new ArrayList<PlaceTO>();
		
		try {
			String latitudeParam	= Constantes.UNIVERSIDADE_COORDS.get(Constantes.UNICAMP).get(Constantes.LATITUDE).toString();
			String longitudeParam	= Constantes.UNIVERSIDADE_COORDS.get(Constantes.UNICAMP).get(Constantes.LONGITUDE).toString();

			String safeUrl = URLEncoder.encode(SELECT_PLACES.replace(":latitude", latitudeParam).replace(":longitude", longitudeParam), "UTF-8");
			HttpGet get = new HttpGet(FQL + safeUrl + "&access_token=" + accessToken);
			HttpResponse response = client.execute(get);
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}

			JsonObject result = new JsonParser().parse(sb.toString()).getAsJsonObject();
			JsonArray data = result.getAsJsonArray("data");

			if (data != null && data.size() > 0) {
				for (int i = 0; i < data.size(); i++) {
					JsonObject obj = data.get(i).getAsJsonObject();

					PlaceTO place = new PlaceTO();
					place.setNome(obj.get("name").getAsString());
					place.setDescricao(obj.get("description").getAsString());
					place.setPageID(obj.get("page_id").getAsInt());
					place.setUniversidade(universidade);
					place.setLatitude(obj.get("latitude").getAsDouble());
					place.setLongitude(obj.get("longitude").getAsDouble());
					place.setPic(obj.get("pic").getAsString());
					place.setPicSmall(obj.get("pic_small").getAsString());
					place.setTipo(Constantes.TIPO_INDEFINIDO);

					places.add(place);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return places;
	}

}
