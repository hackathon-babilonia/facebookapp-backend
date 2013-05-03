package com.republicababilonia.homin.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.republicababilonia.homin.service.LocalService;
import com.republicababilonia.homin.to.LocalTO;
import com.republicababilonia.homin.to.RepublicaTO;

@Controller
@RequestMapping("/local")
public class LocalController {

	@Autowired
	private LocalService localService;

	@RequestMapping("/index")
	public @ResponseBody String listContacts(Map<String, Object> map) {

		RepublicaTO rep = new RepublicaTO();
		rep.setCidade("teste");
		localService.save(rep);
		
		
		List<LocalTO> place = localService.getTodosLocais();
				
				
		return place.toString();
	}
	
	@RequestMapping("/create")
	public @ResponseBody String create() {
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
