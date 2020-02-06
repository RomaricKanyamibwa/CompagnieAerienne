package com.stock.mvc.entites;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="IMPOTS")
public class Impots {
	 @Id	  
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 @Column(name="IDIMPOTS")
	 private Long idImpots; 
	 private BigDecimal netAvantImpot;
	 private BigDecimal totalVerseEmployeur;
	 private BigDecimal baseImpot;
	 private BigDecimal tauxPersonnalise;
	 private BigDecimal montantPrelevImpot;
	 
	 @OneToOne(cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "impots_idSalaire",unique=true )
	 private Salaire salaire;

	public Long getIdImpots() {
		return idImpots;
	}

	public void setIdImpots(Long idImpots) {
		this.idImpots = idImpots;
	}

	public BigDecimal getNetAvantImpot() {
		return netAvantImpot;
	}

	public void setNetAvantImpot(BigDecimal netAvantImpot) {
		this.netAvantImpot = netAvantImpot;
	}

	public BigDecimal getTotalVerseEmployeur() {
		return totalVerseEmployeur;
	}

	public void setTotalVerseEmployeur(BigDecimal totalVerseEmployeur) {
		this.totalVerseEmployeur = totalVerseEmployeur;
	}

	public BigDecimal getBaseImpot() {
		return baseImpot;
	}

	public void setBaseImpot(BigDecimal baseImpot) {
		this.baseImpot = baseImpot;
	}

	public BigDecimal getTauxPersonnalise() {
		return tauxPersonnalise;
	}

	public void setTauxPersonnalise(BigDecimal tauxPersonnalise) {
		this.tauxPersonnalise = tauxPersonnalise;
	}

	public BigDecimal getMontantPrelevImpot() {
		return montantPrelevImpot;
	}

	public void setMontantPrelevImpot(BigDecimal montantPrelevImpot) {
		this.montantPrelevImpot = montantPrelevImpot;
	}

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public Impots(BigDecimal netAvantImpot, BigDecimal totalVerseEmployeur, BigDecimal baseImpot,
			BigDecimal tauxPersonnalise, BigDecimal montantPrelevImpot, Salaire salaire) {
		super();
		this.netAvantImpot = netAvantImpot;
		this.totalVerseEmployeur = totalVerseEmployeur;
		this.baseImpot = baseImpot;
		this.tauxPersonnalise = tauxPersonnalise;
		this.montantPrelevImpot = montantPrelevImpot;
		this.salaire = salaire;
	}

	public Impots() {
		super();
	}
	 
	 
}
