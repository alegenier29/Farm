package com.cgi.ferme.service;


import com.cgi.ferme.domain.NourritureAnimal;
import com.cgi.ferme.domain.NourritureAnimalId;



public interface INourritureAnimalService {
	
	public Iterable<NourritureAnimal> findAll();
	public NourritureAnimal findOne(Long id);
	NourritureAnimal saveNourritureAnimal(NourritureAnimal nourritureanimal);
	
	



}
