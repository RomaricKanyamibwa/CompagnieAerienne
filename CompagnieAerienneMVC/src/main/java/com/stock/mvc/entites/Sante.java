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
@Table(name="SANTE")
public class Sante {
	@Id	  
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	  @Column(name="IDSANTE")
	 private Long idSante;
	 private BigDecimal secuSocial;
	 private BigDecimal compleTA;
	 private BigDecimal compleTB;
	 private BigDecimal compleSante;
	 private BigDecimal maladieAT;
	 
	 @OneToOne(cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "sante_idSalaire",unique=true )
	 private Salaire salaire;

	public Long getIdSante() {
		return idSante;
	}

	public void setIdSante(Long idSante) {
		this.idSante = idSante;
	}

	public BigDecimal getSecuSocial() {
		return secuSocial;
	}

	public void setSecuSocial(BigDecimal secuSocial) {
		this.secuSocial = secuSocial;
	}

	public BigDecimal getCompleTA() {
		return compleTA;
	}

	public void setCompleTA(BigDecimal compleTA) {
		this.compleTA = compleTA;
	}

	public BigDecimal getCompleTB() {
		return compleTB;
	}

	public void setCompleTB(BigDecimal compleTB) {
		this.compleTB = compleTB;
	}

	public BigDecimal getCompleSante() {
		return compleSante;
	}

	public void setCompleSante(BigDecimal compleSante) {
		this.compleSante = compleSante;
	}

	public BigDecimal getMaladieAT() {
		return maladieAT;
	}

	public void setMaladieAT(BigDecimal maladieAT) {
		this.maladieAT = maladieAT;
	}

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public Sante(BigDecimal secuSocial, BigDecimal compleTA, BigDecimal compleTB, BigDecimal compleSante,
			BigDecimal maladieAT, Salaire salaire) {
		super();
		this.secuSocial = secuSocial;
		this.compleTA = compleTA;
		this.compleTB = compleTB;
		this.compleSante = compleSante;
		this.maladieAT = maladieAT;
		this.salaire = salaire;
	}

	public Sante() {
		super();
	}

}
