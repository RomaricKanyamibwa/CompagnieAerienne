package com.stock.mvc.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="table_EMPLOYEUR")
public class Employeur implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	  
	 @GeneratedValue(strategy = GenerationType.IDENTITY)	
	  @Column(name="IDEMPLOYEUR")
	 private Long idEmployeur; 
	 private String raisonso;
	 private String siret; 
	 private String codeAPE;
	 
	  @OneToMany(mappedBy="idEmployeur") 
	  private List<Salaire> salaire;

	public Long getIdEmployeur() {
		return idEmployeur;
	}

	public void setIdEmployeur(Long idEmployeur) {
		this.idEmployeur = idEmployeur;
	}

	public String getRaisonso() {
		return raisonso;
	}

	public void setRaisonso(String raisonso) {
		this.raisonso = raisonso;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getCodeAPE() {
		return codeAPE;
	}

	public void setCodeAPE(String codeAPE) {
		this.codeAPE = codeAPE;
	}

	public List<Salaire> getSalaire() {
		return salaire;
	}

	public void setSalaire(List<Salaire> salaire) {
		this.salaire = salaire;
	}

	public Employeur(String raisonso, String siret, String codeAPE, List<Salaire> salaire) {
		super();
		this.raisonso = raisonso;
		this.siret = siret;
		this.codeAPE = codeAPE;
		this.salaire = salaire;
	}

	public Employeur() {
		super();
	}
	  
	  
	 
}
