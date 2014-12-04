package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the driver database table.
 * 
 */
@Entity
@Table(name="driver")
@NamedQuery(name="Driver.findAll", query="SELECT d FROM Driver d")
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer licenseNumber;
	private String firstName;
	private Integer id;
	private String lastName;
	private PolicyDetail policyDetail;

	public Driver() {
	}


	@Id
	@Column(name="license_number", unique=true, nullable=false)
	public Integer getLicenseNumber() {
		return this.licenseNumber;
	}

	public void setLicenseNumber(Integer licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	@Column(name="first_name", length=20)
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


	@Column(name="last_name", length=20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	//bi-directional many-to-one association to PolicyDetail
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="policyid")
	public PolicyDetail getPolicyDetail() {
		return this.policyDetail;
	}

	public void setPolicyDetail(PolicyDetail policyDetail) {
		this.policyDetail = policyDetail;
	}

}