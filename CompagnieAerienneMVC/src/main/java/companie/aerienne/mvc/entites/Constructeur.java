package companie.aerienne.mvc.entites;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="Constructeur")
public class Constructeur implements Serializable {
	@Id
	@GeneratedValue(
			strategy= GenerationType.AUTO,
			generator="native"
			)
	@GenericGenerator(
			name = "native",
			strategy = "native"
			)
	@Column(name = "idConstructeur")
	private Long idConstructeur;
	@Column(name = "nomConstructeur")
	private String nomConstructeur;

//	@OneToMany(
//			mappedBy = "constructeur",
//			cascade = CascadeType.ALL,
//			orphanRemoval = true
//			)
//	private List<Type> comments = new ArrayList<>();
	
	
	
	public Constructeur(Long idConstructeur, String nomConstructeur) {
		this.idConstructeur = idConstructeur;
		this.nomConstructeur = nomConstructeur;
	}


	public Constructeur() {
}


	public Long getIdConstructeur() {
		return idConstructeur;
	}


	public void setIdConstructeur(Long idConstructeur) {
		this.idConstructeur = idConstructeur;
	}


	public String getNomConstructeur() {
		return nomConstructeur;
	}


	public void setNomConstructeur(String nomConstructeur) {
		this.nomConstructeur = nomConstructeur;
	}


}
