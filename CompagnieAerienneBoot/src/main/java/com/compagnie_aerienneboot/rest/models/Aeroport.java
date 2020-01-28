package com.compagnie_aerienneboot.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Aeroport")
public class Aeroport {
	
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdAeroport")
	private int IdAeroport;
	@Column(name="NomAeroport")
	private String NomAeroport;
	@Column(name="NomVilleDesservie")
	private String NomVilleDesservie;
	
			
	// Constructeurs
	public Aeroport() {
		super();
	}
	public Aeroport(int idAeroport, String nomAeroport, String nomVilleDesservie) {
		super();
		IdAeroport = idAeroport;
		NomAeroport = nomAeroport;
		NomVilleDesservie = nomVilleDesservie;
	}
	
	
	// Méthodes Get & Set
	public int getIdAeroport() {
		return IdAeroport;
	}
	public void setIdAeroport(int idAeroport) {
		IdAeroport = idAeroport;
	}
	public String getNomAeroport() {
		return NomAeroport;
	}
	public void setNomAeroport(String nomAeroport) {
		NomAeroport = nomAeroport;
	}
	public String getNomVilleDesservie() {
		return NomVilleDesservie;
	}
	public void setNomVilleDesservie(String nomVilleDesservie) {
		NomVilleDesservie = nomVilleDesservie;
	}
	
}
