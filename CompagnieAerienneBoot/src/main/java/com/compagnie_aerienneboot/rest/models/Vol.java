package com.compagnie_aerienneboot.rest.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Vol")
//@Check(constraints = " CAST(Hdepart AS time) <") 
public class Vol {
	
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "numvol_seq")
    @GenericGenerator(
        name = "numvol_seq", 
        strategy = "com.compagnie_aerienneboot.rest.models.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
            value = "IT"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	@Column(name = "NumVol",insertable = true,columnDefinition="VARCHAR(5)")
	private String NumVol;
	
	@Column(name="AeroportDept",columnDefinition="VARCHAR(3)")
	private String AeroportDept;
	
	@Column(name="AeroportArr",columnDefinition="VARCHAR(3)")
	private String AeroportArr;
	
	@Column(name="Hdepart",columnDefinition="TIME")
	private String Hdepart;
	
	@Column(name="HArrivee",columnDefinition="TIME")
	private String HArrivee;
	
//	@OneToOne(mappedBy = "vol",fetch = FetchType.LAZY)
//	private Affectation affectation;
	
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

		
	public Vol(String numVol, String aeroportDept, String aeroportArr, String hdepart, String hArrivee,
			Affectation affectation) {
		NumVol = numVol;
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
		Hdepart = hdepart;
		HArrivee = hArrivee;
//		this.affectation = affectation;
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



//	public Affectation getAffectation() {
//		return affectation;
//	}
//
//
//
//	public void setAffectation(Affectation affectation) {
//		this.affectation = affectation;
//	}
}
