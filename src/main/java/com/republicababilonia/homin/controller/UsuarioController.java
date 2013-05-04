package com.republicababilonia.homin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.republicababilonia.homin.api.FacebookApi;
import com.republicababilonia.homin.service.UsuarioService;
import com.republicababilonia.homin.to.UsuarioTO;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping("/save")
	public @ResponseBody String save(String access_token, HttpServletRequest request, Integer edu) {
		
		String universidade = null;
		if(edu == 0) {
			universidade = "UNICAMP";
		} else if(edu == 1) {
			universidade = "USP";
		} else if(edu == 2) {
			universidade = "ITA";
		}
		
		
		UsuarioTO user = FacebookApi.getUsuario(access_token);
		user.setUniversidade(universidade);
		if(!usuarioService.existeUsuario(user.getUid())) {
			usuarioService.save(user);
		}
		
		request.getSession().setAttribute("USUARIO", user);
		String retorno = new Gson().toJson(user);
		return retorno;
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
