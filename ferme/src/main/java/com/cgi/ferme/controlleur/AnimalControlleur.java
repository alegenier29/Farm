package com.cgi.ferme.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cgi.ferme.domain.Animal;
import com.cgi.ferme.domain.Nourriture;
import com.cgi.ferme.domain.NourritureAnimal;
import com.cgi.ferme.domain.NourritureAnimalId;
import com.cgi.ferme.service.IAnimalService;
import com.cgi.ferme.service.INourritureAnimalService;
import com.cgi.ferme.service.INourritureService;


@Controller
public class AnimalControlleur {
	
	@Autowired
	private IAnimalService animalService;

	@Autowired
	private INourritureService nourritureService;
	
	@Autowired
	private INourritureAnimalService nourritureAnimalService;
	
	
	 @RequestMapping("/animal")
	    private String ListAnimal(Model model) {
	  		model.addAttribute("listanimal", animalService.findAll());
	        return "animal";
	    }
	 
	 
	 //Un Animal en particulier
	 @RequestMapping("/animal/{id}")
	  public  String get(Model model, @PathVariable long id) {
	    model.addAttribute("listanimal",animalService.findOne(id));
        return "redirect:/ajouterFerme";
	    }
	 
	 
	 // Ajouter un Animal dans ferme
	 @RequestMapping(value="/ajouterAnimal")
	    public String AnimalForm(Model model) {
	        model.addAttribute("Animal", new Animal());
	        model.addAttribute("animaux", animalService.findAll());
	        model.addAttribute("nourriture", nourritureService.findAll());
	        return "ajouterAnimal";
	    }
	
	  
	 @RequestMapping(value="ajouterAnimal", method=RequestMethod.POST)
	    public String saveAnimal(Animal animal) {
		     animalService.saveAnimal(animal);
	         return "redirect:/animal/" + animal.getId() ;
	    }
	 
	 
	// Ajouter un Animal dans ferme
		 @RequestMapping(value="/ajouterNourritureAnimal")
		    public String NourritureAnimalForm(Model model) {
		        model.addAttribute("nourritureAnimal", new NourritureAnimal());
		        model.addAttribute("animaux", animalService.findAll());
		        model.addAttribute("nourriture", nourritureService.findAll());
		        return "ajouterNourritureAnimal";
		    }
		
		
      
		 @RequestMapping(value = "ajouterNourritureAnimal", method = RequestMethod.POST)
			public String saveNourritureAnimal(Animal animal, Nourriture nourriture, int quantite) {
				NourritureAnimal na = new NourritureAnimal();
				NourritureAnimalId id = new NourritureAnimalId();

				id.setAnimal(animal);
				id.setNourriture(nourriture);

				na.setId(id);
				na.setQuantite(quantite);

				
				nourritureAnimalService.saveNourritureAnimal(na);
				return "ajouterNourritureAnimal";
			} 

		


		 

}
