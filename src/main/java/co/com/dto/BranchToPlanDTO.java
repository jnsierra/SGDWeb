package co.com.dto;

import java.io.Serializable;

public class BranchToPlanDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idPlan;
	private BranchesDTO branch;
	
	private Long neta;
	private Long tax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Long idPlan) {
		this.idPlan = idPlan;
	}

	public BranchesDTO getBranch() {
		return branch;
	}

	public void setBranch(BranchesDTO branch) {
		this.branch = branch;
	}
	
	public Long getNeta() {
		return neta;
	}

	public void setNeta(Long neta) {
		this.neta = neta;
	}

	public Long getTax() {
		return tax;
	}

	public void setTax(Long tax) {
		this.tax = tax;
	}

	@Override
	public String toString() {
		return "BranchToPlanDTO [id=" + id + ", idPlan=" + idPlan + ", branch=" + branch + ", neta=" + neta + ", tax="
				+ tax + "]";
	}
	
}
