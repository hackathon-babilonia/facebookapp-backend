package com.republicababilonia.homin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.republicababilonia.homin.to.UsuarioTO;

public class FacebookApi {
	
	
	
	public UsuarioTO getUsuario(String uid, String accessToken) {
		String nome;
		String sobrenome;
		
		HttpClient client = new DefaultHttpClient();
		StringBuffer sb = new StringBuffer();
	    try {
	    	HttpPost post = new HttpPost("http://vogellac2dm.appspot.com/register");
	      List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
	      nameValuePairs.add(new BasicNameValuePair("registrationid", "123456789"));
	      post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	 
	      HttpResponse response = client.execute(post);
	      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
	      String line = "";
	      while ((line = rd.readLine()) != null) {
	        sb.append(line);
	      }
	      
	      
	      JsonObject obj = new JsonParser().parse(sb.toString()).getAsJsonObject();
	      
	      JsonObject data = obj.getAsJsonArray("data").get(0).getAsJsonObject();
	      
	      nome = data.get("first_name").getAsString();
	      sobrenome = data.get("last_name").getAsString();
	      
	      UsuarioTO usuario = new UsuarioTO();
	      
	      usuario.setNome(nome);
	      usuario.setSobrenome(sobrenome);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    
	    
	    return null;
	    
	    
	    
	}

}
