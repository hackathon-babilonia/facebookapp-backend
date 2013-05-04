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
import com.republicababilonia.homin.to.VagaTO;

@Controller
@RequestMapping("/local")
public class LocalController {

	@Autowired
	private LocalService localService;
	
	@Autowired
	private VagaService vagaService;

	@RequestMapping("/createlocal")
	public @ResponseBody String createLocal(String nome, String sexo, String endereco, Integer numero,String complemento, String bairro, String cidade, String estado, Long tipo, Double latitude, Double longitude, String callback,String descricao, Double preco, HttpServletRequest request) {
		
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
		
		VagaTO vaga = new VagaTO();
		
		vaga.setDescricao(descricao);
		vaga.setPreco(preco);
		
		LocalTO local2 = localService.findLocalById(local.getId());
		vaga.setLocal(local2);
		
		vagaService.save(vaga);
		
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
	
	@RequestMapping("/infowindow")
	public @ResponseBody String infoWindow(Integer localId, String callback) {
		
		LocalTO local = localService.findLocalById(localId);
		
		StringBuffer sb = new StringBuffer();
		String enderecoFormatado = null;
		String sexoTipoDistanciaUniversidade = null;
		
		enderecoFormatado = local.getEndereco() + ", " + local.getNumero() + ", " + local.getBairro() + ", " + local.getCidade() + " - " +local.getEstado();
		
		if(local.getSexo().equalsIgnoreCase("m")) {
			sexoTipoDistanciaUniversidade = "Male ";
		} else if(local.getSexo().equalsIgnoreCase("f")) {
			sexoTipoDistanciaUniversidade = "Female ";
		} else {
			sexoTipoDistanciaUniversidade = "Unisex ";
		}
		
		if(local.getTipo() == 0) {
			sexoTipoDistanciaUniversidade += "Fraternity";
		} else if(local.getTipo() == 1) {
			sexoTipoDistanciaUniversidade += "Flat";
		} else {
			sexoTipoDistanciaUniversidade += "Boarding House";
		}
		
		sexoTipoDistanciaUniversidade += " - ";
		sexoTipoDistanciaUniversidade += local.getDistance().intValue();
		sexoTipoDistanciaUniversidade += " to "+local.getUniversidade();
		
		sb.append("<div class=\"infowindow\">");
		sb.append("<div class=\"titulo\">");
		sb.append("nomeDaVaga");
		sb.append("</div>");
		sb.append("<div class=\"leftColumn\">");
		sb.append("<img src=\""+"url"+"\" />");
		sb.append("</div>");
		sb.append("<div class=\"rightColumn\">");
		sb.append("<span>"+enderecoFormatado +"</span><br/><br/>");
		sb.append("<span>"+sexoTipoDistanciaUniversidade+"</span>");
		sb.append("</div>");
		sb.append("<div class=\"vagaOdd\">");
		sb.append("<div>");
		sb.append("<span class=\"infoLabel\">Preço: </span><span>R$"+local.getVagas().get(0).getPreco()+"</span>");
		sb.append("</div>");
		sb.append("<div>");
		sb.append("<span class=\"infoLabel\">Descrição: </span><span>"+local.getVagas().get(0).getDescricao()+"</span>");
		sb.append("</div>");
		sb.append("</div>");
		sb.append("</div>");
		
		JsonObject obj = new JsonObject();
		obj.addProperty("content", sb.toString());
		return callback+"("+obj.toString()+")";
		
	}
	
}
