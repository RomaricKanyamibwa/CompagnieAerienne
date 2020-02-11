package companie.aerienne.mvc.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="Vol")
public class Vol {
	
	
	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "numvol_seq")
    @GenericGenerator(
        name = "numvol_seq", 
        strategy = "companie.aerienne.mvc.entites.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,
            value = "IT"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	@Column(name = "NumVol",insertable = true,columnDefinition="VARCHAR(5)")
	private String NumVol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AeroportDept")
	private Aeroport AeroportDept;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AeroportArr")
	private Aeroport AeroportArr;
	
	@Column(name="Hdepart",columnDefinition="TIME")
	private String Hdepart;
	
	@Column(name="HArrivee",columnDefinition="TIME")
	private String HArrivee;
	
//	@OneToOne(mappedBy = "vol",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Affectation affectation;
	
	// Constructeurs
	public Vol() {
		super();
	}
	
	
	
	
	public Vol(String numVol) {
		NumVol = numVol;
	}




	public Vol(Aeroport aeroportDept, Aeroport aeroportArr) {
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
	}



	public Vol(Aeroport aeroportDept, Aeroport aeroportArr, String hdepart, String hArrivee) {
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
		Hdepart = hdepart;
		HArrivee = hArrivee;
	}



	public Vol(String numVol, Aeroport aeroportDept, Aeroport aeroportArr, String hdepart, String hArrivee) {
		super();
		NumVol = numVol;
		AeroportDept = aeroportDept;
		AeroportArr = aeroportArr;
		Hdepart = hdepart;
		HArrivee = hArrivee;
	}

	public String getNumVol() {
		return NumVol;
	}
	public void setNumVol(String numVol) {
		NumVol = numVol;
	}
	public Aeroport getAeroportDept() {
		return AeroportDept;
	}
	public void setAeroportDept(Aeroport aeroportDept) {
		AeroportDept = aeroportDept;
	}
	public Aeroport getAeroportArr() {
		return AeroportArr;
	}
	public void setAeroportArr(Aeroport aeroportArr) {
		AeroportArr = aeroportArr;
	}
	public String getHdepart() {
		return Hdepart;
	}
	public void setHdepart(String hdepart) {
		Hdepart = hdepart;
	}
	public String getHArrivee() {
		return HArrivee;
	}
	public void setHArrivee(String hArrivee) {
		HArrivee = hArrivee;
	}

}
