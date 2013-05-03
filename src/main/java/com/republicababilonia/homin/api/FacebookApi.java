package com.republicababilonia.homin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.republicababilonia.homin.to.UsuarioTO;

public class FacebookApi {
	
	private static String FQL = "https://graph.facebook.com/fql?q=";
	private static String SELECT_NOME = "select%20first_name,last_name,pic_with_logo,uid%20from%20user%20where%20uid=me()";
	
	
	
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

}
