package com.compagnie_aerienneboot.rest.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Affectation")
public class Affectation {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NumVol")
	private int NumVol;
	@Column(name="DateVol")
	private Date DateVol;
	@Column(name="NumAvion")
	private int NumAvion;
	@Column(name="IdPilote")
	private int IdPilote;

			
	public Affectation() {
		super();
	}
	public Affectation(int numVol, Date dateVol, int numAvion, int idPilote) {
		super();
		NumVol = numVol;
		DateVol = dateVol;
		NumAvion = numAvion;
		IdPilote = idPilote;
	}
	
		
	public Affectation(int numAvion, int idPilote) {
		NumAvion = numAvion;
		IdPilote = idPilote;
	}
	// Méthodes Get & Set
	public int getNumVol() {
		return NumVol;
	}
	public void setNumVol(int numVol) {
		NumVol = numVol;
	}
	public Date getDateVol() {
		return DateVol;
	}
	public void setDateVol(Date dateVol) {
		DateVol = dateVol;
	}
	public int getNumAvion() {
		return NumAvion;
	}
	public void setNumAvion(int numAvion) {
		NumAvion = numAvion;
	}
	public int getIdPilote() {
		return IdPilote;
	}
	public void setIdPilote(int idPilote) {
		IdPilote = idPilote;
	}
}
