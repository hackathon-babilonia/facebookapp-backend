package com.republicababilonia.homin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.republicababilonia.homin.service.LocalService;
import com.republicababilonia.homin.service.VagaService;
import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.VagaTO;

@Controller
@RequestMapping("/local")
public class LocalController {

	@Autowired
	private LocalService localService;
	
	@Autowired
	private VagaService vagaService;

	@RequestMapping("/index")
	public @ResponseBody String listContacts(Map<String, Object> map) {


		LocalTO local = localService.findLocalById(2);
		
		VagaTO vaga = new VagaTO();
		vaga.setLocal(local);
		vaga.setDescricao("descricaoTeste");
		//vagaService.save(vaga);
		
				
				
		return vaga.toString();
	}
	
	@RequestMapping("/createlocal")
	public @ResponseBody String createLocal(String nome, String endereco, Integer numero, String cidade, String estado, String tipo, Double latitude, Double longitude) {
		
		LocalTO local = new LocalTO(tipo);
		local.setNome(nome);
		local.setEndereco(endereco);
		local.setNumero(numero);
		local.setCidade(cidade);
		local.setEstado(estado);
		local.setLatitude(latitude);
		local.setLongitude(longitude);
		localService.save(local);
		
		return null;
	}
	
	
	
//
//	@RequestMapping(value = "/json", method = RequestMethod.GET)
//	@ResponseBody
//	 public String teste() {
//
//		Map m = new HashMap<String, String>();
//		m.put("teste", "teste");
//
//		JsonObject js = new JsonObject();
//		return "sonda";
//	}
//
//	
//	@RequestMapping(value = "/add", method = RequestMethod.POST)
//	public String addContact(@ModelAttribute("contact")
//	LocalTO contact, BindingResult result) {
//
//		contactService.addContact(contact);
//
//		return "redirect:/index";
//	}
//
//	@RequestMapping("/delete/{contactId}")
//	public String deleteContact(@PathVariable("contactId")
//	Integer contactId) {
//
//		contactService.removeContact(contactId);
//
//		return "redirect:/index";
//	}
}
