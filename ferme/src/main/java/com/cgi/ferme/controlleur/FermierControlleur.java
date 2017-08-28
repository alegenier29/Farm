package com.cgi.ferme.controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.cgi.ferme.domain.Fermier;
import com.cgi.ferme.service.IFermierService;

@Controller
public class FermierControlleur {
	
	@Autowired
	private IFermierService fermierService;
	
	 @RequestMapping("/fermier")
	    private String ListFermiers(Model model) {
	  		model.addAttribute("listfermiers", fermierService.findAll());
	        return "fermier";
	    }
	 
	 
	//Un fermier en particulier
	 @RequestMapping("/fermier/{id}")
	  public  String get(Model model,  @PathVariable long id) {
	    model.addAttribute("fermiers",fermierService.findOne(id));
	    		
	        return "fermier";
	    }
	 
		 
		 
		 @RequestMapping(value="/ajouterFermier")
		    public String fermierForm(Model model) {
		        model.addAttribute("fermier", new Fermier());
		        return "ajouterFermier";
		    }
		
		  
		 @RequestMapping(value="ajouterFermier", method=RequestMethod.POST)
		    public String saveFermier(Fermier fermier) {
			     fermierService.saveFermier(fermier);
		         return "redirect:/ajouterFerme" ;
		    }

		 

}
