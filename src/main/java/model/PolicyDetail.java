package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the policy_details database table.
 * 
 */
@Entity
@Table(name="policy_details")
@NamedQuery(name="PolicyDetail.findAll", query="SELECT p FROM PolicyDetail p")
public class PolicyDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer policyId;
	private String customerName;
	private String ecn;
	private String policyName;
	private List<Driver> drivers;
	private List<Vehicle> vehicles;

	public PolicyDetail() {
	}


	@Id
	@Column(name="policy_id", unique=true, nullable=false)
	public Integer getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}


	@Column(name="customer_name", length=20)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	@Column(length=12)
	public String getEcn() {
		return this.ecn;
	}

	public void setEcn(String ecn) {
		this.ecn = ecn;
	}


	@Column(name="policy_name", length=10)
	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}


	//bi-directional many-to-one association to Driver
	@OneToMany(mappedBy="policyDetail", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	public List<Driver> getDrivers() {
		return this.drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public Driver addDriver(Driver driver) {
		getDrivers().add(driver);
		driver.setPolicyDetail(this);

		return driver;
	}

	public Driver removeDriver(Driver driver) {
		getDrivers().remove(driver);
		driver.setPolicyDetail(null);

		return driver;
	}


	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="policyDetail", cascade={CascadeType.ALL}, fetch=FetchType.EAGER)
	public List<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Vehicle addVehicle(Vehicle vehicle) {
		getVehicles().add(vehicle);
		vehicle.setPolicyDetail(this);

		return vehicle;
	}

	public Vehicle removeVehicle(Vehicle vehicle) {
		getVehicles().remove(vehicle);
		vehicle.setPolicyDetail(null);

		return vehicle;
	}

}