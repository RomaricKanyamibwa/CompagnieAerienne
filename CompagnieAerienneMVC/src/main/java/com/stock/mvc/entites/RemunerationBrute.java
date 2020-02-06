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
@Table(name="REMUNERATIONBRUTE")
public class RemunerationBrute {
	@Id	  
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	  @Column(name="IDREMBRUTE")
	 private Long idRemBrute;
	 private BigDecimal salaireBase;
	 private BigDecimal abscenceNR;
	 private BigDecimal heureSupp;
	 private BigDecimal indemniteNS;
	 private BigDecimal prime;
	
	 
	 @OneToOne(cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "retraite_idSalaire",unique=true )
	 private Salaire salaire;


	public Long getIdRemBrute() {
		return idRemBrute;
	}


	public void setIdRemBrute(Long idRemBrute) {
		this.idRemBrute = idRemBrute;
	}


	public BigDecimal getSalaireBase() {
		return salaireBase;
	}


	public void setSalaireBase(BigDecimal salaireBase) {
		this.salaireBase = salaireBase;
	}


	public BigDecimal getAbscenceNR() {
		return abscenceNR;
	}


	public void setAbscenceNR(BigDecimal abscenceNR) {
		this.abscenceNR = abscenceNR;
	}


	public BigDecimal getHeureSupp() {
		return heureSupp;
	}


	public void setHeureSupp(BigDecimal heureSupp) {
		this.heureSupp = heureSupp;
	}


	public BigDecimal getIndemniteNS() {
		return indemniteNS;
	}


	public void setIndemniteNS(BigDecimal indemniteNS) {
		this.indemniteNS = indemniteNS;
	}


	public BigDecimal getPrime() {
		return prime;
	}


	public void setPrime(BigDecimal prime) {
		this.prime = prime;
	}


	public Salaire getSalaire() {
		return salaire;
	}


	public void setSalaire(Salaire salaire) {
		this.salaire = salaire;
	}


	public RemunerationBrute(BigDecimal salaireBase, BigDecimal abscenceNR, BigDecimal heureSupp,
			BigDecimal indemniteNS, BigDecimal prime, Salaire salaire) {
		super();
		this.salaireBase = salaireBase;
		this.abscenceNR = abscenceNR;
		this.heureSupp = heureSupp;
		this.indemniteNS = indemniteNS;
		this.prime = prime;
		this.salaire = salaire;
	}


	public RemunerationBrute() {
		super();
	}

}
