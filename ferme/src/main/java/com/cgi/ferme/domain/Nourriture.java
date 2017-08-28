package com.cgi.ferme.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="NOURRITURE")
public class Nourriture extends BaseEntity {
	
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="QUANTITE")
	private int quantite;
	
	@OneToOne
	private Animal animal;
	
	
	// Mapping - table NourritureType
	@OneToOne
	@JoinColumn(name="TYPE_NOURRITURE_ID")
	private NourritureType nourrituretype;
		
	
	
	//Getter - Setter 
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public NourritureType getNourrituretype() {
		return nourrituretype;
	}

	public void setNourrituretype(NourritureType nourrituretype) {
		this.nourrituretype = nourrituretype;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


}
