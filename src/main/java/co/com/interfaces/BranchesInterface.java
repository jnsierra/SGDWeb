package co.com.interfaces;

import java.util.List;

import javax.ejb.Local;

import co.com.dto.BranchesDTO;

@Local
public interface BranchesInterface {
	
	public List<BranchesDTO> getListBranches();
	
}
