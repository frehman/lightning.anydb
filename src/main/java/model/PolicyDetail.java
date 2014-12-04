package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the policy_details database table.
 * 
 */
@Entity
@Table(name="policy_details")
@NamedQuery(name="PolicyDetail.findAll", query="SELECT p FROM PolicyDetail p")
public class PolicyDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="policy_id")
	private Integer policyId;

	@Column(name="customer_name")
	private String customerName;

	@Column(name="policy_name")
	private String policyName;

	public PolicyDetail() {
	}

	public Integer getPolicyId() {
		return this.policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPolicyName() {
		return this.policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

}