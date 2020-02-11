package companie.aerienne.mvc.entites;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="Affectation")
public class Affectation {
	
	
	@AttributeOverrides({
	      @AttributeOverride(name="NumVol", 
	    		  column = @Column(name="NumVol",length = 5,columnDefinition="VARCHAR(5)")),
	      @AttributeOverride(name="DateVol", column = @Column(name="DateVol",columnDefinition="date"))
	    })
    @EmbeddedId
	private PK_KeyAffectation pkAffectation;
	
	@MapsId("NumVol")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NumVol")
    private Vol vol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NumAvion")
	private Avion avion;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idPilote")
	private Pilote pilote;

	public Affectation() {
		super();
	}

	public Affectation(PK_KeyAffectation pkAffectation, Vol vol, Pilote pilote) {
		this.pkAffectation = pkAffectation;
		this.vol = vol;
		this.pilote = pilote;
	}

	public Affectation(Vol vol, Pilote pilote) {
		this.vol = vol;
		this.pilote = pilote;
	}

	public PK_KeyAffectation getPkAffectation() {
		return pkAffectation;
	}

	public void setPkAffectation(PK_KeyAffectation pkAffectation) {
		this.pkAffectation = pkAffectation;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public Pilote getPilote() {
		return pilote;
	}

	public void setPilote(Pilote pilote) {
		this.pilote = pilote;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	@Override
	public String toString() {
		return "Affectation [pkAffectation=" + pkAffectation + ", vol=" + vol + ", avion=" + avion + ", pilote="
				+ pilote + "]";
	}
	
	
	
}