package com.republicababilonia.homin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.republicababilonia.homin.api.FacebookApi;
import com.republicababilonia.homin.service.PlaceService;
import com.republicababilonia.homin.to.PlaceTO;
import com.republicababilonia.homin.utils.Constantes;

@Controller
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;

	@RequestMapping("/list")
	public @ResponseBody String listPlaces(Integer universidade) {

		List<PlaceTO> placesBD = placeService.getPlaces(universidade);
		
		List<PlaceTO> places = new ArrayList<PlaceTO>();
		places.addAll(placesBD);
		
		String retorno = new Gson().toJson(places);
		
		return retorno;
	}
	
	@RequestMapping("/popular")
	public @ResponseBody void popularPlaces(Integer universidade, String accessToken) {

		placeService.removeAll();
		
		List<PlaceTO> places = new ArrayList<PlaceTO>();
		
		places.addAll(FacebookApi.getPlaces(universidade, accessToken));
		places.addAll(PlaceTO.getHardcodedPlaces(universidade));
		
		for (PlaceTO place : places) {
			placeService.save(place);
		}
		
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
