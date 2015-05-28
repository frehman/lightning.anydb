package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the CandidatExternal database table.
 * 
 */
@Entity
@NamedQuery(name="CandidatExternal.findAll", query="SELECT c FROM CandidatExternal c")
public class CandidatExternal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String email;

	private String firstName;

	private String lastName;

	public CandidatExternal() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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