package com.compagnie_aerienneboot.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Avion")
public class Pilote {
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdPilote")
	private int IdPilote;
	@Column(name="NomPilote")
	private String NomPilote;
	@Column(name="PrenomPilote")
	private String PrenomPilote;
	
	
	// Constructeurs
	public Pilote() {
		super();
	}
	public Pilote(int idPilote, String nomPilote, String prenomPilote) {
		super();
		IdPilote = idPilote;
		NomPilote = nomPilote;
		PrenomPilote = prenomPilote;
	}
}