package com.compagnie_aerienneboot.rest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Constructeur")
public class Constructeur {
	@Id
	@GeneratedValue(
			strategy= GenerationType.AUTO,
			generator="native"
			)
	@GenericGenerator(
			name = "native",
			strategy = "native"
			)
	@Column(name = "idConstructeur")
	private Long idConstructeur;
	@Column(name = "nomConstructeur")
	private String nomConstructeur;
	
	
	public Constructeur(Long idConstructeur, String nomConstructeur) {
		this.idConstructeur = idConstructeur;
		this.nomConstructeur = nomConstructeur;
	}


	public Long getIdConstructeur() {
		return idConstructeur;
	}


	public void setIdConstructeur(Long idConstructeur) {
		this.idConstructeur = idConstructeur;
	}


	public String getNomConstructeur() {
		return nomConstructeur;
	}


	public void setNomConstructeur(String nomConstructeur) {
		this.nomConstructeur = nomConstructeur;
	}
	
	
	
	



}
