package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the candidate database table.
 * 
 */
@Entity
@NamedQuery(name="Candidate.findAll", query="SELECT c FROM Candidate c")
public class Candidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcandidate;

	private String firstName;

	private String lastName;

	public Candidate() {
	}

	public int getIdcandidate() {
		return this.idcandidate;
	}

	public void setIdcandidate(int idcandidate) {
		this.idcandidate = idcandidate;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}