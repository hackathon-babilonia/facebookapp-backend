package com.republicababilonia.homin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.republicababilonia.homin.service.LocalService;
import com.republicababilonia.homin.service.VagaService;
import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.RecomendacaoTO;
import com.republicababilonia.homin.to.UsuarioTO;
import com.republicababilonia.homin.to.VagaTO;

@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private VagaService vagaService;
	
	@Autowired
	private LocalService localService;
	
	@RequestMapping("/searchVagas")
	public @ResponseBody String searchVagas(String vagatipo, String genero, Double precode, Double precoate, Long veiculo, Double tempo) {
		Gson js = new Gson();
		String response;
		response = js.toJson(vagaService.getLocaisByFilters(vagatipo, genero, precode, precoate, veiculo, tempo, null));
		return response;
	}

	@RequestMapping("/createVaga")
	public @ResponseBody String createVaga(String descricao, Double preco, Integer localId) {
		VagaTO vaga = new VagaTO();
		
		vaga.setDescricao(descricao);
		vaga.setPreco(preco);
		
		LocalTO local = localService.findLocalById(localId);
		vaga.setLocal(local);
		
		return "SUCCESS";
		
	}
	
	@RequestMapping("/recomendar")
	public @ResponseBody String recomendar(Long idRequest, String to, Integer idVaga, HttpServletRequest request) {
		
		UsuarioTO usuario = (UsuarioTO)request.getSession().getAttribute("USUARIO");
		List <String> toIds = new ArrayList<String>();
		if(to != null && !to.isEmpty()) {
			String[] tos = to.split(",");
			
			for(int i = 0; i < tos.length; i++) {
				toIds.add(tos[i]);
			}
			
		}
		
		for(String toId : toIds) {
			RecomendacaoTO recomendacao = new RecomendacaoTO();
			recomendacao.setRecomendador(usuario);
			recomendacao.setRequestId(idRequest.toString());
			recomendacao.setRecomendadoUId(new Long(toId));
			recomendacao.setVaga(vagaService.findVagaById(idVaga));
			vagaService.saveRecomendacao(recomendacao);
		}
		
		
		return "SUCCESS";
	}
	
	@RequestMapping("/getrecomendacao")
	public @ResponseBody String getRecomendacao(String reqId, HttpServletRequest request) {
		UsuarioTO usuario = (UsuarioTO)request.getSession().getAttribute("USUARIO");
		RecomendacaoTO recomendacao = vagaService.getRecomendacao(reqId, usuario.getUid());
		
		return "SUCCESS";
		
	}
	
	@RequestMapping("/teste")
	public @ResponseBody String teste() {
		@SuppressWarnings("unused")
		LocalTO local = localService.findLocalById(2);
		
		
		return "SUCCESS";
		
	}
			

}
