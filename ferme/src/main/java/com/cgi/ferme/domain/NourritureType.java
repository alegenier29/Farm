package com.cgi.ferme.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="NOURRITURE_TYPE")
public class NourritureType extends BaseEntity {
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="VALEUR_NUTRITIONELLE")
	private String valeur_Nutritrionelle;
	
	
	 @OneToMany(mappedBy = "nourrituretype")
	 private Set<Nourriture> nourritures; 


	// Getter- Setter
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

		
	public String getValeur_Nutritrionelle() {
		return valeur_Nutritrionelle;
	}

	public void setValeur_Nutritrionelle(String valeur_Nutritrionelle) {
		this.valeur_Nutritrionelle = valeur_Nutritrionelle;
	}
	

}
