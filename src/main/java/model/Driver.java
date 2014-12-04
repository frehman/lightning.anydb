package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the driver database table.
 * 
 */
@Entity
@NamedQuery(name="Driver.findAll", query="SELECT d FROM Driver d")
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="license_number")
	private Integer licenseNumber;

	@Column(name="first_name")
	private String firstName;

	private Integer id;

	@Column(name="last_name")
	private String lastName;

	@Column(name="policy_id")
	private Integer policyId;

	public Driver() {
	}

	public Integer getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(Integer licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

}