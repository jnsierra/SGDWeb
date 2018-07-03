package co.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.com.dto.BranchesDTO;
import co.com.interfaces.BranchesInterface;

@Stateless
public class BranchesService implements BranchesInterface {

	@Override
	public List<BranchesDTO> getListBranches() {
		List<BranchesDTO> listBranches = new ArrayList<>();
		
		BranchesDTO branch1 = new BranchesDTO();
		branch1.setCode("001");
		branch1.setId(Long.valueOf("1"));
		BranchesDTO branch2 = new BranchesDTO();
		branch2.setCode("002");
		branch2.setId(Long.valueOf("2"));
		BranchesDTO branch3 = new BranchesDTO();
		branch3.setCode("003");
		branch3.setId(Long.valueOf("3"));
		
		listBranches.add(branch1);
		listBranches.add(branch2);
		listBranches.add(branch3);
		
		return listBranches;
	}

}
