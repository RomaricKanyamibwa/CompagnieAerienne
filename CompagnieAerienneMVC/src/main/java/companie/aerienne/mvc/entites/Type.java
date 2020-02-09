package companie.aerienne.mvc.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;;

@Entity
@Table(name = "TypeA")
@Check(constraints = "capacite >=50 AND capacite<=400")    
public class Type implements Serializable{
	
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typeavion_seq")
//    @GenericGenerator(
//        name = "typeavion_seq", 
//        strategy = "companie.aerienne.mvc.entites.StringPrefixedSequenceIdGenerator", 
//        parameters = {
//            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
//            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
//            value = "A"),
//            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	@Column(name = "typeAvion",insertable = true,unique=true,columnDefinition="VARCHAR(20)")
	private String typeAvion;
	@Column(name = "capacite")
	@ColumnDefault(value = "100")
	private Short capacite=100;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idConstructeur",nullable = false)
	private Constructeur constructeur;

	public Type() {
	}
	
	

	public Type(String typeAvion, Short capacite) {
		this.typeAvion = typeAvion;
		this.capacite = capacite;
	}

	public Type(String typeAvion, Short capacite, Constructeur constructeur) {
		this.typeAvion = typeAvion;
		this.capacite = capacite;
		this.constructeur = constructeur;
	}
	

	public String getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}

	public Short getCapacite() {
		return capacite;
	}

	public void setCapacite(Short capacite) {
		this.capacite = capacite;
	}

	public Constructeur getConstructeur() {
		return constructeur;
	}

	public void setConstructeur(Constructeur constructeur) {
		this.constructeur = constructeur;
	}
	
	public void setConstructeur(String constructeur) {
		this.constructeur = new Constructeur();
		this.constructeur.setNomConstructeur(constructeur);
	}
}
