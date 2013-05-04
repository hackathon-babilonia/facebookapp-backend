package com.republicababilonia.homin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.republicababilonia.homin.service.LocalService;

@Controller
@RequestMapping("/vagas")
public class VagasController {
	
	@Autowired
	private LocalService localService;
	
	@RequestMapping("/searchVagas")
	public @ResponseBody String searchVagas(String vagatipo, String genero, Double precode, Double precoate, String veiculo, Double distancia) {
		
		localService.getLocaisByFilters(vagatipo, genero, precode, precoate, veiculo, distancia);
		return null;
	}

}
