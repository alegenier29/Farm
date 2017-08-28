package com.cgi.ferme.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cgi.ferme.service.INourritureService;

@Controller
public class NourritureControlleur {
	
	@Autowired
	private INourritureService nourritureService;
	

	@RequestMapping("/nourriture")
	    private String ListAnimal(Model model) {
	  		model.addAttribute("listnourriture", nourritureService.findAll());
	        return "nourriture";
	    }
	 
	 
	 //Une nourriture en particulier
	 @RequestMapping("/nourriture/{id}")
	  public  String get(Model model, @PathVariable long id) {
	    model.addAttribute("nourriture",nourritureService.findOne(id));
	       return "nourriture" ;
	    }

}

