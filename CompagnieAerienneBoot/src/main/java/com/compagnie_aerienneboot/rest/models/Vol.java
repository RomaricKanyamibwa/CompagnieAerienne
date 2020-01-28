package com.compagnie_aerienneboot.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Vol")
public class Vol {
	
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="NumVol")
	private int NumVol;
	@Column(name="AeroportDept")
	private String AeroportDept;
	@Column(name="AeroportArr")
	private String AeroportArr;
	@Column(name="Hdepart")
	private String Hdepart;
	@Column(name="HArrivee")
	private String HArrivee;

	
	// Constructeurs
	public Vol() {
		super();
	}
	public Vol(int numVol, String aeroportDept, String aeroportArr, String hdepart, String hArrivee) {
		super();
		NumVol = numVol;
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
		Hdepart = hdepart;
		HArrivee = hArrivee;
	}

		
	// Méthodes Get & Set
	public int getNumVol() {
		return NumVol;
	}
	public void setNumVol(int numVol) {
		NumVol = numVol;
	}
	public String getAeroportDept() {
		return AeroportDept;
	}
	public void setAeroportDept(String aeroportDept) {
		AeroportDept = aeroportDept;
	}
	public String getAeroportArr() {
		return AeroportArr;
	}
	public void setAeroportArr(String aeroportArr) {
		AeroportArr = aeroportArr;
	}
	public String getHdepart() {
		return Hdepart;
	}
	public void setHdepart(String hdepart) {
		Hdepart = hdepart;
	}
	public String getHArrivee() {
		return HArrivee;
	}
	public void setHArrivee(String hArrivee) {
		HArrivee = hArrivee;
	}
}
