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
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdAeroport",columnDefinition = "VARCHAR(3)",length = 3)
	private String IdAeroport;
	@Column(name="NomAeroport",nullable = false)
	private String NomAeroport;
	@Column(name="NomVilleDesservie",columnDefinition = "VARCHAR(50)")
	private String NomVilleDesservie;
	
			
	// Constructeurs
	public Aeroport() {
		super();
	}
	public Aeroport(String idAeroport, String nomAeroport, String nomVilleDesservie) {
		super();
		IdAeroport = idAeroport;
		NomAeroport = nomAeroport;
		NomVilleDesservie = nomVilleDesservie;
	}
	
	
	// Méthodes Get & Set
	public String getIdAeroport() {
		return IdAeroport;
	}
	public void setIdAeroport(String idAeroport) {
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
