package companie.aerienne.mvc.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PK_KeyAffectation implements Serializable {
	
	private String NumVol;
	private String DateVol;
	
	
	public PK_KeyAffectation() {
	}


	public PK_KeyAffectation(String numVol, String dateVol) {
		NumVol = numVol;
		DateVol = dateVol;
	}


	public String getNumVol() {
		return NumVol;
	}


	public void setNumVol(String numVol) {
		NumVol = numVol;
	}


	public String getDateVol() {
		return DateVol;
	}


	public void setDateVol(String dateVol) {
		DateVol = dateVol;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DateVol == null) ? 0 : DateVol.hashCode());
		result = prime * result + ((NumVol == null) ? 0 : NumVol.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PK_KeyAffectation other = (PK_KeyAffectation) obj;
		if (DateVol == null) {
			if (other.DateVol != null)
				return false;
		} else if (!DateVol.equals(other.DateVol))
			return false;
		if (NumVol == null) {
			if (other.NumVol != null)
				return false;
		} else if (!NumVol.equals(other.NumVol))
			return false;
		return true;
	}
	
	
}
