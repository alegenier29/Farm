package com.cgi.ferme.service.impl;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.ferme.domain.Animal;
import com.cgi.ferme.domain.NourritureAnimal;
import com.cgi.ferme.repository.AnimalRepository;
import com.cgi.ferme.service.IAnimalService;


@Service
public class AnimalServiceImpl implements IAnimalService{
	
	
	//Importer le singleton dans app 
	@Autowired
	private AnimalRepository animalRepository;
		
	
	@Override
	public Iterable<Animal> findAll() {
    	return animalRepository.findAll();
	}

	@Override
	public Animal findOne(Long id) {
		return animalRepository.findOne(id);
	}

	@Override
	public Animal saveAnimal(Animal Animal) {
		 return animalRepository.save(Animal);
	}

	@Override
	public void eatAllFood(Animal animal) {
		{
			Set<NourritureAnimal> nourritures;
			int total;
			total = 0;
//			 nourritures = animal.getNourriture(); 
//			  for (NourritureAnimal nourriture : nourritures)
//			  {  
//				 total  +=  nourriture.getQuantite();
//				 nourriture.setQuantite(0);
//			  }
			  
			  animal.setNourritureConsomme(total);
		}
		
	}

}
