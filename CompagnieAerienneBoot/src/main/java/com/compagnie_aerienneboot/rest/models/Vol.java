package com.compagnie_aerienneboot.rest.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Vol")
public class Vol {
	
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeavion_seq")
    @GenericGenerator(
        name = "typeavion_seq", 
        strategy = "com.compagnie_aerienneboot.rest.models.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
            value = "IT"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%04d") })
	@Column(name = "NumVol",insertable = true,columnDefinition="VARCHAR(5)")
	private String NumVol;
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
	
	
	
	public Vol(String aeroportDept, String aeroportArr) {
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
	}



	public Vol(String aeroportDept, String aeroportArr, String hdepart, String hArrivee) {
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
		Hdepart = hdepart;
		HArrivee = hArrivee;
	}



	public Vol(String numVol, String aeroportDept, String aeroportArr, String hdepart, String hArrivee) {
		super();
		NumVol = numVol;
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
		Hdepart = hdepart;
		HArrivee = hArrivee;
	}

		
	// Méthodes Get & Set
	public String getNumVol() {
		return NumVol;
	}
	public void setNumVol(String numVol) {
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
