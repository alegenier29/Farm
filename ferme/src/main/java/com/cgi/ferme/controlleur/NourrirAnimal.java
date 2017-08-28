package com.cgi.ferme.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import com.cgi.ferme.service.INourrirAnimalService;

@Controller
public class NourrirAnimal {
	
	@Autowired
	private INourrirAnimalService nourrirAnimalService;
	

}
