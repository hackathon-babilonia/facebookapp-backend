package com.republicababilonia.homin.controller;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.republicababilonia.homin.service.LocalService;
import com.republicababilonia.homin.service.VagaService;
import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.UsuarioTO;

@Controller
@RequestMapping("/local")
public class LocalController {

	@Autowired
	private LocalService localService;
	
	@Autowired
	private VagaService vagaService;

	@RequestMapping("/createlocal")
	public @ResponseBody String createLocal(String nome, String sexo, String endereco, Integer numero,String complemento, String bairro, String cidade, String estado, Long tipo, Double latitude, Double longitude, String callback, HttpServletRequest request) {
		
		UsuarioTO usuario = (UsuarioTO)request.getSession().getAttribute("USUARIO");
		LocalTO local = new LocalTO(tipo);
		local.setUsuario(usuario);
		local.setNome(nome);
		local.setEndereco(endereco);
		local.setNumero(numero);
		local.setComplemento(complemento);
		local.setBairro(bairro);
		local.setSexo(sexo);
		local.setTipo(tipo);
		local.setCidade(cidade);
		local.setEstado(estado);
		local.setLatitude(latitude);
		local.setLongitude(longitude);
		local.setUniversidade(usuario.getUniversidade());
		local.setDistanceFromUniversity();
		localService.save(local);
		
		JsonObject obj = new JsonObject();
		obj.addProperty("result", "SUCCESS");
		return callback+"("+obj.toString()+")";
	}
	
	@RequestMapping("/searchVagas")
	public @ResponseBody String searchVagas(Long vagatipo, String genero, Double precode, Double precoate, Long veiculo, Double tempo, String callback, HttpServletRequest request) {
		Gson js = new Gson();
		ObjectMapper obj = new ObjectMapper();
		String response = new String();
		try {
			response = obj.writeValueAsString(localService.getLocaisByFilters(vagatipo, genero, precode, precoate, veiculo, tempo, "UNICAMP"));
		} catch (Exception e) {
 			e.printStackTrace();
		}
		return callback+"("+response+")";
	}
	
	
}
