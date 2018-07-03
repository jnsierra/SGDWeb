package co.com.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.com.dto.BranchToPlanDTO;
import co.com.dto.BranchesDTO;
import co.com.interfaces.BranchToPlanInterface;

@Stateless
public class BranchesToPlanService implements BranchToPlanInterface {

	@Override
	public List<BranchToPlanDTO> getBranchesToPlan() {
		List<BranchToPlanDTO> list = new ArrayList<>();
		BranchToPlanDTO item = new BranchToPlanDTO();
		item.setId(Long.valueOf("1"));
		item.setIdPlan(Long.valueOf("2"));
		item.setNeta(Long.valueOf("40"));
		item.setTax(Long.valueOf("30"));
		
		BranchesDTO branch1 = new BranchesDTO();
		branch1.setCode("001aaa");
		branch1.setId(Long.valueOf("1"));
		
		item.setBranch(branch1);
		
		list.add(item);
		return list;
	}

}
