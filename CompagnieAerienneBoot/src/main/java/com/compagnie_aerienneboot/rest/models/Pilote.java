package com.compagnie_aerienneboot.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="Pilote"
,uniqueConstraints = {@UniqueConstraint(columnNames = {"NomPilote","PrenomPilote"})})
public class Pilote {
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IdPilote")
	private Integer IdPilote;
	@Column(name="NomPilote",columnDefinition="VARCHAR(50)",nullable = false)
	private String NomPilote; 
	@Column(name="PrenomPilote",columnDefinition="VARCHAR(30)",nullable = false)
	private String PrenomPilote;
	
	
	// Constructeurs
	public Pilote() {
		super();
	}
	
	public Pilote(Integer idPilote, String nomPilote, String prenomPilote) {
		super();
		IdPilote = idPilote;
		NomPilote = nomPilote;
		PrenomPilote = prenomPilote;
	}	
	
	public Pilote(String nomPilote, String prenomPilote) {
		NomPilote = nomPilote;
		PrenomPilote = prenomPilote;
	}
	
	public Integer getIdPilote() {
		return IdPilote;
	}
	public void setIdPilote(Integer idPilote) {
		IdPilote = idPilote;
	}
	public String getNomPilote() {
		return NomPilote;
	}
	public void setNomPilote(String nomPilote) {
		NomPilote = nomPilote;
	}
	public String getPrenomPilote() {
		return PrenomPilote;
	}
	public void setPrenomPilote(String prenomPilote) {
		PrenomPilote = prenomPilote;
	}
	
	
}