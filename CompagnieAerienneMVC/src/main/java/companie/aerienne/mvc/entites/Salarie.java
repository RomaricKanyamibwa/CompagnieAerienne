package companie.aerienne.mvc.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="SALARIE")
public class Salarie implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	@Column(name="NUMSECU")
	private int numsecu;
//	@ManyToOne
//	@JoinColumn(name="employeur_id")
//	private Employeur employeur;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getNumsecu() {
		return numsecu;
	}
	public void setNumsecu(int numsecu) {
		this.numsecu = numsecu;
	}
	public Salarie(String nom, String prenom, int numsecu) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numsecu = numsecu;
	}
	public Salarie() {
		super();
	}
	

}
