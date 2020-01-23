package com.compagnie_aerienneboot.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
@Entity
@Table(name = "TypeA")
//@Check(constraints = "COL_A IS NULL OR COL_B IS NOT NULL")    
public class Type {
	
	@Id
	@Column(name = "typeAvion",unique=true,columnDefinition="VARCHAR(20)")
	private String typeAvion;
	@Column(name = "capacite")
	private Short capacite;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idConstructeur")
	private Constructeur constructeur;

	public Type(String typeAvion, Short capacite) {
		this.typeAvion = typeAvion;
		this.capacite = capacite;
	}

	public Type(String typeAvion, Short capacite, Constructeur constructeur) {
		this.typeAvion = typeAvion;
		this.capacite = capacite;
		this.constructeur = constructeur;
	}
	

	public String getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public Short getCapacite() {
		return capacite;
	}

	public void setCapacite(Short capacite) {
		this.capacite = capacite;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}
	
	
	
	

}
