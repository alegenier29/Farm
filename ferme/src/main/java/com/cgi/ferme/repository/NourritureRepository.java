package com.cgi.ferme.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.ferme.domain.Fermier;
import com.cgi.ferme.domain.Nourriture;

@Repository
public interface NourritureRepository extends CrudRepository<Nourriture, Long> {

}
