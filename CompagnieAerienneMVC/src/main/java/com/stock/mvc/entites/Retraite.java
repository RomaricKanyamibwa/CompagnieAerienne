package com.stock.mvc.entites;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
@Table(name="RETRAITE")
public class Retraite implements Serializable{
	
	 @Id	  
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	 @Column(name="IDEMPLOYEUR")
	 private Long idRetraite;
	  private BigDecimal secuPlafon;
	  private BigDecimal secuDeplafon;
	  private BigDecimal compleT1;
	  private BigDecimal compleT2;
	  private BigDecimal supple;
	  
	  @OneToOne(cascade = CascadeType.PERSIST)
	  @JoinColumn(name = "retraite_idSalaire",unique=true )
	  private Salaire salaire;

	public Long getIdRetraite() {
		return idRetraite;
	}

	public void setIdRetraite(Long idRetraite) {
		this.idRetraite = idRetraite;
	}

	public BigDecimal getSecuPlafon() {
		return secuPlafon;
	}

	public void setSecuPlafon(BigDecimal secuPlafon) {
		this.secuPlafon = secuPlafon;
	}

	public BigDecimal getSecuDeplafon() {
		return secuDeplafon;
	}

	public void setSecuDeplafon(BigDecimal secuDeplafon) {
		this.secuDeplafon = secuDeplafon;
	}

	public BigDecimal getCompleT1() {
		return compleT1;
	}

	public void setCompleT1(BigDecimal compleT1) {
		this.compleT1 = compleT1;
	}

	public BigDecimal getCompleT2() {
		return compleT2;
	}

	public void setCompleT2(BigDecimal compleT2) {
		this.compleT2 = compleT2;
	}

	public BigDecimal getSupple() {
		return supple;
	}

	public void setSupple(BigDecimal supple) {
		this.supple = supple;
	}

	public Salaire getSalaire() {
		return salaire;
	}

	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}

	public Retraite(BigDecimal secuPlafon, BigDecimal secuDeplafon, BigDecimal compleT1, BigDecimal compleT2,
			BigDecimal supple, Salaire salaire) {
		super();
		this.secuPlafon = secuPlafon;
		this.secuDeplafon = secuDeplafon;
		this.compleT1 = compleT1;
		this.compleT2 = compleT2;
		this.supple = supple;
		this.salaire = salaire;
	}

	public Retraite() {
		super();
	}
	
}
