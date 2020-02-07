package companie.aerienne.mvc.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="Pilote"
,uniqueConstraints = {@UniqueConstraint(columnNames = {"nomPilote","prenomPilote"})})
public class Pilote {
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPilote")
	private Integer idPilote;
	@Column(name="nomPilote",columnDefinition="VARCHAR(50)",nullable = false)
	private String nomPilote; 
	@Column(name="prenomPilote",columnDefinition="VARCHAR(30)",nullable = false)
	private String prenomPilote;
	
	
	// Constructeurs
	public Pilote() {
		super();
	}
	
	public Pilote(Integer idPilote, String nomPilote, String prenomPilote) {
		super();
		this.idPilote = idPilote;
		this.nomPilote = nomPilote;
		this.prenomPilote = prenomPilote;
	}	
	
	public Pilote(String nomPilote, String prenomPilote) {
		this.nomPilote = nomPilote;
		this.prenomPilote = prenomPilote;
	}
	
	public Integer getIdPilote() {
		return idPilote;
	}
	public void setIdPilote(Integer idPilote) {
		this.idPilote = idPilote;
	}
	public String getNomPilote() {
		return nomPilote;
	}
	public void setNomPilote(String nomPilote) {
		this.nomPilote = nomPilote;
	}
	public String getPrenomPilote() {
		return prenomPilote;
	}
	public void setPrenomPilote(String prenomPilote) {
		this.prenomPilote = prenomPilote;
	}
	
	
}