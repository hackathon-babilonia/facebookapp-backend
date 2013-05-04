package com.republicababilonia.homin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.republicababilonia.homin.service.LocalService;
import com.republicababilonia.homin.service.VagaService;
import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.VagaTO;


@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private LocalService localService;
	
	@Autowired
	private VagaService vagaService;
	
	@RequestMapping("/searchVagas")
	public @ResponseBody String searchVagas(String vagatipo, String genero, Double precode, Double precoate, String veiculo, Double distancia) {
		
		localService.getLocaisByFilters(vagatipo, genero, precode, precoate, veiculo, distancia);
		return null;
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

}