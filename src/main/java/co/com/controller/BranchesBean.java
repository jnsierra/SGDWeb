package co.com.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;

import co.com.dto.BranchToPlanDTO;
import co.com.dto.BranchesDTO;
import co.com.interfaces.BranchToPlanInterface;
import co.com.interfaces.BranchesInterface;

@Named
@ViewScoped
public class BranchesBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private BranchesInterface brancheService;
	@Inject
	private BranchToPlanInterface branchesToPlanService;

	private String codigo;
	
	private BranchToPlanDTO editObject;
	private Long totalImpuesto;

	private List<BranchesDTO> branches;
	private List<BranchToPlanDTO> branchesToPlanNew;
	private List<BranchToPlanDTO> branchesToPlanOld;

	@PostConstruct
	private void init() {
		branches = brancheService.getListBranches();
		branchesToPlanOld = branchesToPlanService.getBranchesToPlan();
		createNewBranches();
	}

	public List<BranchesDTO> getBranches() {
		return branches;
	}

	public void setBranches(List<BranchesDTO> branches) {
		this.branches = branches;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<BranchToPlanDTO> getBranchesToPlanNew() {
		return branchesToPlanNew;
	}

	public void setBranchesToPlanNew(List<BranchToPlanDTO> branchesToPlanNew) {
		this.branchesToPlanNew = branchesToPlanNew;
	}

	public List<BranchToPlanDTO> getBranchesToPlanOld() {
		return branchesToPlanOld;
	}

	public void setBranchesToPlanOld(List<BranchToPlanDTO> branchesToPlanOld) {
		this.branchesToPlanOld = branchesToPlanOld;
	}

	private void createNewBranches() {
		branches.stream().parallel()
				.filter(item -> encuentraIguales(item))
				.forEach(b -> {
					if(branchesToPlanNew == null) {
						branchesToPlanNew = new ArrayList<>();
					}
					BranchToPlanDTO aux = new BranchToPlanDTO();
					aux.setBranch(b);
					aux.setNeta(Long.valueOf("0"));
					aux.setTax(Long.valueOf("0"));
					branchesToPlanNew.add(aux);
				});
		branchesToPlanNew.addAll(branchesToPlanOld);
	}

	private boolean encuentraIguales(BranchesDTO item) {
		BranchToPlanDTO aux = branchesToPlanOld.stream().parallel()
				.filter(b -> b.getBranch().getId().equals(item.getId())).findFirst().orElse(null);
		if (aux != null) {
			return false;
		} else {
			return true;
		}
	}
	
	public String getTotalNet() {
		Long total = Long.valueOf("0");
		total = branchesToPlanNew.stream().parallel().mapToLong(item -> item.getNeta()).sum();
		System.out.println("Este es el total net: " + total);
		return new DecimalFormat("###,###.##").format(total);
	}
	
	public String getTotalTax() {
		Long total = Long.valueOf("0");
		total = branchesToPlanNew.stream().parallel().mapToLong(item -> item.getTax()).sum();
		System.out.println("Este es el total tax: " + total);
		totalImpuesto = total;
		return new DecimalFormat("###,###.##").format(total);
	}
	
	public void onCellEdit(CellEditEvent event) {
		getTotalNet();
		getTotalTax();
		System.out.println("Entro al evento de editar");
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();		
		String rowKey = event.getRowKey();
		String column_Name = event.getColumn().getHeaderText();
		
		if( newValue instanceof BranchToPlanDTO ) {
			this.editObject = (BranchToPlanDTO) newValue;
		}
		
		if(newValue != null && !newValue.equals(oldValue)) {
			System.out.println("Este es el que voy a editar: "+ rowKey + "..." +  newValue +" Header: " + column_Name );
		}
	}
	
	public void ejecutaActualizacion() {
		branchesToPlanNew.forEach(System.out::println);
	}

	public Long getTotalImpuesto() {
		return totalImpuesto;
	}

	public void setTotalImpuesto(Long totalImpuesto) {
		this.totalImpuesto = totalImpuesto;
	}
	
	

}
