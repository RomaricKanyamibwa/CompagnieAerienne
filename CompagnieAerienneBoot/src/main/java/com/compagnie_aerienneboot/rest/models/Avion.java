package com.compagnie_aerienneboot.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Avion")
@SequenceGenerator(name="Avion_seq", initialValue=100, allocationSize=1)
public class Avion {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Avion_seq")
	@Column(name = "NumAvion")
	private Long NumAvion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "typeAvion",nullable = false)
	private Type typeAvion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "IdAeroport",nullable = false)
	private Aeroport baseAeroport;
	
	public Avion() {
	}

	public Avion(Long numAvion) {
		NumAvion = numAvion;
	}

	public Avion(Type typeAvion, Aeroport baseAeroport) {
		this.typeAvion = typeAvion;
		this.baseAeroport = baseAeroport;
	}

	public Avion(Long numAvion, Type typeAvion, Aeroport baseAeroport) {
		NumAvion = numAvion;
		this.typeAvion = typeAvion;
		this.baseAeroport = baseAeroport;
	}

	public Long getNumAvion() {
		return NumAvion;
	}

	public void setNumAvion(Long numAvion) {
		NumAvion = numAvion;
	}

	public Type getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(Type typeAvion) {
		this.typeAvion = typeAvion;
	}

	public Aeroport getBaseAeroport() {
		return baseAeroport;
	}

	public void setBaseAeroport(Aeroport baseAeroport) {
		this.baseAeroport = baseAeroport;
	}
	
		
	
	
}
