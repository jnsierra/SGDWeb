package co.com.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.com.dto.BranchToPlanDTO;

@Local
public interface BranchToPlanInterface {

	public List<BranchToPlanDTO> getBranchesToPlan();
}
