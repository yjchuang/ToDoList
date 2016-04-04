package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DOER database table.
 * 
 */
@Entity
@NamedQuery(name="Doer.findAll", query="SELECT d FROM Doer d")
public class Doer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long doerid;

	private String doername;

	public Doer() {
	}

	public long getDoerid() {
		return this.doerid;
	}

	public void setDoerid(long doerid) {
		this.doerid = doerid;
	}

	public String getDoername() {
		return this.doername;
	}

	public void setDoername(String doername) {
		this.doername = doername;
	}

}