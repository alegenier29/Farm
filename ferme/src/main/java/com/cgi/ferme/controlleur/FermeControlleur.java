package com.cgi.ferme.controlleur;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.cgi.ferme.domain.Animal;
import com.cgi.ferme.domain.Ferme;
import com.cgi.ferme.domain.Nourriture;
import com.cgi.ferme.domain.NourritureAnimalId;
import com.cgi.ferme.domain.NourritureType;
import com.cgi.ferme.service.IAnimalService;
import com.cgi.ferme.service.IFermeService;
import com.cgi.ferme.service.IFermierService;
import com.cgi.ferme.service.INourritureService;


@Controller
public class FermeControlleur {
	
	@Autowired
	private IFermeService fermeService;
	
	@Autowired
	private IFermierService fermierService;
	
	@Autowired
	private IAnimalService animalService;
	
	@Autowired
	private INourritureService nourritureService;
	
	@RequestMapping(value= "/ferme")
	 public String getAll(Model model) {
		 model.addAttribute("fermes", fermeService.findAll());
		 return "ferme";
	    }

	 	 
	 //Un ferme en particulier
	 @RequestMapping("/ferme/{id}")
	  public  String get(Model model,@PathVariable long id) {
	    model.addAttribute("fermes",fermeService.findOne(id));
	     return "ferme";
	    }

	 
	 
	 // Mapping -  Ajouter Ferme 
	 @RequestMapping(value="/ajouterFerme")
	    public String fermeForm(Model model) {
	        model.addAttribute("ferme", new Ferme());
	        model.addAttribute("listfermiers", fermierService.findAll());
	        model.addAttribute("animaux", animalService.findAll());
	        model.addAttribute("nourriture", nourritureService.findAll());
	        return "ajouterFerme";
	    }
	
	 
	  
	 @RequestMapping(value="ajouterFerme", method=RequestMethod.POST,  params="action=save")
	    public String saveFerme(Ferme ferme,  @RequestParam(value="action", required=true) String action
	    ) 
		
	                                         
	 {       
	  
		 fermeService.saveFerme(ferme);
	         return "redirect:/ferme/" +  ferme.getId() ;
	    }
	 
	 
	 @RequestMapping(value="ajouterFerme", method=RequestMethod.POST,  params="action=AddAnimal")
	    public String saveAnimal(Ferme ferme, Animal animal, @RequestParam(value="action",  required=true) String action,
	    		@RequestParam("ferme_id") long ferme_id ,@RequestParam("animal_id") long animal_id     
	    		)
         {       
		          
		          ferme.setId(ferme_id);
		          animal.setFerme(ferme);
		          animal.setId(animal_id);
		          animalService.saveAnimal(animal);
		         return "ajouterFerme" ;
		    }
		 
	 
	 
	 
	 // Add Food objet nourriture animal

	 @RequestMapping(value="ajouterFerme", method=RequestMethod.POST, params="action=addFood")
	    public String FormFood(Model model, Ferme ferme,  Animal animal, Nourriture nourriture, @RequestParam("nourriture_id") long nourriture_id, 
	   		 																  @RequestParam("animal_id") long animal_id,  
	  		 	 
    		                                        @RequestParam("quantite") long quantite,  @RequestParam(value="action", required=true) String action)
	    {
			Nourriture na = new Nourriture();
			NourritureAnimalId id = new NourritureAnimalId();
		
            animal = animalService.findOne(animal_id);
   			animal.setType(animal.getType());
			animal.setNourritureConsomme(0);
			animal.setId(animal_id);
		    nourriture.setId(nourriture_id);
		    
		    ///////////////////////
		    Nourriture n = nourritureService.findOne(nourriture_id);
		    NourritureType nourrituretype = new NourritureType();
		    nourrituretype.setNom(n.getNom());
			nourriture.setNourrituretype(nourrituretype );
			//////////////////////////
		    
		    id.setAnimal(animal);
			id.setNourriture(nourriture);
			
//			na.setId(id);
//			na.setQuantite(quantite);
//			
		    	
			Set<Nourriture> food =  animal.getNourriture();
			food.add(na) ;
			animal.setNourriture(food);
			
			System.out.println("animal.getId():"+animal.getId());
			System.out.println("animal.getNourritureConsomme():"+animal.getNourritureConsomme());
		
			model.addAttribute("listnourriture", food);
		    model.addAttribute("animaux", animalService.findOne(animal_id));
		    model.addAttribute("nourriture", nourritureService.findAll());
		    model.addAttribute("listfermiers", fermierService.findAll());
		    model.addAttribute("animal",animal);
		 return "/ajouterferme" ;
	    }
	 
	 
	 
	
     // Mapping - Nourrir Animal
	 @RequestMapping(value="/nourrirAnimal")
	    public String nourrirAnimalForm(Model model) {
	        model.addAttribute("ferme", new Ferme());
	        model.addAttribute("listfermes", fermeService.findAll());
	     return "nourrirAnimal" ;
	    }
	
	 
	 
	 
	 
	 
	 // Search une ferme pour nourrir les animaux
	 @RequestMapping(value="nourrirAnimal", method=RequestMethod.POST, params="action=search")
	    public String saveFerme(Model model, Ferme ferme, @RequestParam("ferme_id") long ferme_id, 
	    		 @RequestParam(value="action", required=true) String action) {
		 					model.addAttribute("fermes",fermeService.findOne(ferme_id));
		 					model.addAttribute("listfermes", fermeService.findOne(ferme_id));
		       return "nourrirAnimal" ;
	    }
	 
	 
	// Nourrir les animaux de ferme selected
	 @RequestMapping(value="nourrirAnimal", method=RequestMethod.POST, params="action=nourrir")
	    public String saveNourrirFerme( @RequestParam("ferme_id") long ferme_id,
	    @RequestParam(value="action", required=true) String action)
	      {
		     Ferme ferme_eat = fermeService.findOne(ferme_id);
		     fermeService.eatAllFoodAvailable(ferme_eat);
		     fermeService.saveFerme(ferme_eat);
		     return "redirect:/ferme/" +  ferme_eat.getId() ;
	    }


}
