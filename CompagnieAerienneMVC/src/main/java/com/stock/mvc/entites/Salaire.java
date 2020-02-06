package com.stock.mvc.entites;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="SALAIRE")
public class Salaire implements Serializable {
	
	  @Id	  
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long idSalaire;
	  private BigDecimal salaireNet;
	  private BigDecimal congesPayes;
	  private String dateNetPaye;
	  
	  @Column(name="idEmployeur",nullable = false)
	  private Long idEmployeur;
	  
	 

}
