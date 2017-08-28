package com.cgi.ferme.service;


import com.cgi.ferme.domain.Nourriture;

public interface INourritureService {
	
	
	public Iterable<Nourriture> findAll();
	public Nourriture findOne(Long id);

}
