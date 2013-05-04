package com.republicababilonia.homin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.republicababilonia.homin.api.FacebookApi;
import com.republicababilonia.homin.service.PlaceService;
import com.republicababilonia.homin.to.PlaceTO;

@Controller
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	private PlaceService placeService;

	@RequestMapping("/list")
	public @ResponseBody String listPlaces(Integer universidade, String callback) {

		List<PlaceTO> placesBD = placeService.getPlaces(universidade);
		
		List<PlaceTO> places = new ArrayList<PlaceTO>();
		places.addAll(placesBD);
		
		String retorno = new Gson().toJson(places);
		
		return callback+"("+retorno+")";
	}
	
	@RequestMapping("/popular")
	public @ResponseBody String popularPlaces(String accessToken, String callback) {

		placeService.removeAll();
		
		List<PlaceTO> places = new ArrayList<PlaceTO>();
		
		places.addAll(FacebookApi.getPlaces(0, accessToken));
		places.addAll(FacebookApi.getPlaces(1, accessToken));
		places.addAll(FacebookApi.getPlaces(2, accessToken));
		places.addAll(PlaceTO.getHardcodedPlaces(0));
		places.addAll(PlaceTO.getHardcodedPlaces(1));
		places.addAll(PlaceTO.getHardcodedPlaces(2));
		
		for (PlaceTO place : places) {
			placeService.save(place);
		}
		JsonObject obj = new JsonObject();
		obj.addProperty("result", "SUCCESS");
		return callback+"("+obj.toString()+")";
		
	}
	
	@RequestMapping("/infowindow")
	public @ResponseBody String infoWindow(Integer placeId, String callback) {

		PlaceTO place = placeService.findPlaceById(placeId);

		StringBuffer sb = new StringBuffer();
		String enderecoFormatado = null;
		String sexoTipoDistanciaUniversidade = null;
		String preco = null;
		String descricao = null;

		sb.append("<div class=\"infowindow\">");
		sb.append("<div class=\"titulo\">");
		sb.append(place.getNome());
		sb.append("</div>");
		sb.append("<div class=\"leftColumn\">");
		sb.append("<img src=\""+ place.getPic() +"\" />");
		sb.append("</div>");
		sb.append("<div class=\"rightColumn\">");
		sb.append("<span>"+place.getDescricao() +"</span><br/><br/>");
		sb.append("</div>");
		sb.append("</div>");
		
		JsonObject obj = new JsonObject();
		obj.addProperty("content", sb.toString());
		
		return callback+"("+obj.toString()+")";

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
