package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@Table(name="vehicle")
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;
	private String vin;
	private String licensePlate;
	private String model;
	private PolicyDetail policyDetail;

	public Vehicle() {
	}


	@Id
	@Column(unique=true, nullable=false, length=15)
	public String getVin() {
		return this.vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}


	@Column(name="license_plate", length=15)
	public String getLicensePlate() {
		return this.licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}


	@Column(length=10)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}


	//bi-directional many-to-one association to PolicyDetail
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="policy_id")
	public PolicyDetail getPolicyDetail() {
		return this.policyDetail;
	}

	public void setPolicyDetail(PolicyDetail policyDetail) {
		this.policyDetail = policyDetail;
	}

}